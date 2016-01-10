package Concurrency;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

	public static int LATCH_SIZE = 5;
	private static CountDownLatch countDownLatch;
	
	public static void main(String[] args) {
		countDownLatch = new CountDownLatch(LATCH_SIZE);
		
		for (int i=0; i<LATCH_SIZE; i++) {
			new MyInnerThread("Thread" + i).start();
		}
		
		try {
			countDownLatch.await();
			System.out.println(Thread.currentThread().getName() + " is running");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	static class MyInnerThread extends Thread{
		MyInnerThread (String name) {
			super(name);
		}
		public void run() {
			try {
				System.out.println(Thread.currentThread().getName() + " is running");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				countDownLatch.countDown();
			}
		}
	}

}
