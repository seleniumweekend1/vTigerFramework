package com.vTigerCRM.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vTigerCRM.genericLib.Base;
import com.vTigerCRM.genericLib.FileLib;

public class Login
{
	
	//Identify web elements
	@FindBy(name="user_name")
	private WebElement userNameTF;
	
	@FindBy(name="user_password")
	private WebElement passwordTF;
	
	@FindBy(id="submitButton")
	private WebElement loginButton;

	//Generate getterMethods
	public WebElement getUserNameTF() 
	{
		return userNameTF;
	}

	public WebElement getPassword() 
	{
		return passwordTF;
	}

	public WebElement getLoginButton() 
	{
		return loginButton;
	}
	
	
	public Login()
	{
		PageFactory.initElements(Base.staticDriver, this);
	}
	
	//Business logic
	public Home vTigerLogin(String userName, String password)
	{
		userNameTF.sendKeys(userName);
		passwordTF.sendKeys(password);
		loginButton.click();
		return new Home();
	}
	
	
	
	
	
}
