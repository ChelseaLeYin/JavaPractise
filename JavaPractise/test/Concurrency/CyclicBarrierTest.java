package Concurrency;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {

	private static final int SIZE = 5;
	private static CyclicBarrier cyclicBarrier;
	
	public static void main(String[] args) {
//		cyclicBarrier = new CyclicBarrier(SIZE, new Runnable() {
//			
//			@Override
//			public void run() {
//				System.out.println("CyclicBarrier's parties is: "+ cyclicBarrier.getParties());//this runnable will get execute every time when all thread trip the barrier
//			}
//		});
		
		cyclicBarrier = new CyclicBarrier(SIZE);
		
		for(int i=0; i<SIZE; i++) {
			new MyInnerThread("Thread" + i).start();
		}
		
	}
	
	static class MyInnerThread extends Thread{
		MyInnerThread (String name) {
			super(name);
		}
		public void run() {
			try {
				System.out.println(Thread.currentThread().getName() + " is running");
				cyclicBarrier.await();//one thread trip the barrier. if the total count meet the SIZE, then each thread continue and barrier get cleared.
				
				System.out.println(Thread.currentThread().getName() + " continue running");
				cyclicBarrier.await();//one thread trip the barrier. if the total count meet the SIZE, then each thread continue and barrier get cleared.
				
				System.out.println(Thread.currentThread().getName() + " continue running and running");
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}