package Concurrency.ProducerConsumerCommon;


public class Producer {
	public String producerName;
	public Depot depot;
	
	/*
	 * @name
	 * @depot
	 * */
	public Producer(String name, Depot depot) {
		this.producerName = name;
		this.depot = depot;
	}
	
	public void startProducing(final int producePlan) {
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				depot.storeProduct(producePlan);
			}
			
		}, producerName);
		
		System.out.println(producerName + " is start producing! ");
		t1.start();
	}
	
	

}
