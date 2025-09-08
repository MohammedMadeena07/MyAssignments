package week2.day1;

public class FibonacciSeries {
	public static void main(String[] args) {
		int range = 8;
		int a = 0, b = 1;
		int fib;
		System.out.println("Fibonacci Series of range " + range + " is:");
		for (int i = 1; i <= range; i++) {
			System.out.println(a);
			fib = a + b;
			a = b;
			b = fib;
		}
	}
}
