package POM.Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class createneworganizationPage {
	

	WebDriver driver;

	public createneworganizationPage(WebDriver driver)
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
	
	@FindBy(id="phone")
	private WebElement phonenumber;
	


	public WebElement getOrgnameedit() {
		return orgnameedit;
	}


	public WebElement getIndustryDD() {
		return industryDD;
	}


	public WebElement getPhonenumber() {
		return phonenumber;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}
	
	
		public void createorg(String lastname) {
		orgnameedit.sendKeys(lastname);
		savebtn.click();
	}	
	public void createorg(String orgname,String industry) {
		Select sel=new Select(industryDD);
		sel.selectByValue(industry);
		savebtn.click();
	
	
	}


	public WebElement getorgNameField() {
		// TODO Auto-generated method stub
		return null;
	}
}

