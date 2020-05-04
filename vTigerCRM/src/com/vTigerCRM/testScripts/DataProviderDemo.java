package com.vTigerCRM.testScripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vTigerCRM.genericLib.Base;

public class DataProviderDemo
{	
	@DataProvider
	public Object[][] geAllData() throws Exception
	{
		FileInputStream ip = new FileInputStream("./testData/vTiger.xlsx");
		Workbook wb = WorkbookFactory.create(ip);
		Sheet sh = wb.getSheet("Products");
		
		int rw = sh.getLastRowNum();//5
		int cll = sh.getRow(0).getLastCellNum(); //6
		System.out.println(rw);
		System.out.println(cll);
		
		int row = sh.getLastRowNum();
		int cell = sh.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[row][cell];
		for(int i = 0;i<row;i++)
		{
			for(int j = 0;j<cell;j++)
			{
				data[i][j] = sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		return data;
	}
	
	@Test(dataProvider="geAllData")
	public void addToCartTest(String ProductName, String manufacturer, String category, String vendor, String qty, String unitPrice)
	{
		System.out.println(ProductName+" "+manufacturer+" "+category+" "+vendor+" "+qty+" "+unitPrice);
	}
	
}
