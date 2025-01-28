package POM.Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class createcontactspage {
	
	WebDriver driver;

	public createcontactspage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//img[@title='Create Contact...\']")
    private WebElement createcontactsbtn;

	public WebElement getCreatecontactsbtn() {
		return createcontactsbtn;
	}

	

	
	}
	


