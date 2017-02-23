package jsample.junit;

import org.junit.runner.JUnitCore;

import jsample.AppTest;

public class JUnitApp {

	public static void main(String[] args) {
		JUnitCore runner = new JUnitCore();
		// Adding listener here
		runner.addListener(new CustomRunListener());
		runner.run(AppTest.class);

	}
}
