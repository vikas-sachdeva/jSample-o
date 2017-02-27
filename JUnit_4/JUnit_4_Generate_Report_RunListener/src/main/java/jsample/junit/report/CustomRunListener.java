package jsample.junit.report;

import java.util.HashMap;
import java.util.Map;

import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

public class CustomRunListener extends RunListener {

	private Map<String, TestCaseResult> idResultMap = new HashMap<>();

	/**
	 * Called before any tests have been run.
	 *
	 * @param description
	 *            describes the tests to be run
	 */
	public void testRunStarted(Description description) throws Exception {
	}

	/**
	 * Called when all tests have finished.
	 *
	 * @param result
	 *            the summary of the test run, including all the tests that
	 *            failed
	 */
	public void testRunFinished(Result result) throws Exception {
		ReportUtil.createCsvReport(idResultMap);
	}

	/**
	 * Called when an atomic test is about to be started.
	 *
	 * @param description
	 *            the description of the test that is about to be run (generally
	 *            a class and method name)
	 */
	public void testStarted(Description description) throws Exception {
		TestCase testCase = description.getAnnotation(TestCase.class);
		TestCaseResult testCaseResult = new TestCaseResult(testCase.category(), TestCaseResultStatus.STARTED);
		idResultMap.put(testCase.id(), testCaseResult);
	}

	/**
	 * Called when an atomic test fails, or when a listener throws an exception.
	 *
	 * <p>
	 * In the case of a failure of an atomic test, this method will be called
	 * with the same {@code Description} passed to
	 * {@link #testStarted(Description)}, from the same thread that called
	 * {@link #testStarted(Description)}.
	 *
	 * <p>
	 * In the case of a listener throwing an exception, this will be called with
	 * a {@code Description} of {@link Description#TEST_MECHANISM}, and may be
	 * called on an arbitrary thread.
	 *
	 * @param failure
	 *            describes the test that failed and the exception that was
	 *            thrown
	 */
	public void testFailure(Failure failure) throws Exception {
		TestCase testCase = failure.getDescription().getAnnotation(TestCase.class);
		idResultMap.get(testCase.id()).setTestCaseResultStatus(TestCaseResultStatus.FAILED);
	}

	/**
	 * Called when an atomic test has finished, whether the test succeeds or
	 * fails.
	 * 
	 * This method is called after testFailure() method in case of failed test
	 * case.
	 * 
	 * This method is never called for ignored test cases (test cases annotated
	 * using {@link org.junit.Ignore} annotation)
	 *
	 * @param description
	 *            the description of the test that just ran
	 */
	public void testFinished(Description description) throws Exception {
		TestCase testCase = description.getAnnotation(TestCase.class);
		if (!idResultMap.get(testCase.id()).getTestCaseResultStatus().equals(TestCaseResultStatus.FAILED)) {
			idResultMap.get(testCase.id()).setTestCaseResultStatus(TestCaseResultStatus.PASS);
		}
	}

	/**
	 * Called when an atomic test flags that it assumes a condition that is
	 * false
	 *
	 * @param failure
	 *            describes the test that failed and the
	 *            {@link org.junit.AssumptionViolatedException} that was thrown
	 */
	public void testAssumptionFailure(Failure failure) {
	}

	/**
	 * Called when a test will not be run, generally because a test method is
	 * annotated with {@link org.junit.Ignore}.
	 *
	 * @param description
	 *            describes the test that will not be run
	 */
	public void testIgnored(Description description) throws Exception {
		TestCase testCase = description.getAnnotation(TestCase.class);
		TestCaseResult testCaseResult = new TestCaseResult(testCase.category(), TestCaseResultStatus.IGNORE);
		idResultMap.put(testCase.id(), testCaseResult);
	}
}