package jsample;

import jsample.decorator.ExcelWorkbook;
import jsample.decorator.impl.MacroEnabledWorkbook;
import jsample.decorator.impl.XlsWorkbook;
import jsample.decorator.impl.XlsxWorkbook;

public class App {
	public static void main(String[] args) {

		System.out.println("Reading XLS file ...");
		ExcelWorkbook workbook = new XlsWorkbook();
		workbook.read();

		System.out.println("\nReading Macro Enabled XLS file ...");
		workbook = new MacroEnabledWorkbook(new XlsWorkbook());
		workbook.read();

		System.out.println("\nWriting Macro Enabled XLSX file ...");
		workbook = new MacroEnabledWorkbook(new XlsxWorkbook());
		workbook.write();
	}
}
