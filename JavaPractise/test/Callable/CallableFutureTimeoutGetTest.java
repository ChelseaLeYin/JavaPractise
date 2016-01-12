package Callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CallableFutureTimeoutGetTest {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService threadPool = Executors.newFixedThreadPool(2);
		Future<Integer> future1 = threadPool.submit(new MyCallable1());
		Integer future1Result = 1;
		try {
			future1Result = future1.get(500, TimeUnit.MILLISECONDS);//it should return null, but it didn't.
		} catch (TimeoutException exception) {
			exception.printStackTrace();
		}
		System.out.println("future1.get(): " + future1Result);
		if (future1.isDone()) {
			threadPool.shutdown();
		}
	}

	static class MyCallable1 implements Callable<Integer> {

		@Override
		public Integer call() throws Exception {
			int sum = 0;
			for (int i = 1; i <= 100; i++) {
				sum += i;
			}
			Thread.currentThread().sleep(1000);
			System.out.println("callable 1 going to return");
			return sum;
		}

	}

}
