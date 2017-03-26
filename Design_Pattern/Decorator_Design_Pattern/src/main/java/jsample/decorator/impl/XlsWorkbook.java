package jsample.decorator.impl;

import jsample.decorator.ExcelWorkbook;

public class XlsWorkbook implements ExcelWorkbook {

	@Override
	public void read() {
		System.out.println("Read XLS workbook");
	}

	@Override
	public void write() {
		System.out.println("Write XLS workbook");
	}
}
