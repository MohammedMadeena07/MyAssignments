package week2.day2;

public class OddIndexToUpperCase {
	public static void main(String[] args) {
		String test = "changeme";
		char[] charArray = test.toCharArray();
		for (int i = charArray.length - 1; i >= 0; i--) {
			if (i % 2 == 1) {
				charArray[i] = Character.toUpperCase(charArray[i]);
			}
		}
		for (int j = 0; j < charArray.length; j++) {
			System.out.print(charArray[j]);
		}
	}
}
