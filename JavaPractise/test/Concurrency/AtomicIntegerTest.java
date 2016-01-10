package Concurrency;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;

public class AtomicIntegerTest {
	
	int i = 0;
	AtomicInteger j = new  AtomicInteger(0); // atomic interger 相当于是int的一种包装
	
	@Test
	public void testIntegerIncrementBySyncWay() {
		Thread t1 = new Thread() {
			public void run() {
				syncIncrease();
			}
		};
		
		Thread t2= new Thread() {
			public void run() {
				syncIncrease();
			}
		};
		
		t1.start();
		t2.start();
	}
	
	@Test
	public void testAtomicIntege() {
		Thread t1 = new Thread() {
			public void run() {
				increase();
			}
		};
		
		Thread t2= new Thread() {
			public void run() {
				increase();
			}
		};
		
		t1.start();
		t2.start();
	}
	
	//result of  testAtomicIntege
//	Thread-0 before incease is 0
//	Thread-0 after increase is1
//	Thread-1 before incease is 0
//	Thread-1 after increase is2
	
	public synchronized void syncIncrease() {
		System.out.println(Thread.currentThread().getName() + " before incease is " + i);
		i++;
		System.out.println(Thread.currentThread().getName() + " after increase is" + i);
	} 
	
	public void increase() {
		System.out.println(Thread.currentThread().getName() + " before incease is " + j.get());
		j.incrementAndGet();
		System.out.println(Thread.currentThread().getName() + " after increase is" + j.get());
	}
	
	
}
