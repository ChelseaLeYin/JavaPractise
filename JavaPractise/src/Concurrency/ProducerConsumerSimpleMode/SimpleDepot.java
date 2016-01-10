package Concurrency.ProducerConsumerSimpleMode;

import Concurrency.ProducerConsumerCommon.Depot;

public class SimpleDepot implements Depot{
	private int Capacity;
	private int storedNumber;
	
	public SimpleDepot(int capacity) {
		this.Capacity = capacity;
		this.storedNumber = 0;
	}

	@Override
	public void storeProduct(int producePlan) {
			for (int i = 0; i < producePlan; i++) {
				synchronized (this) {
				while (storedNumber >= Capacity) { // if Depot is full, let current thread wait. Current thread must be producer.
					System.out.println("Depot is full!");
					try {
						this.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				storedNumber += 1;
				String msg = String.format("%s is producing 1 product, left %d are plan to be produced and there are %d stored in depot ", Thread.currentThread().getName(), producePlan - i, storedNumber);
				System.out.println(msg);
				this.notifyAll(); // there must be at least 1 product in depot, so all waited consumer should get notified. 
			}
		}
	}

	@Override
	public void consumeProduct(int consumePlan) {
			for (int i = 0; i < consumePlan; i++) {
				synchronized (this) {
				while (storedNumber <= 0) { // if depot is empty, consumer should be waiting
					System.out.println("Depot is empty ! Consumer is waiting!");
					try {
						this.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} 
				storedNumber -= 1;
				String msg = String.format("%s is consuming 1 product, left %d are plan to be consumed and there are %d stored in depot ", Thread.currentThread().getName(), consumePlan - i, storedNumber);
				System.out.println(msg);
				this.notifyAll();//notify the producer, there are might be some capacity for producer to keep producing
			}
		}
	}

}
