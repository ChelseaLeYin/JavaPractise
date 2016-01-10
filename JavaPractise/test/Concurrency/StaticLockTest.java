package Concurrency;

import org.junit.Test;

public class StaticLockTest {
	
	@Test
	public void testStaticLockWithInstanceLock() {
		final Something obj = new Something();
		Thread t1 = new Thread(new Runnable(){//t1 access isSyncA method, and share instance lock.

			@Override
			public void run() {
				obj.isSyncA();
			}
			
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				Something.cSyncA(); //t2 access cSyncA method, and share static lock
			}
		});
		
		t1.start();
		t2.start();
	}
}

class Something {
	public synchronized void isSyncA() {
		for (int i = 0; i < 200; i++) {
			System.out.println(Thread.currentThread().getName() + " : isSyncA");
		}
	}
	
	public static synchronized void cSyncA() {
		for (int i = 0; i < 200; i++) {
			System.out.println(Thread.currentThread().getName() + " : cSyncA");
		}
	}
}