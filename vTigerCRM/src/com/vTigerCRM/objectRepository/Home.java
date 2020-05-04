package com.vTigerCRM.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vTigerCRM.genericLib.Base;
import com.vTigerCRM.genericLib.Utility;

public class Home 
{
	//identify webelements
	@FindBy(xpath="//img[contains(@src,'user.PNG')]")
	private WebElement userIcon;
	
	@FindBy(linkText="Sign Out")
	private WebElement signOutLink;
	
	@FindBy(linkText="Contacts")
	private WebElement contactsLink;
	
	@FindBy(linkText="Organization")
	private WebElement organizationLink;

	//getter methods
	public WebElement getUserIcon() 
	{
		return userIcon;
	}

	public WebElement getSignOutLink() 
	{
		return signOutLink;
	}

	public WebElement getContactsLink() 
	{
		return contactsLink;
	}
	
	//constructor
	public Home()
	{
		PageFactory.initElements(Base.staticDriver, this);
	}
	
	//click on contacts link
	public Contacts clickConactsLink()
	{
		contactsLink.click();
		return new Contacts();
	}
	
	//business login
	public void vTigerLogout()
	{
		Utility.actMoveToElement(Base.staticDriver, userIcon);
		signOutLink.click();
	}
	
	
}
