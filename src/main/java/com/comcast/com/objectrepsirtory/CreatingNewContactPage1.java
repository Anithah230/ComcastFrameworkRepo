package com.comcast.com.objectrepsirtory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.com.genericwebdriverutility.JavaUtility;
import com.comcast.com.genericwebdriverutility.WebDriverUtility;

		public class CreatingNewContactPage1 {
			
			//WebDriver driver;
			public CreatingNewContactPage1 (WebDriver driver) {
				//this.driver=driver;
				PageFactory.initElements(driver, this);
			}
			@FindBy(xpath=("//input[@name='lastname']"))
			private WebElement lastName;
			
			public WebElement getLastName() {
				return lastName;
			}
			@FindBy(xpath=("//input[@title='Save [Alt+S]']"))
			private WebElement saveBtn;
			
			public WebElement getSaveBtn() {
				return saveBtn;
			}
			
			@FindBy(xpath=("//input[@name='account_name']/following-sibling::img"))
			private WebElement plusBtn;

			public WebElement getPlusBtn() {
				return plusBtn;
			}
			
		
			@FindBy(id="search_txt")
			private WebElement searchField;
			
			 
			  public WebElement getSearchField() {
				return searchField;
			}
			  
				@FindBy(name="support_start_date")
				private WebElement start_Date;
				
				 
				  public WebElement getStartDate() {
					return start_Date;
				}
				  
					@FindBy(name="support_end_date")
					private WebElement end_Date;
					
					 
					  public WebElement getEndDate() {
						return end_Date;
					}
			  
			public void createContactWithOrg (WebDriver driver, String orgName, String name) {
				lastName.sendKeys(name);
				plusBtn.click();
				 WebDriverUtility wLib = new WebDriverUtility();
				wLib.switchToFrame(driver, "module=Accounts");
				searchField.sendKeys(orgName);
				wLib.switchToFrame(driver, "Contacts&action");
				saveBtn.click();
			}
			
			public void createContactWithSupportDate (String lastname, String startDate, String endDt){
				lastName.sendKeys(lastname);
	
				start_Date.clear();
				start_Date.sendKeys(startDate);
				end_Date.clear();
				end_Date.sendKeys(endDt);
				saveBtn.click();
			}

	


}
