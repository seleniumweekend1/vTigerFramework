package stale;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class FindBysAndAll 
{
	@FindBys({
		
		@FindBy(linkText="Gmail"),
		@FindBy(className="gb_g")
	})
	private static List<WebElement> allElem;
	
	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.google.com");
		
		PageFactory.initElements(driver, FindBysAndAll.class);
		for (WebElement e : allElem) 
		{
			System.out.println(e.getText());
		}

	}

}
