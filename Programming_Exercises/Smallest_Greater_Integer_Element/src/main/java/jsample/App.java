package jsample;

import jsample.programming.Solution1;
import jsample.programming.Solution2;

/**
 * Given a positive 32-bit integer n, you need to find the smallest 32-bit
 * integer which has exactly the same digits existing in the integer n and is
 * greater in value than n. If no such positive 32-bit integer exists, you need
 * to return -1.
 * 
 * Example 1: 
 * 			Input: 12 
 * 			Output: 21 
 * 
 * Example 2: 
 * 			Input: 21 
 * 			Output: -1
 * 
 */

public class App {
	public static void main(String[] args) {
		System.out.println(new Solution1().nextGreaterElement(32451));
		System.out.println(new Solution2().nextGreaterElement(32451));
	}
}
