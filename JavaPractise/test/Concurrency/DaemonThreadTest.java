package Concurrency;

public class DaemonThreadTest {
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new MyThread2("T1", false);
		Thread t2 = new MyThread2("T2", true);
		System.out.println( Thread.currentThread().getName() + " " + (Thread.currentThread().isDaemon() ? Boolean.TRUE.toString() : Boolean.FALSE.toString()));
		t1.start();
		t2.start();
		
		Thread.sleep(1000);
	}
}

class MyThread2 extends Thread {
	
	public MyThread2 (String name, boolean isDaemon) {
		super(name);
		this.setDaemon(isDaemon);
	}

	public void run() {
		for (int i =0; i<5; i++) {
			System.out.println(Thread.currentThread().getName() + " " + (this.isDaemon() ? Boolean.TRUE.toString() : Boolean.FALSE.toString()) + " " + i);
			try {
				Thread.sleep(1000);
				if ("T2".equalsIgnoreCase(Thread.currentThread().getName())) {//T2 is a daemon thread. Let it sleep longer. Main thread and JVM will exit after T1 finished. 
					Thread.sleep(5000);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
