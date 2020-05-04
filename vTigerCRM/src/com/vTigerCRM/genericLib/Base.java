package com.vTigerCRM.genericLib;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.vTigerCRM.objectRepository.Home;
import com.vTigerCRM.objectRepository.Login;
/**
 * This class contains configuration annotations for launching the browser, login, logout and close the browser
 * @author Manjunath N
 *
 */
public class Base
{
	public FileLib lib = new FileLib();
	public WebDriver driver = null;
	public static WebDriver staticDriver;
	public WebDriverWait wait = null;
	public Login login = new Login();
	public Home home;
	public Logger log = Logger.getLogger(Base.class);
	@BeforeClass
	public void configBC()
	{
		/* Launch browser */
		if(lib.getPropertyKeyValue("browser").equals("chrome"))
		{
			driver = new ChromeDriver();
			staticDriver = driver;
			System.out.println("Browser Launched Successfully  --> PASS");
		}
		else if(lib.getPropertyKeyValue("browser").equals("firefox"))
		{
			driver = new FirefoxDriver();
			staticDriver = driver;
			System.out.println("Browser Launched Successfully  --> PASS");
		}
		/* Maximize browser */
		driver.manage().window().maximize();
		
		/* Enter URL */
		driver.get(lib.getPropertyKeyValue("url"));
		
		/* Wait statements */
		driver.manage().timeouts().implicitlyWait(Utility.IMPLICIT_WAIT, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, Utility.EXPLICIT_WAIT);
		
		/* Verify Login Page */
		String loginTitle = driver.getTitle();
		if(loginTitle.contains("vtiger CRM 5 - Commercial Open Source CRM"))
		{
			System.out.println("Login Page is displayed --> PASS");
		}
		else
		{
			System.out.println("Login Page not is displayed --> FAIL");
		}
	}
	
	@BeforeMethod
	public void configBM()
	{
		/* Login */
		login = new Login();
		home = login.vTigerLogin(lib.getPropertyKeyValue("username"), lib.getPropertyKeyValue("password"));
		
		if(driver.getTitle().contains("Home"))
		{
			System.out.println("Home Page is displayed --> PASS");
		}
		else
		{
			System.out.println("Home Page not is displayed --> FAIL");
		}
	}
	
	@AfterMethod
	public void configAM()
	{
		/* Sign out */
		home.vTigerLogout();		
		
		if(driver.getTitle().contains("vtiger CRM 5 - Commercial Open Source CRM"))
		{
			System.out.println("Logout is successful --> PASS");
		}
		else
		{
			System.out.println("Logout is not successful --> FAIL");
		}
	}
	
	@AfterClass
	public void configAC()
	{
		/* Close Browser */
		driver.quit();
		System.out.println(driver);
		if(driver == null)
		{
			System.out.println("Browser is closed successfully --> Pass");
		}
		else
		{
			System.out.println("Broser is not closed successfully --> FAIL");
		}
	}	
}