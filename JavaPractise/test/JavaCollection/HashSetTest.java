package JavaCollection;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest {

	public static void main(String[] args) {
		Set<Integer> intSet = new HashSet();
		for(int i = 0; i<10; i++) {
			intSet.add(i);
		}
		
//		for(Integer i : intSet) {
//			System.out.println(i);
//		}
		Integer[] array = intSet.toArray(new Integer[0]);
		for(Integer i : array) {
			System.out.println(i);
		}
	}

}
