package Concurrency;

public class CountForSyncBasicPrincipal {
	
	synchronized public void printNumberSync() {
		for (int i = 1; i <= 50; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
	}
	
	public void printNumberNonSync() {
		for (int i = 1; i <= 50; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
	}

}
