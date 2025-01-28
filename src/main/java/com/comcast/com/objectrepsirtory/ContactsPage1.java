package com.comcast.com.objectrepsirtory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage1 {

		//WebDriver driver;

		public ContactsPage1 (WebDriver driver) {

			//this.driver=driver;

			PageFactory.initElements(driver, this);

		}

		@FindBy(className = "dvHeaderText")
		private WebElement headermsg;

		public WebElement getHeadermsg() {
			return headermsg;
		}

		@FindBy(xpath=("//img[@title='Create Contact...']"))

		private WebElement createContactBtn;

		

		public WebElement getCreateContactBtn() {

			return createContactBtn;

		}

	}

