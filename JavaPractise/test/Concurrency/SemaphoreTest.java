package Concurrency;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {

	private static final int SEM_SIZE = 10;

	public static void main(String[] args) {
		Semaphore semaphore = new Semaphore(SEM_SIZE);
		new MyThread("T1", semaphore, 5).start();
		new MyThread("T2", semaphore, 4).start();
		new MyThread("T3", semaphore, 10).start();//T3 will wait until T1 and T2 release permits.
	}
}

class MyThread extends Thread {
	private volatile Semaphore semaphore;//volatite:易变的，不稳定的。用来确保将变量的更新操作通知到其他线程,保证了新值能立即同步到主内存,以及每次使用前立即从主内存刷新。
	private final int count;
	MyThread(String name, Semaphore semaphore, int count) {
		super(name);
		this.semaphore = semaphore;
		this.count = count;
	}
	
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName() + " is trying to acquire " + count + " permits ");
			semaphore.acquire(count);
			System.out.println(Thread.currentThread().getName() + " acquire " + count + " permits successfully ");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			System.out.println(Thread.currentThread().getName() + " is releasing " + count + " permits ");
			semaphore.release(count);
		}
	}
}
