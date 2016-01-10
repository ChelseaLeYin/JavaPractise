package Concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SynchronizedVersusReentrantLockTest {

	/**
	 * test exclusive lock with sync, wait and notify*/
	/*public static void main(String[] args) {
		Thread t1 = new MyThread("T1");
		synchronized (t1) {
			try {
				System.out.println(Thread.currentThread().getName() + " start T1");
				t1.start();
				
				System.out.println(Thread.currentThread().getName() + " block");
				t1.wait();//t1 could not running it's run() until now because main thread release the lock of t1 here
				
				System.out.println(Thread.currentThread().getName() + " continue");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	static class MyThread extends Thread {
		public MyThread(String name) {
			super(name);
		}
		
		public void run() {
			synchronized (this) {
				System.out.println(Thread.currentThread().getName() + " notify others");
				notify();//t1 release the lock after the sync and notify the waited thread --- main
			}
		}
	}*/
	
	public static final ReentrantLock lock = new ReentrantLock();
	public static Condition waitCondition = lock.newCondition();
	
	
	/**
	 * test exclusive lock with ReentrantLock and a bunch of Conditions*/
	public static void main(String[] args) {
		Thread t1 = new MyThread("T1");
		try {
			lock.lock();//get the lock
			t1.start();
			
			System.out.println(Thread.currentThread().getName() + " block");
			waitCondition.await();// main thread wait, add main thread to the wait queue of this condition
			
			System.out.println(Thread.currentThread().getName() + " continue");
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			System.out.println(Thread.currentThread().getName() + " is going to unlock");
			lock.unlock();
		}
	}
	
	static class MyThread extends Thread{
		public MyThread(String name) {
			super(name);
		}
		
		public void run() {
			try {
				lock.lock();//try to get the lock 
				System.out.println(Thread.currentThread().getName() + " notify others");
				waitCondition.signalAll();//notify all thread in wait queue of this condition
			} finally {
				System.out.println(Thread.currentThread().getName() + " is going to unlock");
				lock.unlock();
			}
		}
	}

}
