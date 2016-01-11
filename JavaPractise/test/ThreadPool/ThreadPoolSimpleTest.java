package ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPoolSimpleTest {
	public static void main(String[] args) throws InterruptedException {
		ExecutorService threadPool = Executors.newFixedThreadPool(3);//corePoolSize = maxPoolSize = 3
		threadPool.execute(new MyTask(1));
		threadPool.execute(new MyTask(2));
		threadPool.execute(new MyTask(3));
		threadPool.execute(new MyTask(4));//this task will wait in queue until one of 3 thread pick it
		threadPool.shutdown();
	}
	
	static class MyTask implements Runnable {
		private int taskNum = 0;
		
		MyTask(int taskNum) {
			this.taskNum = taskNum;
		}
		@Override
		public void run() {
			System.out.println("task " + this.taskNum + " is running " + "on thread " + Thread.currentThread().getName());
		}
	}
}

