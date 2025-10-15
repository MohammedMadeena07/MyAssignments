package week2.day1;

public class FibonacciSeries {
	public static void main(String[] args) {
		int range = 8;
		int a = 0, b = 1;
		int c;
		System.out.println("Fibonacci Series of range " + range + " is:");
		for (int i = 1; i <= range; i++) {
			System.out.println(a);
			c = a + b;
			a = b;
			b = c;
		}
	}
}

