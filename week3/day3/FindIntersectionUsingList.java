package week3.day3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindIntersectionUsingList {
	public static void main(String[] args) {
		// Declaring 2 arrays
		int[] array1 = { 3, 2, 11, 4, 6, 7 };
		int[] array2 = { 1, 2, 8, 4, 9, 7 };
		// Adding elements of both arrays to list
		List<Integer> arraylist1 = new ArrayList<>();
		for (int i = 0; i < array1.length; i++) {
			arraylist1.add(array1[i]);
		}
		List<Integer> arraylist2 = new ArrayList<>();
		for (int j : array2) {
			arraylist2.add(j);
		}
		// Sorting array lists
		Collections.sort(arraylist1);
		Collections.sort(arraylist2);
		System.out.println("Intersection/Duplicate Values: ");
		// Comparing both the arrays & Print the equal values
		for (int num : arraylist1) {
			if (arraylist2.contains(num)) {
				System.out.println(num);
			}
		}
	}
}
