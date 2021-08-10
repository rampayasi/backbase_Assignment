package backbase.Utilties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.w3c.dom.UserDataHandler;

public class TestDataReader {
	
	
	public String returnTestData(String testCaseName, String requiredData, String sheetName) throws IOException
	{
		HashMap<String, String> hMap = new HashMap<String, String>();
		String path = System.getProperty("user.dir") + "//TestData//TestDataE.xlsx";
		String returnValue = null;
		try {
			FileInputStream fis = new FileInputStream(path);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);

			int totalrows = sheet.getLastRowNum();
			int totalcolumn = sheet.getRow(1).getLastCellNum();
		
			short topRow = sheet.getTopRow();
			
			for(int r =1; r<=totalrows; r++)
			{
				XSSFRow row = sheet.getRow(r);
				XSSFCell tcName = sheet.getRow(r).getCell(0);
				System.out.println(tcName);
				if((tcName.toString()).contains(testCaseName))
				{
					for(int c=0; c<totalcolumn; c++)
					{
						XSSFCell cell = row.getCell(c);
					
						String ss = cell.toString();
						System.out.println("%s and %s".formatted(sheet.getRow(0).getCell(c).toString(), cell.toString(), cell.toString()));
						hMap.put(sheet.getRow(0).getCell(c).toString(), cell.toString());	
					}	
				}
			}
			
			returnValue = hMap.get(requiredData);	
			workbook.close();
			
			fis.close();
			
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		return returnValue;
		
	
	}

	public void writeData(String tcaseName, String fieldToWrite, String textToWrite, String sheetName) throws IOException
	{
		String status = null;
		
		HashMap<String, String> hMap = new HashMap<String, String>();
		Map<String, Integer[]> map = new HashMap<String, Integer[]>();
		String path = System.getProperty("user.dir") + "//TestData//TestDataC.xlsx";
		String returnValue = null;
		try {
			FileInputStream fis = new FileInputStream(path);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);

			int totalrows = sheet.getLastRowNum();
			int totalcolumn = sheet.getRow(1).getLastCellNum();
			Cell cell = null;
			short topRow = sheet.getTopRow();
			
			for(int r =1; r<=totalrows; r++)
			{
				XSSFRow row = sheet.getRow(r);
				XSSFCell tcName1 = sheet.getRow(r).getCell(0);
				//System.out.println(tcName);
				if(tcName1.toString().contains(tcaseName))
				{
					for(int c=0; c<totalcolumn; c++)
					{
						cell = row.getCell(c);
						
						if(cell.toString() == null || cell.getStringCellValue() == null)
						{
							map.put(sheet.getRow(0).getCell(c).toString(), new Integer[] {1,c});
						}
						else
						{
							hMap.put(sheet.getRow(0).getCell(c).toString(), cell.toString());
							map.put(sheet.getRow(0).getCell(c).toString(), new Integer[] {r,c});
						}
							
					}	
				}
			}
			
			System.out.println(hMap.get("Create"));
			
			Integer[] inte = map.get(fieldToWrite);
			int rowForUpdate = inte[0];
			int colForUpdate = inte[1];
			if(hMap.get(fieldToWrite) == null)
			{
				
				Cell cellUpdate = sheet.getRow(rowForUpdate).createCell(colForUpdate);
				System.out.println(cellUpdate.toString());
				cellUpdate.setCellValue(textToWrite);
			}
			else
			{
				Cell cellUpdate = sheet.getRow(rowForUpdate).createCell(colForUpdate);
				System.out.println(cellUpdate.toString());
				cellUpdate.setCellValue(textToWrite);
			}
			
			
			FileOutputStream outPutStream = new FileOutputStream(path);
			workbook.write(outPutStream);
			workbook.close();
			outPutStream.close();
			
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		

		
	}
	
	
	

}
