package Concurrency;

import org.junit.Test;

import Concurrency.TicketRunnable;


public class TicketRunnableTest {

	@Test
	public void testTicketRunnableSharedBetweenThreads() {
		//create two thread, each thread will try to sell tickets, 10 tickets are shared by them. 
		TicketRunnable ticketRunnable = new TicketRunnable();
		Thread t1 = new Thread(ticketRunnable);
		Thread t2 = new Thread(ticketRunnable);
		
		t1.start();
		t2.start();
	}
	
	@Test
	public void testRunMethod() {
		//test call run() directly won't create a new thread. 
		System.out.println("Current method: " + Thread.currentThread().getName());
		TicketRunnable ticketRunnable = new TicketRunnable();
		ticketRunnable.run();
	}
}
