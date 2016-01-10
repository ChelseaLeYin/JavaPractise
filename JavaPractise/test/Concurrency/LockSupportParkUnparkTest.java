package Concurrency;

import java.util.concurrent.locks.LockSupport;

public class LockSupportParkUnparkTest {
	
	private static Thread mainThread;

	public static void main(String[] args) {
		mainThread = Thread.currentThread();
		
		Thread threadA = new MyThread("Thread A");
		System.out.println(Thread.currentThread().getName()+" start thread A");
		threadA.start();
		
		System.out.println(Thread.currentThread().getName()+" block");
		LockSupport.park(mainThread);//判断当前线程有没有mainThread这个对象的permit,如果有则继续，没有则当前线程block。
		
		System.out.println(Thread.currentThread().getName()+" finish");
	}
	
	static class MyThread extends Thread {
		public MyThread(String name) {
			super(name);
		}
		
		public void run() {
			System.out.println(Thread.currentThread().getName()+" wake up main thread");
            // 唤醒“主线程”
            LockSupport.unpark(mainThread);//set the permit of main thread available if it's not available 
		}
	}

}
