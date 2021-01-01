package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDrivenTesting {
	
	
	public Object[][] getData() throws IOException{
		
		File file = new File(System.getProperty("user.dir")+"\\src\\main\\java\\testdata\\Book.xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);
		
		XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
		XSSFSheet sheet = workbook.getSheetAt(0);
		workbook.close();
		
		int rowNum = sheet.getLastRowNum();
		int colNum = sheet.getRow(0).getLastCellNum();
		
		Map<Object, Object> data = new HashMap<Object, Object>();
		Object[][] obj = new Object[rowNum][1];
		for (int i=0; i<rowNum; i++) {
			for(int j=0; j<colNum; j++) {
				
				data.put(sheet.getRow(0).getCell(j).toString(), sheet.getRow(i+1).getCell(j).toString());
				
			}
			
			obj[i][0]=data;
		}
		
		
		
		
		return obj;
	}
	
	
	}
	