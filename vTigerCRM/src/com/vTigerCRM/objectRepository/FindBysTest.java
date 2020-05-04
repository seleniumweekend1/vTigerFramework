package com.vTigerCRM.objectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class FindBysTest 
{
	@FindAll
	({
		@FindBy(linkText="Gmailll"),
		@FindBy(xpath="//a[@class='gb_g']")
	})
	private static List<WebElement> elements;
	
	@Test
	public static void myTest()
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.google.com");
		
		PageFactory.initElements(driver, FindBysTest.class);
		
		System.out.println(elements.size());
		for (WebElement we : elements) 
		{
			System.out.println(we.getText());
		}
	}
}
