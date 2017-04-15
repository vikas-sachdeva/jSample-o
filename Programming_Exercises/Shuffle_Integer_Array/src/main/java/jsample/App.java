package jsample;

import jsample.programming.Solution;

/**
 * Shuffle a set of numbers without duplicates.
 * 
 * Example:
 * 
 * <pre>
 * 
 * // Init an array with set 1, 2, and 3.
 * int[] nums = { 1, 2, 3 };
 * Solution solution = new Solution(nums);
 * 
 * // Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
 * solution.shuffle();
 * 
 * // Resets the array back to its original configuration [1,2,3].
 * solution.reset();
 * 
 * // Returns the random shuffling of array [1,2,3].
 * solution.shuffle();
 * 
 * </pre>
 */

public class App {
	public static void main(String[] args) {
		Solution solution = new Solution(new int[] { 1, 2, 3 });

		print(solution.shuffle());
		print(solution.reset());
		print(solution.shuffle());
		print(solution.shuffle());
		print(solution.shuffle());
		print(solution.shuffle());
		print(solution.shuffle());
		print(solution.shuffle());
		print(solution.shuffle());
		print(solution.shuffle());
		print(solution.shuffle());

	}

	private static void print(int[] shuffle) {
		for (int i = 0; i < shuffle.length; i++) {
			System.out.print(shuffle[i]);
		}
		System.out.println();
	}
}