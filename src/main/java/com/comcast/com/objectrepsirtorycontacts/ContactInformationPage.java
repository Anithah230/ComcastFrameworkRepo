package com.comcast.com.objectrepsirtorycontacts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformationPage {

	WebDriver driver;

	public ContactInformationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//span[@id='dtlview_Last Name']")
	private WebElement  ActLastName;
	
	public Object getActLastName() {
		return ActLastName;
	}
}
