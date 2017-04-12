package jsample.programming;

public class Solution1 {

	private int greater = -1;
	private int num;

	public int nextGreaterElement(int n) {
		num = n;
		// Get all combinations of given number
		getCombinations("", String.valueOf(n));
		return greater;
	}

	private void getCombinations(String prefix, String number) {
		if (number.length() == 0) {
			int prefixInt = getInteger(prefix);
			// Check if combination is greater than num
			if (prefixInt > num && greater == -1 && prefixInt != -1) {
				greater = prefixInt;
				// Check if combination is greater than num and is smaller
				// than previously selected combination
			} else if (prefixInt > num && greater > prefixInt && prefixInt != -1) {
				greater = prefixInt;
			}
		} else {
			for (int i = 0; i < number.length(); i++) {
				getCombinations(prefix + number.charAt(i), number.substring(0, i) + number.substring(i + 1));
			}
		}
	}

	private int getInteger(String prefix) {
		try {
			return Integer.parseInt(prefix);
		} catch (NumberFormatException e) {

		}
		return -1;
	}
}