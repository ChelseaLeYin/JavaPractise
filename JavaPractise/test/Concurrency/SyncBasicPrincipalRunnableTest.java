package Concurrency;

import org.junit.Test;

import Concurrency.CountForSyncBasicPrincipal;

public class SyncBasicPrincipalRunnableTest {
	
	@Test
//	原则1: 当一个线程访问“某对象”的“synchronized方法”或者“synchronized代码块”时，
//	其他线程对“该对象”的该“synchronized方法”或者“synchronized代码块”的访问将被阻塞
	public void testSyncBasicPrincipal1(){
		
		//create a nameless runnable class and create an instance
		Runnable runnable = new Runnable() {

			@Override
			public void run() {
				synchronized(this) {
					for (int i = 0; i < 5; i++) {
						System.out.println(Thread.currentThread().getName() + " " + i);
					}
				}
			}
			
		};
		
		//t1&t2 共享runnable这个对象的同步锁。要注意与以下创建thread之间的区别。
		Thread t1 = new Thread(runnable);
		Thread t2 = new Thread(runnable);
		
//		t1 = new MyThread();
//		t2 = new MyThread();
		
		t1.start();
		t2.start();
	}
	
	@Test
//	原则2: 当一个线程访问“某对象”的“synchronized方法”或者“synchronized代码块”时，
//	其他线程仍然可以访问“该对象”的非同步代码块。
	public void testSyncBasicPrincipal2() {
		
		final CountForSyncBasicPrincipal count = new CountForSyncBasicPrincipal();
		
		//t1&t2 共享count这个对象的同步锁
		Thread t1 = new Thread( new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				count.printNumberSync();
			}
			
		});
		
		Thread t2 = new Thread( new Runnable() {

			@Override
			public void run() {
				count.printNumberNonSync();
			}
			
		});
		
		t1.start();
		t2.start();
	}
	
	@Test
//	原则3: 当一个线程访问“某对象”的“synchronized方法”或者“synchronized代码块”时，
//	其他线程对“该对象”的其他的“synchronized方法”或者“synchronized代码块”的访问将被阻塞。
	public void testSyncBasicPrincipal3() {
		final CountForSyncBasicPrincipal count = new CountForSyncBasicPrincipal();
		
		//t1&t2 共享count这个对象的同步锁
		Thread t1 = new Thread( new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				count.printNumberSync();
			}
			
		});
		
		Thread t2 = new Thread( new Runnable() {

			@Override
			public void run() {
				count.printNumberSync();
			}
			
		});
		
		t1.start();
		t2.start();
	}
}
