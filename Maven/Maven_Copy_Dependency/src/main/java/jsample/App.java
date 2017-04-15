package jsample;

import com.google.common.base.Joiner;

public class App {
	public static void main(String[] args) {
		System.out.println(getGreeting());
	}

	public static String getGreeting() {
		return Joiner.on(" ").join("Hello", "Maven", "and", "Guava");
	}

}
