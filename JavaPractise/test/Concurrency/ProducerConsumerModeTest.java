package Concurrency;

import Concurrency.ProducerConsumerABQMode.ABQDepot;
import Concurrency.ProducerConsumerCommon.Consumer;
import Concurrency.ProducerConsumerCommon.Depot;
import Concurrency.ProducerConsumerCommon.Producer;
import Concurrency.ProducerConsumerReentrantLockMode.ReentrantLockDepot;
import Concurrency.ProducerConsumerSimpleMode.SimpleDepot;


public class ProducerConsumerModeTest {
	
	private static Depot depot;
	private static Producer producer1;
	private static Consumer consumer1;
	
	public static void main(String[] args){
		//test case 1: simple mode with synchronized, wait and notify
		/*depot = new SimpleDepot(20);
		Producer producer1 = new Producer("Producer A", depot);
		Consumer consumer1 = new Consumer("Consumer B", depot);
		producer1.startProducing(25);
		consumer1.startConsuming(22);*/
		
		//test case 2: ReentrantLock mode with lock and condition
		/*depot = new ReentrantLockDepot(20);
		producer1 = new Producer("Producer A", depot);
		consumer1 = new Consumer("Consumer B", depot);
		producer1.startProducing(25);
		consumer1.startConsuming(22);*/
		
		//test case 3: ABQ mode with ArrayBlockingQueue
		depot = new ABQDepot(20, true);
		producer1 = new Producer("Producer A", depot);
		consumer1 = new Consumer("Consumer B", depot);
		producer1.startProducing(25);
		consumer1.startConsuming(22);
		
		
	}
}
