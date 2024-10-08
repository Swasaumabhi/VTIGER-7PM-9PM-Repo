package genericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {
	
	//To read data from excel sheet
	
	public String readDataFromExcelFile(String sheetName, int rowNum, int cellNum) throws EncryptedDocumentException, IOException {
		FileInputStream fis= new FileInputStream("./configAppData/testscriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		wb.close();
		return data;
	}
	
	//To get the row count
	
	public int getRowCount(String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fis= new FileInputStream("./configAppData/testscriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int rowCount = wb.getSheet(sheetName).getLastRowNum();
		wb.close();
		return rowCount;
	}
	
	//To write the data back to excel sheet
	
	public void writeDataIntoExcelFile(String sheetName, int rowNum, int cellNum) throws EncryptedDocumentException, IOException {
		FileInputStream fis= new FileInputStream("./configAppData/testscriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(rowNum).createCell(cellNum);
		
		FileOutputStream fos= new FileOutputStream("./configAppData/testscriptData.xlsx");
		wb.write(fos);
		wb.close();
		
	}

}
