package testleaf.marathon;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Marathon3_ReadExcel{

	public static String[][] readExcel(String filename) throws IOException{
		XSSFWorkbook book = new XSSFWorkbook("./data/"+filename+".xlsx");
		XSSFSheet sheetAt = book.getSheetAt(0);
		int lastRowNum = sheetAt.getLastRowNum();
		System.out.println("Row Count: " + lastRowNum);
		short lastCellNum = sheetAt.getRow(0).getLastCellNum();
		System.out.println("Column Count: " + lastCellNum);
		
		String[][] data = new String[lastRowNum][lastCellNum];
		for (int i = 1; i <= lastRowNum; i++) {
			XSSFRow row = sheetAt.getRow(i);
			for (int j = 0; j < lastCellNum; j++) {
				XSSFCell cell= row.getCell(j);
				System.out.println("cell type: " + cell.getCellType());
				switch (cell.getCellType()) {
	            case STRING:
	                System.out.println(cell.getStringCellValue());
	                String stringCellValue = row.getCell(j).getStringCellValue();
	                System.out.println("String value: " + stringCellValue);
	                data[i-1][j] = stringCellValue;
	                break;
	            case NUMERIC:
	                System.out.println(cell.getNumericCellValue());
	                int cellValue = (int)row.getCell(j).getNumericCellValue();
	                System.out.println("int value: " + cellValue);
	                data[i-1][j] = String.valueOf(cellValue);
	                break;
	            default :
	            }
			}
		}
		book.close();
		return data;
	}
}
	