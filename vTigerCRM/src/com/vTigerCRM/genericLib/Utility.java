package com.vTigerCRM.genericLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;

/**
 * This class contains utility methods like select, actions, switch to window etc.
 * @author Manjunath
 *
 */
public class Utility 
{
	public static final long IMPLICIT_WAIT = 20; 
	public static final long EXPLICIT_WAIT = 20;
	
	/**
	 * This method is used to select an option by value from Select Dropdown
	 * @param element
	 * @param value
	 */
	public static void select(WebElement element, String value)
	{
		Select sel = new Select(element);
		sel.selectByValue(value);
	}
	
	public static void actMoveToElement(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
}
