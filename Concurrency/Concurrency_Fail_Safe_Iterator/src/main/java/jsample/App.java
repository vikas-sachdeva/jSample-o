package jsample;

import jsample.concurrency.FailSafeIterator;

public class App {
	public static void main(String[] args) {

		new FailSafeIterator().print();

	}
}
