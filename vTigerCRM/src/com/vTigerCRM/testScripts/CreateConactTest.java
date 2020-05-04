package com.vTigerCRM.testScripts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.vTigerCRM.genericLib.Base;
import com.vTigerCRM.objectRepository.Contacts;

public class CreateConactTest extends Base
{
	public Contacts contacts;

	@Test
	public void createContactTest()
	{		
		contacts = home.clickConactsLink();
		contacts.createNewContact(lib.getExcelData("Contacts", 1, 0), lib.getExcelData("Contacts", 1, 1));
	}
	
}
