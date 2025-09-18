package week3.day3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Find2ndLargestNumberUsingList {
	public static void main(String[] args) {
		// Declaring an array and adding elements to list
		int[] array = {3, 2, 11, 4, 6, 7};
		List<Integer> arrayList = new ArrayList<>();
		for(int i: array) {
			arrayList.add(i);
		}
		// Arrange the collection in ascending order
		Collections.sort(arrayList);
		//arrayList.forEach(System.out::println);
		// Pick the 2nd element from the last and print it
		int size = arrayList.size();
		System.out.println("Size: " + size);
		int secondLargestNum = size - 2;
		System.out.println("Second largest number: ");
		System.out.println(arrayList.get(secondLargestNum));
	}
}
