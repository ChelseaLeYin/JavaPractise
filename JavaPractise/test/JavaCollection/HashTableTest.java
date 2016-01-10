package JavaCollection;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;

public class HashTableTest {
	private static Hashtable<Integer, String> mytable = new Hashtable<Integer, String>();
	
	public static void main(String[] args) {
		//test case 1: test traversal function
//		testTraversal();
		
		//test case 2: test multiple thread function
		testMultiThread();
	}

	private static void testMultiThread() {
		new MyThread("T1").start();
		new MyThread("T2").start();
		new MyThread("T3").start();
	}

	private static class MyThread extends Thread {
		MyThread(String name) {
			super(name);
		}
		
		public void run() {
			for (int i = 0; i<5; i++) {
				mytable.put(i, Thread.currentThread().getName() + "-"+ i);
				System.out.println("currect thread " + Thread.currentThread().getName() + " -" + i +  " : " + mytable);
			}
		}
	}
	
	private static void testTraversal() {
		mytable.put(1, "One");
		mytable.put(2, "Two");
		mytable.put(3, "Three");
		
		System.out.println(mytable);
		
		Enumeration<Integer> keys = mytable.keys();
		System.out.print("Using Enumeration....");
		while(keys.hasMoreElements()) {
			System.out.print(keys.nextElement() + " ");
		}
		System.out.print("\n");
		
		Iterator<Integer> iterator = mytable.keySet().iterator();
		System.out.print("Using Iterator....");
		while(iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
		System.out.print("\n");
	}
}
