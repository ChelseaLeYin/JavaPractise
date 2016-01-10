package Concurrency;

public class FiveTicketsRunnable implements Runnable{
	int ticketsInTotal = 10;

	@Override
	public void run() {
		synchronized(this) {//this refers to FiveTicketsRunnable,具有相同FiveTicketsRunnable对象的线程会共享这个同步锁。一个线程获取到这个同步锁之后，会造成另一个线程的阻塞。
			for (int i=0; i<5; i++) {
				System.out.println(Thread.currentThread().getName() + " is selling ticket#" + ticketsInTotal--);
			}
		}
	}
	

}