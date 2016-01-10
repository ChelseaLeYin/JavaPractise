package Concurrency.ProducerConsumerCommon;

public class Consumer {
	public String consumerName;
	public Depot depot;
	
	/*
	 * name
	 * depot
	 * */
	public Consumer(String name, Depot depot) {
		this.consumerName = name;
		this.depot = depot;
	}
	
	public void startConsuming(final int consumePlan) {
		Thread t = new Thread(new Runnable(){

			@Override
			public void run() {
				depot.consumeProduct(consumePlan);
			}
			
		}, consumerName);
		
		System.out.println(consumerName + " is start consuming ! ");
		t.start();
		
	}

}
