package com.vTigerCRM.testScripts;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class DemoOfFindBysFindAll 
{
	@FindBys({
		@FindBy(className="gb_g"),
		@FindBy(linkText="Gmail")
	})
	private static List<WebElement> allElements;
	
	@Test
	public static void test()
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.google.com");
		
		PageFactory.initElements(driver, DemoOfFindBysFindAll.class);
		
		System.out.println("Size -> "+allElements.size());
		
		for (WebElement we : allElements) 
		{
			System.out.println(we.getText());
		}
		
	}
	
}
