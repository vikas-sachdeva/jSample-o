package jsample;

import org.junit.Test;

import jsample.junit.report.TestCase;

public class AppTest {

	@TestCase(id = "testMain1", category = "main")
	@Test
	public void testMain() {
		App.main(null);
	}
}