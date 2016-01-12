package Callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class FutureTaskSimpleTest {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService threadPool = Executors.newFixedThreadPool(2);
		FutureTask<Integer> futureTask1 = new FutureTask<Integer>(new MyCallable1());
		threadPool.submit(futureTask1);
		System.out.println("future1.get(): " + futureTask1.get());
	}

	static class MyCallable1 implements Callable<Integer> {
		
		@Override
		public Integer call() throws Exception {
			int sum = 0;
			for(int i=1; i<=100; i++) {
				sum += i;
			}
			Thread.currentThread().sleep(1000);
			System.out.println("callable 1 going to return");
			return sum;
		}
		
	}
	
}

