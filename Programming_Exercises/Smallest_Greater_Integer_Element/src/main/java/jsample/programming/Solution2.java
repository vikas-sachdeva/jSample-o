package jsample.programming;

import java.util.Arrays;

public class Solution2 {

	public int nextGreaterElement(int n) {
		char[] num = (n + "").toCharArray();
		// Start from the end and check if last digit can be changed to larger
		// value. In such case, new number would be smallest greater number. If
		// not last digit, check for second last digit and so on.
		for (int i = num.length - 2; i >= 0; i--) {
			// find min number greater than num(i)
			int minIdx = i;
			for (int j = i + 1; j < num.length; j++) {
				minIdx = num[j] > num[i] ? j : minIdx;
			}
			if (minIdx != i) {
				char temp = num[i]; // swap minIdx and i;
				num[i] = num[minIdx];
				num[minIdx] = temp;
				// sort number for making it more smaller
				Arrays.sort(num, i + 1, num.length);

				long val = Long.parseLong(new String(num));
				return (val <= Integer.MAX_VALUE) ? (int) val : -1;
			}
		}
		return -1;
	}
}