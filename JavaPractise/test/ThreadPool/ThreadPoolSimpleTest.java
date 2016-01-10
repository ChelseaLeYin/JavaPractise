package ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPoolSimpleTest {
	public static void main(String[] args) {
		ExecutorService threadPool = Executors.newFixedThreadPool(3);
		threadPool.execute(new MyThread1());
		threadPool.execute(new MyThread1());
		threadPool.execute(new MyThread1());
		threadPool.execute(new MyThread1());
		threadPool.shutdown();
	}
	
	static class MyThread1 extends Thread {
		
		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName() + " is running!");
		}
	}
}

