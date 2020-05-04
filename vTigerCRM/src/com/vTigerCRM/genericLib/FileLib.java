package com.vTigerCRM.genericLib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class contains generic methods to read data from properties file and excel file
 * @author Manjunath
 *
 */


public class FileLib 
{
	/**
	 * This method is used to read the property value from properties file
	 * @param key
	 * @return String
	 */
	
	public String getPropertyKeyValue(String key)
	{
		Properties prop = null;
		try 
		{
			FileInputStream ip = new FileInputStream("./testData/commonData.properties");
			prop = new Properties();
			prop.load(ip);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return prop.getProperty(key);
	}
	
	/**
	 * This method is used to read the data from excel file
	 * @param sheetName
	 * @param rowIndex
	 * @param cellIndex
	 * @return String
	 */
	
	public String getExcelData(String sheetName, int rowIndex, int cellIndex)
	{
		Sheet sh = null;
		try 
		{
			FileInputStream ip = new FileInputStream("./testData/vTiger.xlsx");
			Workbook wb = WorkbookFactory.create(ip);
			sh = wb.getSheet(sheetName);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return sh.getRow(rowIndex).getCell(cellIndex).getStringCellValue();
		
	}
	/**
	 * Dataprovider method
	 * @return
	 * @throws Exception
	 */
	
	public Object[][] dataProviderMethod() throws Exception
	{
		FileInputStream ip = new FileInputStream("./testData/vTiger.xlsx");
		Workbook wb = WorkbookFactory.create(ip);
		Sheet sh = wb.getSheet("Products");
		
		int rw = sh.getLastRowNum();//5
		int cll = sh.getRow(0).getLastCellNum(); //6
		
		
		Object[][] data = new Object[rw][cll];
		
		for(int i=1;i <=rw;i++)
		{
			for(int j = 0; j<cll;j++)
			{
				data[i-1][j] = sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return data;
	}
	
	
}
