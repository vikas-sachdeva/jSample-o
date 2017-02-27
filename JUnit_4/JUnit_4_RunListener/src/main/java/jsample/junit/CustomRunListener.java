package jsample.junit;

import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

public class CustomRunListener extends RunListener {

	/**
	 * Called before any tests have been run.
	 *
	 * @param description
	 *            describes the tests to be run
	 */
	public void testRunStarted(Description description) throws Exception {
		System.out.println("Test Case execution Started " + description.getDisplayName());
	}

	/**
	 * Called when all tests have finished.
	 *
	 * @param result
	 *            the summary of the test run, including all the tests that
	 *            failed
	 */
	public void testRunFinished(Result result) throws Exception {
		System.out.println("All test cases execution finished. Total Test Cases = " + result.getRunCount()
				+ ", Total Failed Test Cases = " + result.getFailureCount());
	}

	/**
	 * Called when an atomic test is about to be started.
	 *
	 * @param description
	 *            the description of the test that is about to be run (generally
	 *            a class and method name)
	 */
	public void testStarted(Description description) throws Exception {
		System.out.println("Test Case Started " + description.getMethodName());

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
		System.out.println("Test Case Failed " + failure.getDescription().getDisplayName());
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
		System.out.println("Test Case Finished " + description.getDisplayName());
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
		System.out.println("Test Case Assumption Failed " + failure.getDescription().getDisplayName());
	}

	/**
	 * Called when a test will not be run, generally because a test method is
	 * annotated with {@link org.junit.Ignore}.
	 *
	 * @param description
	 *            describes the test that will not be run
	 */
	public void testIgnored(Description description) throws Exception {
		System.out.println("Test Case Ignored " + description.getDisplayName());
	}
}