package week3.day3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingUsingCollection {
	public static void main(String[] args) {
		// Declare a String array and add the values
		String[] array = { "HCL", "Wipro", "Aspire Systems", "CTS" };
		// Add the collection to a list
		List<String> arrayList = new ArrayList<>();
		for (String list : array) {
			arrayList.add(list);
		}
		// Arrange the collection in ascending order
		Collections.sort(arrayList);
		// Use reverse loop to iterate the collection
		List<String> reversed = arrayList.reversed();
		System.out.println(reversed);
	}
}
