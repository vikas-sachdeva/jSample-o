package jsample;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class StreamApi {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

		System.out.println("Square of each element of the list using Stream API -");

		Stream<Integer> streamFromList = list.stream();

		Function<Integer, Integer> squareFunction = (x) -> x * x;

		Stream<Integer> streamOfSquares = streamFromList.map(squareFunction);

		streamOfSquares.forEach((n) -> System.out.print(n + " "));
		
		System.out.println();
		// Above lines can be merged in one line as shown below -

		list.stream().map((x) -> x * x).forEach((n) -> System.out.print(n + " "));
	}
}