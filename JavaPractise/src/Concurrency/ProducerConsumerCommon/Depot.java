package Concurrency.ProducerConsumerCommon;

public  interface Depot {
	abstract public void storeProduct(int producePlan);
	abstract public void consumeProduct(int consumePlan);
}
