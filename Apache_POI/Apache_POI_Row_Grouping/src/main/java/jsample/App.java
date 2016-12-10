package jsample;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import jsample.excel.ExcelHelper;

public class App {

	private static final String EXCEL_FILE_PATH = "./input/CurrencyCodes.xlsx";

	public static void main(String[] args)
			throws FileNotFoundException, IOException, EncryptedDocumentException, InvalidFormatException {
		ExcelHelper.groupExcelRows(EXCEL_FILE_PATH);
	}
}