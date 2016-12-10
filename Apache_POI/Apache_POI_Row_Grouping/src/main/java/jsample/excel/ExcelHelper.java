package jsample.excel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelHelper {

	public static void groupExcelRows(String excelFilePath)
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		/**
		 * Make a copy of the file for avoiding change to original file.
		 */

		File excelFile = new File(excelFilePath);
		String tempFilePath = excelFilePath.replaceAll(".xls", "_temp.xls");

		Files.copy(excelFile.toPath(), Paths.get(tempFilePath), StandardCopyOption.REPLACE_EXISTING);

		try (Workbook workbook = WorkbookFactory.create(new File(tempFilePath))) {
			System.out.println("Reading workbook " + excelFilePath);
			for (int sheetNum = 0; sheetNum < workbook.getNumberOfSheets(); sheetNum++) {
				Sheet sheet = workbook.getSheetAt(sheetNum);
				System.out.println("Reading sheet " + sheet.getSheetName());
				readSheet(sheet);
			}
			/**
			 * Write out this document to an OutputStream.
			 *
			 * In case of XSSFWorkbook, if the document was opened from a File
			 * rather than an InputStream, write out to a different file,
			 * overwriting via an OutputStream isn't possible. However, after
			 * writing to a different file, original file is also get modified.
			 * 
			 */
			String groupedFilePath = excelFilePath.replaceAll(".xls", "_grouped.xls");
			try (FileOutputStream fileOutputStream = new FileOutputStream(groupedFilePath)) {
				workbook.write(fileOutputStream);
				System.out.println("Workbook after grouping " + groupedFilePath + " is created.");
			}
		}
		new File(tempFilePath).delete();
	}

	private static void readSheet(Sheet sheet) {
		// Skipping first header row
		for (int startRowIndex = 1; startRowIndex <= sheet.getLastRowNum(); startRowIndex++) {
			Row startRow = sheet.getRow(startRowIndex);
			if (startRow != null && startRow.getCell(0, MissingCellPolicy.RETURN_BLANK_AS_NULL) != null) {
				int endRowIndex = startRowIndex + 1;
				for (; endRowIndex <= sheet.getLastRowNum(); endRowIndex++) {
					Row endRow = sheet.getRow(endRowIndex);
					if (endRow != null && endRow.getCell(0, MissingCellPolicy.RETURN_BLANK_AS_NULL) != null) {
						break;
					}
				}
				/**
				 * Group Rows using groupRow() method
				 */
				if (endRowIndex != startRowIndex + 1) {
					sheet.groupRow(startRowIndex + 1, endRowIndex - 1);
					/**
					 * Set whether group should remain collapsed or expanded by
					 * default.
					 * 
					 * setting second parameter to true will collapse the group.
					 * Setting second parameter to false will expand the group.
					 */
					sheet.setRowGroupCollapsed(startRowIndex + 1, false);

				}
			}

			if (startRow != null && startRow.getCell(1, MissingCellPolicy.RETURN_BLANK_AS_NULL) != null) {
				int endRowIndex = startRowIndex + 1;
				for (; endRowIndex <= sheet.getLastRowNum(); endRowIndex++) {
					Row endRow = sheet.getRow(endRowIndex);
					if (endRow != null && endRow.getCell(0, MissingCellPolicy.RETURN_BLANK_AS_NULL) != null) {
						break;
					}
				}
				if (endRowIndex != startRowIndex + 1) {
					sheet.groupRow(startRowIndex + 1, endRowIndex - 1);
					sheet.setRowGroupCollapsed(startRowIndex + 1, true);
				}
			}
		}
	}
}