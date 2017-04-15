package jsample.programming;

import java.util.Arrays;
import java.util.Random;

public class Solution {

	private int[] nums;

	private Random random;

	public Solution(int[] nums) {
		this.nums = nums;
		random = new Random();
	}

	/** Resets the array to its original configuration and return it. */
	public int[] reset() {
		return nums;
	}

	/** Returns a random shuffling of the array. */
	public int[] shuffle() {
		// Make a copy of original array for avoiding modification of original
		// array.
		int[] shuffledNums = Arrays.copyOf(nums, nums.length);
		for (int i = nums.length - 1; i >= 0; i--) {
			int randomIndex = random.nextInt(i + 1);
			// if both numbers are same, skip swapping
			if (shuffledNums[randomIndex] == shuffledNums[i]) {
				continue;
			}
			// swap numbers
			int temp = shuffledNums[i];
			shuffledNums[i] = shuffledNums[randomIndex];
			shuffledNums[randomIndex] = temp;
		}
		return shuffledNums;
	}
}