package jsample.gradle;

import com.google.common.base.Joiner;

public class App {

	public static String getGreeting() {
		return Joiner.on(" ").join("Hello", "Gradle", "and", "Guava");
	}

	public static void main(String[] args) {
		System.out.println(getGreeting());

	}
}
