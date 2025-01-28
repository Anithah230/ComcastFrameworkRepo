package com.comcast.com.objectrepsirtory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class organizationinfopage {

	
	WebDriver driver;
	public organizationinfopage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement headermsg;
	
	public WebElement getHeadermsg() {
		return headermsg;
	}
	
	public WebElement getOrginfodata() {
		return orginfodata;
	}

	public WebElement getPhoneinfo() {
		return phoneinfo;
	}
	

	@FindBy(id="dtlview_Organization Name")
	private WebElement orginfodata;
	
	@FindBy(xpath="//span[@id='dtlview_Phone']")
	private WebElement phoneinfo;
	
	
	
	
}
