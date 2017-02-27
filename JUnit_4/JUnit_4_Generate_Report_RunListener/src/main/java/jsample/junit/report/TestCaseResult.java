package jsample.junit.report;

public class TestCaseResult {

	private String category;

	private TestCaseResultStatus testCaseResultStatus;

	public TestCaseResult(String category, TestCaseResultStatus testCaseResultStatus) {
		this.category = category;
		this.testCaseResultStatus = testCaseResultStatus;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public TestCaseResultStatus getTestCaseResultStatus() {
		return testCaseResultStatus;
	}

	public void setTestCaseResultStatus(TestCaseResultStatus testCaseResultStatus) {
		this.testCaseResultStatus = testCaseResultStatus;
	}

}
