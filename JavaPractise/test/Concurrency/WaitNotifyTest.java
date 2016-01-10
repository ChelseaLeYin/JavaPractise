package Concurrency;

public class WaitNotifyTest {

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName() + " is running and running ");
				while(true)// a thread who keeps running
					;
			}
		});
		
		synchronized(t1) {
			System.out.println(Thread.currentThread().getName() + " thread start t1");//main thread starts t1
			t1.start();// new status -> ready status -> running status
			
			System.out.println(Thread.currentThread().getName() + " thread call wait ");// main thread call wait
			t1.wait(3000);
			
			System.out.println(Thread.currentThread().getName() + " thread continue");//after 3s, main thread continue
		}
	}

}
