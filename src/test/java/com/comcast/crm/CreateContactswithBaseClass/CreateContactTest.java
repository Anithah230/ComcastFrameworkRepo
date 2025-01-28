package com.comcast.crm.CreateContactswithBaseClass;

import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.com.objectrepsirtory.ContactsPage1;
import com.comcast.com.objectrepsirtory.CreatingNewContactPage1;
import com.comcast.com.objectrepsirtory.homePage;
import com.comcast.crm.baseclass.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;

import POM.Repository.HomePage;
import POM.Repository.createcontactspage;
import POM.Repository.createneworganizationPage;

public class CreateContactTest extends BaseClass {
	@Test
	public void CreateContactTest() throws Throwable, IOException {

		// Read test script data from Excel
		String lastName = eLib.getdatafromexcel("Sheet1", 1, 2) + jLib.getrandomnumber();

		// Step 2: Navigate to the Contacts module
		homePage hp = new homePage(driver);
		hp.getContactlink().click();

		// Step 3: Click on the Create Contacts button
		ContactsPage1 cp = new ContactsPage1(driver);
		cp.getCreateContactBtn().click();

		// Step 4: Enter all the details & create new contact
		CreatingNewContactPage1 cn = new CreatingNewContactPage1(driver);
		cn.getLastName().sendKeys(lastName);
		cn.getSaveBtn().click();
		
		
		String actHeader=cp.getHeadermsg().getText();
		boolean status = actHeader.contains(lastName);
		Assert.assertEquals(status, true);
		
		
//		String actLastName=driver.findElement(By.id("dtlview_Last Name")).getText();
//		SoftAssert soft=new SoftAssert();
//		Assert.assertEquals(actLastName, lastName);

	}

	@Test

	public void CreateContactwithsupportdatetest() throws EncryptedDocumentException, IOException  {

		String startDate = jLib.getSystemDateYYYYDDMM();
		String endDate = jLib.getRequiredDataYYYYMMDD(30);
		String lastname = eLib.getdatafromexcel("Sheet1", 1, 2) + jLib.getrandomnumber();

		homePage hp = new homePage(driver);
		hp.getContactlink().click();

		// Step 3: Click on the Create Contacts button
		ContactsPage1 cp = new ContactsPage1(driver);
		cp.getCreateContactBtn().click();

		String endDate1 = jLib.getSystemDateYYYYDDMM();
		String startDate1 = jLib.getRequiredDataYYYYMMDD(30);

		CreatingNewContactPage1 cNP = new CreatingNewContactPage1(driver);
		cNP.createContactWithSupportDate(lastname, startDate1, endDate1);
		String actStartDate = driver.findElement(By.id("dtlview_Support Start Date")).getText();

		if (actStartDate.equals(startDate1)) {
			System.out.println(startDate1 + " is verified. Test PASS");
		} else {
			System.out.println(startDate1 + " is not verified. Test FAIL");
		}

		String actEndDate = driver.findElement(By.id("dtlview_Support End Date")).getText();
		System.out.println(actEndDate);
		if (actEndDate.equals(endDate1)) {
			System.out.println(endDate1 + " is verified. Test PASS");
		} else {
			System.out.println(endDate1 + " is not verified. Test FAIL");
		}
	}

}
