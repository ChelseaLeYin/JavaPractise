package JUCCollection;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListTest {
	
	//Case 1: use normal ArrayList. 
//	private static List<String> list = new ArrayList<String>();//ConcurrentModificationException throw
	//Case 1: use COWArrayList. 
	private static List<String> list = new CopyOnWriteArrayList();

	public static void main(String[] args) {
		new MyThread("T1").start();
		new MyThread("T2").start();
	}
	
	public static void printAll() {
		StringBuilder strBuilder = new StringBuilder();
		for (String item : list) {
			strBuilder.append(item);
			strBuilder.append(",");
		}
		strBuilder.delete(strBuilder.length()-1, strBuilder.length());
		System.out.println("currect thread " + Thread.currentThread().getName() + " : " + strBuilder.toString());
	}

	
	private static class MyThread extends Thread {
		MyThread(String name) {
			super(name);
		}
		
		public void run() {
			for (int i = 0; i<5; i++) {
				list.add(Thread.currentThread().getName() + "-"+ i);
				printAll();
			}
		}
	}
}

