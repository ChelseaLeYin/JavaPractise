package Concurrency;

public class TicketRunnable implements Runnable {
	
	private int ticketsInTotal = 10;
	@Override
	public void run() {
		while(ticketsInTotal > 0) {
			System.out.println(Thread.currentThread().getName() + " is selling ticket#" + ticketsInTotal--);
		}
	}

}
