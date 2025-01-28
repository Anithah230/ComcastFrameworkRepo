package com.comcast.com.objectrepsirtorycontacts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContact {
	
	WebDriver driver;
	
	public CreateContact(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(linkText="COntacts")
	private WebElement contactlink;
	
	@FindBy(xpath="//img[title='Create Contact...']")
	private WebElement conatctlink;
	
	@FindBy(name="lastname")
	private WebElement contactlastname;

	public WebElement getContactlink() {
		return contactlink;
	}

	public WebElement getConatctlink() {
		return conatctlink;
	}

	public WebElement getContactlastname() {
		return contactlastname;
	}

}
