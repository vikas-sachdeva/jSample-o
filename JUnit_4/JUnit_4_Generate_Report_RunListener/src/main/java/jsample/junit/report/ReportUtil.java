package jsample.junit.report;

import java.util.Map;
import java.util.Map.Entry;

public class ReportUtil {

	private static final String REPORT_HEADER_FIRST_COLUMN = "Test Case Id";

	private static final String REPORT_HEADER_SECOND_COLUMN = "Category";

	private static final String REPORT_HEADER_THIRD_COLUMN = "Result";

	private static final String CSV_SEPARATOR = ",";

	private static final String NEW_LINE = System.lineSeparator();

	public static void createCsvReport(Map<String, TestCaseResult> idResultMap) {
		StringBuilder csvData = new StringBuilder();
		csvData.append(REPORT_HEADER_FIRST_COLUMN).append(CSV_SEPARATOR);
		csvData.append(REPORT_HEADER_SECOND_COLUMN).append(CSV_SEPARATOR);
		csvData.append(REPORT_HEADER_THIRD_COLUMN);
		csvData.append(NEW_LINE);

		for (Entry<String, TestCaseResult> entry : idResultMap.entrySet()) {
			csvData.append(entry.getKey()).append(CSV_SEPARATOR);
			csvData.append(entry.getValue().getCategory()).append(CSV_SEPARATOR);
			csvData.append(entry.getValue().getTestCaseResultStatus());
			csvData.append(NEW_LINE);
		}
		System.out.println(csvData);
	}
}
