package genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileUtility {
	
		public String getDataFromPropertiesFile(String key) throws IOException {
			
//	        1.	Get the Java Representation Object of the physical file
			FileInputStream fis = new FileInputStream("./src/main/resources/CommonData.properties");
//			2.	Use the load() of Properties class to load all the keys
			Properties pObj = new Properties();
			pObj.load(fis);
//			3.	Use the getProperty(Key) and pass the key and get the value in String format
			String value = pObj.getProperty(key);
			return value;
		}

		public String getStringDatafromExcelfile(String sheetname,int rownum,int cellnum) throws EncryptedDocumentException, IOException {
			 
		FileInputStream fis = new FileInputStream("./src/main/resources/testScriptData.xlsx");
				
				Workbook wb = WorkbookFactory.create(fis);
				
				Sheet sh = wb.getSheet(sheetname);
				
				Row row = sh.getRow(rownum);
				
				Cell cell = row.getCell(cellnum);
				
				String value = cell.getStringCellValue();
				
				wb.close();
				
			return value;
		} 
		
		public int getNumericDatafromExcelfile(String sheetname,int rownum,int cellnum) throws EncryptedDocumentException, IOException {
			
	    FileInputStream fis = new FileInputStream("./src/main/resources/testScriptData.xlsx");
				
				Workbook wb = WorkbookFactory.create(fis);
				
				Sheet sh = wb.getSheet(sheetname);
				
				Row row = sh.getRow(rownum);
				
				Cell cell = row.getCell(cellnum);
				
				int value = (int) cell.getNumericCellValue();
				
				wb.close();
				
			return value;
		} 

}
