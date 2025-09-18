package week3.day3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindMissingElementUsingList {
	public static void main(String[] args) {
		// Declare an array & adding elements to list
		int[] array = { 1, 2, 3, 4, 10, 6, 8 };
		List<Integer> arrayList = new ArrayList<>();
		for (int num : array) {
			arrayList.add(num);
		}
		// Arrange the collection in ascending order
		Collections.sort(arrayList);
		// comparison check if there is a gap in the sequence of numbers
		int firstNumber = arrayList.get(0);
		int lastNumber = arrayList.get(arrayList.size() - 1);
		System.out.println("Missing Number: ");
		for (int i = firstNumber; i < lastNumber; i++) {
			if (!arrayList.contains(i)) {
				System.out.println(i);
			}
		}
	}
}
