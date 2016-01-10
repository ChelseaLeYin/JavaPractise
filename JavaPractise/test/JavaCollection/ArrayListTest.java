package JavaCollection;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {

	public static void main(String[] args) {
		List<Integer> intList = new ArrayList();
		intList.add(1);
		intList.add(2);
		
		// test toArray()
//		int[] intArray = (int[])intList.toArray();//Cannot cast from Object[] to int[]
		Integer[] intArray = intList.toArray(new Integer[0]);
		
		//test addadd(index, element)
		System.out.println("the first element is: " + intList.get(0));
		intList.add(0, 0);//will insert new element to index 0, each element will be one index back. 
		System.out.println("the first element is: " + intList.get(0));
		System.out.println("the size is: " + intList.size());
	}

}
