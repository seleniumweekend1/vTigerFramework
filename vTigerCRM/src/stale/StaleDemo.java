package stale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class StaleDemo 
{
	@FindBy(xpath="//input[@name='user_name']")
	static WebElement userNameTF;
	
	public static void main(String[] args)
	{
		WebDriver driver = new ChromeDriver();
		
		StaleDemo abc = PageFactory.initElements(driver, StaleDemo.class);
		
		driver.manage().window().maximize();
		driver.get("http://localhost:8888");
		
		//WebElement userNameTF = driver.findElement(By.name("user_name"));
		
		
		driver.navigate().refresh();
		
		userNameTF.sendKeys("admin");
	}

}
