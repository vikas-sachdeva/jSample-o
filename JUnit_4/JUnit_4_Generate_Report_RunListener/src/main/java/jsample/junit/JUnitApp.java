package jsample.junit;

import org.junit.runner.JUnitCore;

import jsample.AllTest;
import jsample.junit.report.CustomRunListener;

public class JUnitApp {

	public static void main(String[] args) {
		JUnitCore runner = new JUnitCore();
		// Adding listener here
		runner.addListener(new CustomRunListener());
		/**
		 * Below line may result in NoClassDefFoundError if complete build (JAR
		 * file) does not include test directory classes.
		 */
		runner.run(AllTest.class);

	}
}
