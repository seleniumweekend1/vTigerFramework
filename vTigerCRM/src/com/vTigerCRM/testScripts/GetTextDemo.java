package com.vTigerCRM.testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTextDemo {

	public static void main(String[] args) 
	{
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.get("http://www.google.com");
//		System.out.println(driver.findElement(By.xpath("//a[contains(text(),'Make')]")).getText());
	
		String[] strs = "     Manjunath      Neelgar     ".split(" ");
		System.out.println(strs.length);
		System.out.println(strs[0].isEmpty()+" -> "+ strs[0]);
	}

}
