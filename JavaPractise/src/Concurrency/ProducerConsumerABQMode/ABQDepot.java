package Concurrency.ProducerConsumerABQMode;

import java.util.concurrent.ArrayBlockingQueue;
import Concurrency.ProducerConsumerCommon.Depot;


public class ABQDepot implements Depot{

	private ArrayBlockingQueue<String> abq = null;
	
	public ABQDepot(int capacity, boolean fair) {
		abq = new ArrayBlockingQueue<String>(capacity, fair);
	}
	
	@Override
	public void storeProduct(int producePlan) {
		for(int i =0; i<producePlan; i++) {
			abq.add(Thread.currentThread().getName() + i);
			String msg = String.format("%s is producing 1 product, left %d are plan to be produced and there are %d stored in depot ", Thread.currentThread().getName(), producePlan-i-1, abq.size());
			System.out.println(msg);
		}
	}
	
	@Override
	public void consumeProduct(int consumePlan) {
		for(int i =0; i<consumePlan; i++) {
			try {
				abq.take();
				String msg = String.format("%s is consuming 1 product, left %d are plan to be consumed and there are %d stored in depot ", Thread.currentThread().getName(), consumePlan-i-1, abq.size());
				System.out.println(msg);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
