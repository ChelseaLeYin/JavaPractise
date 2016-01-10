package Concurrency;

import org.junit.Test;

import Concurrency.FiveTicketsRunnable;


public class FiveTicketsRunnableTest {
	@Test
	public void testSynchronzideBlock() {
		FiveTicketsRunnable fiveTicketsRunnable = new FiveTicketsRunnable();
		Thread t1 = new Thread(fiveTicketsRunnable);
		Thread t2 = new Thread(fiveTicketsRunnable);
		t1.start();//t1获取同步锁
		t2.start();//t2获取同步锁
	}
}
