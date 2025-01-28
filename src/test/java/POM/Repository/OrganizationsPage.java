package POM.Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class   OrganizationsPage {
	WebDriver driver;

	public  OrganizationsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
		
	
	@FindBy(name="search_text")
	private WebElement searchedit;
	
	@FindBy(name="search_field")
	private WebElement searchDD;
	
	@FindBy(name="submit")
	private WebElement searchnow;
	
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement createneworgbtn;
	
	
	public WebElement getSearchnow() {
		return searchnow;
	}

	public WebElement getSearchedit() {
		return searchedit;
	}

	public WebElement getSearchDD() {
		return searchDD;
	}

	public WebElement getCreateneworgbtn() {
		return createneworgbtn;
	}
	
	

}
