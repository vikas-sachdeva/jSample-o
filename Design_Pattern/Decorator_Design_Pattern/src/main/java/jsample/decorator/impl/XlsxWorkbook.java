package jsample.decorator.impl;

import jsample.decorator.ExcelWorkbook;

public class XlsxWorkbook implements ExcelWorkbook {

	@Override
	public void read() {
		System.out.println("Read XLSX workbook");
	}

	@Override
	public void write() {
		System.out.println("Write XLSX workbook");
	}
}
