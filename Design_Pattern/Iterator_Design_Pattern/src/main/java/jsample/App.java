package jsample;

import jsample.iterator.IntegerRangeCollection;
import jsample.iterator.IntegerRangeIterator;
import jsample.iterator.impl.IntegerRangeList;

public class App {
	public static void main(String[] args) {
		IntegerRangeCollection integerRangeCollection = new IntegerRangeList();
		integerRangeCollection.addRange(10, 20);
		integerRangeCollection.addRange(50, 60);
		integerRangeCollection.removeRange(15, 20);

		System.out.println("Even numbers exist in range -");

		IntegerRangeIterator evenIterator = integerRangeCollection.evenIterator();
		while (evenIterator.hasNext()) {
			System.out.println(evenIterator.next());
		}

		System.out.println("Odd numbers exist in range -");
		IntegerRangeIterator oddIterator = integerRangeCollection.oddIterator();
		while (oddIterator.hasNext()) {
			System.out.println(oddIterator.next());
		}
	}
}
