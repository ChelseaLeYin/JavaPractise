package ThreadPool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolRejectHanderTest {

	private static final int WORK_QUEUE_CAPACITY = 1;

	public static void main(String[] args) {
		ThreadPoolExecutor threadPool = new ThreadPoolExecutor(3, 3, 1000, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(WORK_QUEUE_CAPACITY));
//		threadPool.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
		threadPool.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardOldestPolicy());
		threadPool.execute(new MyTask(1));
		threadPool.execute(new MyTask(2));
		threadPool.execute(new MyTask(3));
		threadPool.execute(new MyTask(4));//if reject policy = discard oldest, then this task should be discard. no exception.
		threadPool.execute(new MyTask(5));//if reject policy = abort, then this task should be rejected and throw exception
		threadPool.shutdown();
	}
	
	static class MyTask implements Runnable {
		private int taskNum = 0;
		
		MyTask(int taskNum) {
			this.taskNum = taskNum;
		}
		@Override
		public void run() {
			try {
				System.out.println("task " + this.taskNum + " is running " + "on thread " + Thread.currentThread().getName());
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
