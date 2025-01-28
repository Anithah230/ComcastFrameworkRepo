package POM.Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	//step1-create separate class for each page
	//step2-obj creation
	@FindBy(name="user_name")
	private WebElement usernameedit;
	
	@FindBy(name="user_password")
	private WebElement passwordedit;
	
	@FindBy(id="submitButton")
	private WebElement loginbtn;
	
	//step3-object init
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
	
		//step5-provide action
	public void logintoapp(String un,String pwd)
	{
		driver.manage().window().maximize();
		usernameedit.sendKeys(un);
		passwordedit.sendKeys(pwd);
		loginbtn.click();
		
	}

	}
		
	
	







