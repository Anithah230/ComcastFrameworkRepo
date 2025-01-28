package com.comcast.com.objectrepsirtory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homePage {
	
	WebDriver driver;

	public  homePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(linkText = "Organizations")
	private WebElement orglink;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactlink;
	
	@FindBy(linkText = "Campaigns")
	private WebElement campaignlink;
	
	@FindBy(linkText = "More")
	private WebElement morelink;
	
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminimage;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signoutlink;
	
	
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getOrglink() {
		return orglink;
	}

	public WebElement getContactlink() {
		return contactlink;
	}

	public WebElement getCampaignlink() {
		return campaignlink;
	}

	public WebElement getMorelink() {
		return morelink;
		
		
	}
	
	public void Navigatetocampaginpage() {
		Actions act=new Actions(driver);
		act.moveToElement(morelink).perform();
		campaignlink.click();
	}
	
	public void logout(WebDriver driver) {
		Actions act=new Actions(driver);
		act.moveToElement(adminimage).perform();
		signoutlink.click();
		
	
	}
	
	
	
}


