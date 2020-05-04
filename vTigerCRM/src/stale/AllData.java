package stale;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class AllData {

	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	{
		//NOTE : Please import all packages and classes from org.apache.poi.ss.usermodel
				//Create an object of FileInputStream class and pass excel file path as argument
				FileInputStream ip = new FileInputStream("./testData/vTiger.xlsx");
				
				//Call create() and pass FileInputStream object
				Workbook wb = WorkbookFactory.create(ip);
				
				//call getSheet() and pass sheet name as argument
				Sheet sh = wb.getSheet("Products");
				

				//store the last row index in variable
				int rn = sh.getPhysicalNumberOfRows();
				
				//store the last cell number in variable
				int cn = sh.getRow(0).getLastCellNum();
				
				Object[][] data =new Object[rn][cn];
				
				//logic to read all the data from sheet
				for(int i = 1;i <=rn;i++)
				{
					for(int j = 0; j < cn;j++)
					{
						//get the data from specified cell and print in console
						data[i][j] = sh.getRow(i).getCell(j).getStringCellValue();
					}
					System.out.println();// to go to new line
				}

	}

}
