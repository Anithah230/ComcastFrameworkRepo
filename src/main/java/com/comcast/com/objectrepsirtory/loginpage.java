package com.comcast.com.objectrepsirtory;

import java.time.Duration;
/**
 * @author anith
 * contains login page elements & business lib like login()
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.com.genericwebdriverutility.WebDriverUtility;

public class loginpage extends WebDriverUtility { //step1-create separate class for each page

	//step2-obj creation
	WebDriver driver;

	public loginpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	//step3-object initialization
	@FindBy(name="user_name")
	private WebElement usernameedit;
	
	@FindBy(name="user_password")
	private WebElement passwordedit;
	
	@FindBy(id="submitButton")
	private WebElement loginbtn;
	

		//step4-encapsulation
	public WebElement getUsernameedit() {
		return usernameedit;
	}

	public WebElement getPasswordedit() {
		return passwordedit;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}
	
	/**
	 * login to application based username,password,url arguments
	 * @param URL
	 * @param UNAME
	 */
	
	
	
	//step5-provide action(utilization)
	public void logintoapp(String URL,String UNAME)
	{
	    waitForPageToLoad(driver);
		driver.get(URL);
		driver.manage().window().maximize();
		usernameedit.sendKeys(UNAME);
		passwordedit.sendKeys(PASSWORD);
		loginbtn.click();
		
	}
		
	
	
}






