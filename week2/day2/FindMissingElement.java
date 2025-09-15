package week2.day2;

import java.util.Arrays;

public class FindMissingElement {
	public static void main(String[] args) {
		int[] arr = { 1, 4, 3, 2, 8, 6, 7 };
		Arrays.sort(arr);
		System.out.println("Missing Number: ");
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != arr[0] + i) {
				System.out.println(arr[0] + i);
				break;
			}
		}
	}
}
