package Concurrency;

public class JoinTest {
	
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i<10; i++) {
					System.out.println(Thread.currentThread() + " is still running " + i);
				}
			}
			
		});
		
		t1.start();
		t1.join();// main thread cannot continue until t1 finished
		System.out.println(Thread.currentThread() + " is running ");
	}
}
