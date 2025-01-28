package POM.Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	
	WebDriver driver;

	public OrganizationInfoPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(id="dtlview_Organization Name")
	private WebElement headermsg;
	
	
	@FindBy(xpath="//span[@id='dtlview_Phone\']")
	private WebElement PhoneInfo;
	
	@FindBy(id="mouseArea_Organization Name")
	private WebElement getheaderInfo;

	
	public WebElement getHeadermsg() {
		return headermsg;
	}


	public WebElement getGetheaderInfo() {
		return getheaderInfo;
	}


	public WebElement getPhoneInfo() {
	return PhoneInfo;
	}


	public WebElement getOrginfodata() {
		return null;
	}


}

