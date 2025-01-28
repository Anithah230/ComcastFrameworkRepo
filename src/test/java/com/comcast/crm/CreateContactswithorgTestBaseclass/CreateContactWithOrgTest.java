package com.comcast.crm.CreateContactswithorgTestBaseclass;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.com.genericwebdriverutility.UtilityClassObject;
import com.comcast.com.objectrepsirtory.homePage;
import com.comcast.com.objectrepsirtory.organizationinfopage;
import com.comcast.com.objectrepsirtory.organizationspage;
import com.comcast.com.objectrepsirtorycontacts.ContactInformationPage;
import com.comcast.crm.Listenerutility.Listener;
import com.comcast.crm.baseclass.BaseClass;

import POM.Repository.createneworganizationPage;


@Listeners(com.comcast.crm.Listenerutility.Listener.class)
public class CreateContactWithOrgTest extends BaseClass {

	@Test(groups = "smokeTest")
	public void createorg() throws Throwable, IOException {
		
		UtilityClassObject.getTest().log(Status.INFO, "real data from Excel");
		//read the data form Excel file
      String lastname = eLib.getdatafromexcel("Sheet1", 1, 3) + jLib.getrandomnumber();

      //step2:navigate to organization module
      UtilityClassObject.getTest().log(Status.INFO, " navigate to org page");
       homePage hp = new homePage(driver);
		hp.getOrglink().click();

		// Step 3: Click on the Create Organization button
		UtilityClassObject.getTest().log(Status.INFO, " navigate to  create org page");
		organizationspage op = new organizationspage(driver);
		op.getCreateneworgbtn().click();

		// Step 4: Enter all the details & create new organization
		UtilityClassObject.getTest().log(Status.INFO, " navigate to  create new org");
		createneworganizationPage cnop = new createneworganizationPage(driver);
		cnop.createorg(lastname);
		 Listener.test.log(Status.INFO,lastname +"===>create a new org");

		// Verify header msg expected result

		organizationinfopage oip = new organizationinfopage(driver);
		String headerInfo = oip.getHeadermsg().getText();

		if (headerInfo.contains(lastname)) {
			System.out.println(lastname + "  is created and header verified. Test case PASS");
		} else {
			System.out.println(lastname + " is not created. Test case FAIL");
		}

	}

//	@Test(groups="Regression")//CreateorgwithPhonenumber
//	@Test(groups="Regression")//createorgwithindustry

}
