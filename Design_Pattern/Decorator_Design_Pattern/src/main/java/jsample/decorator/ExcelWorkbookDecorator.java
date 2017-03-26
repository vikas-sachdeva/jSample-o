package jsample.decorator;

/**
 * Decorator design pattern is used to modify the functionality of an object at
 * runtime. At the same time other instances of the same class will not be
 * affected by this, so individual object gets the modified behavior.
 * 
 * Decorator design pattern is one of the structural design pattern.
 *
 */
/**
 * Decorator design pattern is helpful in providing runtime modification
 * abilities and hence more flexible. Its easy to maintain and extend when the
 * number of choices are more.
 * 
 * The disadvantage of decorator design pattern is that it uses a lot of similar
 * kind of objects (decorators).
 * 
 * Decorator pattern is used a lot in Java IO classes, such as FileReader,
 * BufferedReader etc.
 *
 */
public class ExcelWorkbookDecorator implements ExcelWorkbook {

	protected ExcelWorkbook excelWorkbook;

	public ExcelWorkbookDecorator(ExcelWorkbook excelWorkbook) {
		this.excelWorkbook = excelWorkbook;
	}

	@Override
	public void read() {
		excelWorkbook.read();
	}

	@Override
	public void write() {
		excelWorkbook.write();
	}
}
