package Concurrency.ReadWriteLock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class User {
	private String userName;
	private Account account;
	private ReadWriteLock lock;
	
	public User(String userName, Account account) {
		this.userName = userName;
		this.account = account;
		this.lock = new ReentrantReadWriteLock();
	}
	
	public void queryAccount() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				lock.readLock().lock();
				try {
					System.out.println(Thread.currentThread().getName() + " is querying the account of " + userName);
					account.getBalance();
					Thread.sleep(2000);
					System.out.println(Thread.currentThread().getName() + " query ends. ");
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					lock.readLock().unlock();
				}
			}
		}).start();
	}
	
	public void updateAccountBalance(final double balance) {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				lock.writeLock().lock();
				try {
					System.out.println(Thread.currentThread().getName() +" is updating the balance of "  + userName); 
					account.setBalance(balance);
					Thread.sleep(2000);
					System.out.println(Thread.currentThread().getName() +" update end"); 
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					lock.writeLock().unlock();
				}
			}
		}).start();
	}
}
