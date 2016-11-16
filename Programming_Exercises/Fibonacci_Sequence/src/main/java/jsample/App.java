package jsample;

import java.util.Scanner;

/**
 * Where n is a positive integer, the function f(n) satisfies the following.
 * 		f(0) = 0 
 * 		f(1) = 1 
 * 		f(n) = f(n-1)+ f(n-2)
 *
 * Create a program to find f(n).
 */
public class App {
	public static void main(String[] args) {

		System.out.println("Please Input value for finding Fibonacci Sequence -");
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();

			long startTime, endTime, value;

			startTime = System.currentTimeMillis();
			value = findValueUsingRecursion(n);
			endTime = System.currentTimeMillis();
			System.out.println("Value using recursion =" + value + " Total Time=" + (endTime - startTime));

			startTime = System.currentTimeMillis();
			value = findValue(n);
			endTime = System.currentTimeMillis();
			System.out.println("Value without recursion =" + value + " Total Time=" + (endTime - startTime));
		}
	}

	private static long findValue(int n) {
		if (n == 0) {
			return 0L;
		} else if (n == 1) {
			return 1L;
		} else {
			long fn2 = 0L;
			long fn1 = 1L;
			long fn = 0L;
			for (int i = 2; i <= n; i++) {
				fn = fn1 + fn2;
				fn2 = fn1;
				fn1 = fn;
			}
			return fn;
		}
	}

	private static long findValueUsingRecursion(long n) {
		if (n == 0) {
			return 0L;
		} else if (n == 1) {
			return 1L;
		} else {
			return findValueUsingRecursion(n - 1) + findValueUsingRecursion(n - 2);
		}
	}
}