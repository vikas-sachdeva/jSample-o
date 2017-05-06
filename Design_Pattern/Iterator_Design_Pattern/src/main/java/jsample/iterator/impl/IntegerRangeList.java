package jsample.iterator.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import jsample.iterator.IntegerRangeCollection;
import jsample.iterator.IntegerRangeIterator;

public class IntegerRangeList implements IntegerRangeCollection {

	private List<Integer> list = new ArrayList<>();

	@Override
	public void addRange(int startValue, int endValue) {
		if (startValue == 0 || endValue == 0 || startValue >= endValue) {
			throw new IllegalArgumentException("Input parameters are not valid");
		}
		for (int i = startValue; i < endValue; i++) {
			list.add(Integer.valueOf(i));
		}
	}

	@Override
	public void removeRange(int startValue, int endValue) {
		if (startValue == 0 || endValue == 0 || startValue >= endValue) {
			throw new IllegalArgumentException("Input parameters are not valid");
		}
		for (int i = startValue; i < endValue; i++) {
			list.remove(Integer.valueOf(i));
		}
	}

	@Override
	public IntegerRangeIterator evenIterator() {
		return new EvenIterator(list);
	}

	@Override
	public IntegerRangeIterator oddIterator() {
		return new OddIterator(list);
	}

	private class EvenIterator implements IntegerRangeIterator {

		private List<Integer> list = new ArrayList<>();

		private int index = -1;

		public EvenIterator(List<Integer> list) {
			this.list = list;
		}

		@Override
		public boolean hasNext() {
			for (int i = index + 1; i < list.size(); i++) {
				if (i % 2 == 0) {
					return true;
				}
			}
			return false;
		}

		@Override
		public Integer next() {
			for (int i = index + 1; i < list.size(); i++) {
				if (i % 2 == 0) {
					index = i;
					return list.get(index);
				}
			}
			throw new NoSuchElementException("No more even number exist");
		}
	}

	private class OddIterator implements IntegerRangeIterator {

		private List<Integer> list = new ArrayList<>();

		private int index = -1;

		public OddIterator(List<Integer> list) {
			this.list = list;
		}

		@Override
		public boolean hasNext() {
			for (int i = index + 1; i < list.size(); i++) {
				if (i % 2 == 1) {
					return true;
				}
			}
			return false;
		}

		@Override
		public Integer next() {
			for (int i = index + 1; i < list.size(); i++) {
				if (i % 2 == 1) {
					index = i;
					return list.get(index);
				}
			}
			throw new NoSuchElementException("No more odd number exist");
		}
	}
}