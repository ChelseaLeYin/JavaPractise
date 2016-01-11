package ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPoolSimpleTest {
	public static void main(String[] args) throws InterruptedException {
		ExecutorService threadPool = Executors.newFixedThreadPool(3);//corePoolSize = maxPoolSize = 3
		threadPool.execute(new MyRunnable());
		threadPool.execute(new MyRunnable());
		threadPool.execute(new MyRunnable());
		threadPool.execute(new MyRunnable());//this task will wait in queue until one of 3 thread pick it
		threadPool.shutdown();
	}
	
	static class MyRunnable implements Runnable {
		
		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName() + " is running!");
		}
	}
}

