package Concurrency;

public class WaitNotifyAllTest {
	
	public static final Object obj = new Object();

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new MyThread();
		Thread t2 = new MyThread();
		Thread t3 = new MyThread();
		
		t1.start();
		t2.start();
		t3.start();// after this, t1,t2,t3 will all be waiting
		
		Thread.sleep(3000);//main thread sleep 3s
		
		synchronized(obj) {// main thread get the lock
            System.out.println(Thread.currentThread().getName()+" notifyAll()");
            obj.notifyAll();//after this, t1, t2, t3 get notified, but didn't get the lock until next statement
            System.out.println(Thread.currentThread().getName()+" is still the current thread");
        }
	}

	static class MyThread extends Thread{
		public void run() {
			synchronized(obj) {
				System.out.println(Thread.currentThread().getName() + " wait");
				try {
					obj.wait(); //current thread wait
					
					System.out.println(Thread.currentThread().getName() + " continue");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

