package com.comcast.com.objectrepsirtory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class createneworganizationpage {
	

	WebDriver driver;

	public createneworganizationpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(name="accountname")
	private WebElement orgnameedit;
	
	
	@FindBy(xpath="//input[@title=\'Save [Alt+S]']")
	private WebElement savebtn;
	

	@FindBy(name="industry")
	private WebElement industryDD;


	public WebElement getorgnameedit() {
		return orgnameedit;
	}


	public WebElement getSavebtn() {
		return savebtn;
	}
	
	public void createorgg(String lastname) {
		orgnameedit.sendKeys(lastname);
		savebtn.click();
	}	
	public void createorgg(String orgname,String industry) {
		Select sel=new Select(industryDD);
		sel.selectByValue(industry);
		savebtn.click();
	
	
	}
}
