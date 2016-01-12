package Callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableFutureSimpleTest {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService threadPool = Executors.newFixedThreadPool(2);
		Future<Integer> future1 = threadPool.submit(new MyCallable1());
		Future<Integer> future2 = threadPool.submit(new MyCallable2());
		System.out.println("future1.get(): " + future1.get());//this statement will stuck until future1.get return
		System.out.println("future2.get(): " + future2.get());//this statement will stuck until future2.get return
		threadPool.shutdown();
	}
}

class MyCallable1 implements Callable<Integer> {

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

class MyCallable2 implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		int sum = 0;
		for(int i=101; i<=200; i++) {
			sum += i;
		}
		System.out.println("callable 2 going to return");
		return sum;
	}
	
}
