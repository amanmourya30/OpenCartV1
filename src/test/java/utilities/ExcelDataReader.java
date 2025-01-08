package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataReader {

	public Object[][] getExcelData(String filepath, int sheetNum) throws IOException {

		Object[][] data = null;

		try {
			FileInputStream file = new FileInputStream(filepath);

			Workbook workbook = new XSSFWorkbook(file);
			Sheet sheet = workbook.getSheetAt(0);

			int rowCount = sheet.getPhysicalNumberOfRows();
			int columnCount = sheet.getRow(0).getPhysicalNumberOfCells();

			data = new Object[rowCount - 1][columnCount];

			for (int i = 1; i < rowCount; i++) {
				Row row = sheet.getRow(i);
				for (int j = 0; j < columnCount; j++) {
					data[i - 1][j] = row.getCell(j).toString();
				}
			}
			workbook.close();
			file.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;

	}

}
