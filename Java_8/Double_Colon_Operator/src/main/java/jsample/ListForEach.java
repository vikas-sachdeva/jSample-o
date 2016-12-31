package jsample;

import java.util.Arrays;
import java.util.List;

public class ListForEach {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

		list.forEach(System.out::println);
	}

}