package Concurrency.ProducerConsumerReentrantLockMode;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import Concurrency.ProducerConsumerCommon.Depot;


public class ReentrantLockDepot implements Depot{
	public Lock lock;
	final private Condition fullCondition;
	final private Condition emptyConditon;
	private int capacity;
	private int storedNumber;
	
	public ReentrantLockDepot (int capacity) {
		this.capacity = capacity;
		this.storedNumber = 0;
		lock = new ReentrantLock();
		fullCondition = lock.newCondition();
		emptyConditon = lock.newCondition();
	}
	
	@Override
	public void storeProduct (int producePlan) {
		lock.lock();
		try {
			for (int i = 0; i < producePlan; i++) {
				if (storedNumber >= this.capacity) {
					System.out.println("Depot is full!");
					fullCondition.await();//add current thread to wait queue of fullCondition 
				}
				
				storedNumber ++;
				String msg = String.format("%s is producing 1 product, left %d are plan to be produced and there are %d stored in depot ", Thread.currentThread().getName(), producePlan - i, storedNumber);
				System.out.println(msg);
				emptyConditon.signalAll();//signal all thread in wait queue of emptyConditon
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	@Override
	public void consumeProduct (int consumePlan) {
		lock.lock();
		try {
			for (int i = 0; i < consumePlan; i++) {
				if (storedNumber <= 0) {
					System.out.println("Depot is empty!");
					emptyConditon.await();//add current thread to wait queue of emptyConditon 
				}
				
				storedNumber --;
				String msg = String.format("%s is consuming 1 product, left %d are plan to be consumed and there are %d stored in depot ", Thread.currentThread().getName(), consumePlan - i, storedNumber);
				System.out.println(msg);
				fullCondition.signalAll();//signal all thread in wait queue of fullCondition
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
}
