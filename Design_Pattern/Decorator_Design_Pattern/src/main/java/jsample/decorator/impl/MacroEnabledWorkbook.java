package jsample.decorator.impl;

import jsample.decorator.ExcelWorkbook;
import jsample.decorator.ExcelWorkbookDecorator;

public class MacroEnabledWorkbook extends ExcelWorkbookDecorator {

	public MacroEnabledWorkbook(ExcelWorkbook excelWorkbook) {
		super(excelWorkbook);
	}

	@Override
	public void read() {
		super.read();
		System.out.println("Add support of macro while reading workbook");
	}

	@Override
	public void write() {
		super.write();
		System.out.println("Add support of macro while writing workbook");
	}
}
