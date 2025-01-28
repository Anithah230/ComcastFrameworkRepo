package POM.Repository;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.comcast.com.objectrepsirtory.ContactsPage1;
import com.comcast.com.objectrepsirtory.CreatingNewContactPage1;
import com.comcast.com.objectrepsirtory.homePage;
import com.comcast.com.objectrepsirtorycontacts.ContactInformationPage;
import com.comcast.crm.baseclass.BaseClass;

public class CreateContactsTest extends BaseClass {

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
//	 cn.createcontact(lastName);

		String actLastName = driver.findElement(By.id("dtlview_Last Name")).getText();
		if (actLastName.equals(lastName)) {
			System.out.println(lastName + " information is verified. Test PASS");
		} else {
			System.out.println(lastName + " information is not verified. Test FAIL");
		}
	
	}	
	@Test
	public void createcontactwithsupportdatetest() throws EncryptedDocumentException, IOException {
		 //Read test script data from Excel
		  String lastName = eLib.getdatafromexcel("Sheet1", 4, 2) +jLib.getrandomnumber();
		 
		// Step 2: Navigate to the Contacts module
			homePage hp = new homePage(driver);
			hp.getContactlink().click();
			
			ContactsPage1 cp=new ContactsPage1(driver);
			cp.getCreateContactBtn().click();
			
			String endDate=jLib.getSystemDateYYYYDDMM();
			String startDate=jLib.getRequiredDataYYYYMMDD(30);
			 
			CreatingNewContactPage1 cp1=new CreatingNewContactPage1(driver);
			cp1.createContactWithSupportDate(lastName, startDate, endDate);

			  
			
			  String actStartDate = driver.findElement(By.id("dtlview_Support Start Date")).getText();
			  System.out.println(actStartDate);
			  if(actStartDate.equals(startDate)) {
				  System.out.println(startDate + " is verified. Test PASS");
			  }else
			  {
				  System.out.println(startDate + " is not verified. Test FAIL");
			  }
			  String actEndDate = driver.findElement(By.id("dtlview_Support End Date")).getText();
			  System.out.println(actEndDate);
			  if(actEndDate.equals(endDate)) {
				  System.out.println(endDate + " is verified. Test PASS");
			  }else
			  {
				  System.out.println(endDate + " is not verified. Test FAIL");
			  }
			  
		
			
		

	
	
	}
	

	}


