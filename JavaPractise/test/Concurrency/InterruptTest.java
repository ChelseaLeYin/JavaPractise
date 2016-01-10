package Concurrency;

public class InterruptTest {

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new MyThread("T1");
		t1.start();
		Thread.sleep(2000);
		t1.interrupt();
	}
	
	static class MyThread extends Thread{
		
		MyThread(String name) {
			super(name);
		}
		
		@Override
		public void run() {
			try {
				int i = 0;
				while (!isInterrupted()) {
					System.out.println(Thread.currentThread() + this.getState().toString() +  i++);
					Thread.sleep(1000);
				}
			} catch (InterruptedException e) {
				System.out.println(Thread.currentThread() + e.getMessage());
			}
		}
	}
}
