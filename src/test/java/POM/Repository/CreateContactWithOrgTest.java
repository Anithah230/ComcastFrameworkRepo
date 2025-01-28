package POM.Repository;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.com.genericwebdriverutility.JavaUtility;
import com.comcast.com.genericwebdriverutility.WebDriverUtility;
import com.comcast.com.objectrepsirtory.ContactsPage1;
import com.comcast.com.objectrepsirtory.CreatingNewContactPage1;
import com.comcast.com.objectrepsirtorycontacts.ContactInformationPage;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;

public class CreateContactWithOrgTest {
	
public static void main(String[] args) throws Exception {
		
		//Create object
		FileUtility fLib=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		
		
		WebDriver driver = null;
		
		String baseurl = fLib.getDataFromPropertiesFile("baseurl");
		String browser = fLib.getDataFromPropertiesFile("browser");
		String un = fLib.getDataFromPropertiesFile("username");
		String pwd = fLib.getDataFromPropertiesFile("password");
		  
		  //Read test script data from Excel
		 
		  String orgName = eLib.getdatafromexcel("Contact", 7, 2) + jLib.getrandomnumber();
		  String lastName = eLib.getdatafromexcel("Contact", 7, 3);
		  
		  if(browser.equals("chrome"))
		  {
			  driver=new ChromeDriver();
		  }
		  else if(browser.equals("firefox"))
		  {
			  driver=new FirefoxDriver();
		  }
		  else
		  {
			  driver=new ChromeDriver();
		  }
		  //Step 1: Login to the app
		  wLib.maximizeWindow(driver);
		  wLib.waitForPageToLoad(driver);
		  driver.get(baseurl);
		  LoginPage lp=new LoginPage(driver);
		  lp.logintoapp(un, pwd);
			/*
			 * driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(un);
			 * driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(pwd);
			 * driver.findElement(By.id("submitButton")).click();
			 */
		  
		  //Step 2: Navigate to the organization module
		  HomePage hp=new HomePage(driver);
		  hp.getOrglink().click();
		  //driver.findElement(By.xpath("//a[.='Organizations']")).click();
		  
		  //Step 3: Click on the Create Organization button
		  OrganizationsPage op=new OrganizationsPage(driver);
		  op.getCreateneworgbtn().click();
		  //driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		  
		  //Step 4: Enter all the details & create new organization
		  CreateNewOrganizationPage cOP=new CreateNewOrganizationPage(driver);
		  cOP.getorgNameField().sendKeys(orgName);
		  cOP.getSavebtn().click();
			/*
			 * driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgName
			 * ); driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			 */
		  
		  //Step 5: Navigate to Contacts module
			
			  for (int i = 0; i < 3; i++) { // Retry mechanism
			  try { WebElement contactsLink = driver.findElement(By.xpath("//a[.='Contacts']"));
			  contactsLink.click(); 
			  break; // Exit loop if successful 
			  } catch
			  (StaleElementReferenceException e) {
			  System.out.println("Element went stale. Retrying..."); } }
			 
		  //Step 6: Click on the Create Contacts button
			  ContactsPage1 cP=new ContactsPage1(driver);
			  cP.getCreateContactBtn().click();
			  //driver.findElement(By.xpath("//img[@title='Create Contact...\']")).click();
		  
		  //Step 7: Enter all the details & create new contact
			  CreatingNewContactPage1 cNCP=new CreatingNewContactPage1(driver);
			  cNCP.createContactWithOrg(driver, orgName, lastName);
			/*
			 * cNCP.getLastName().sendKeys(lastName); cNCP.getSaveBtn().click();
			 */
				/*
				 * driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastName);
				 * driver.findElement(By.xpath(
				 * "//input[@name='account_name']/following-sibling::img")).click();
				 */
		  
		  //Switching control to window popup (child) on adding org name
			/*
			 * wLib.switchToTabOnURL(driver, "module=Accounts");
			 * 
			 * driver.findElement(By.id("search_txt")).sendKeys(orgName);
			 * driver.findElement(By.name("search")).click();
			 * 
			 * WebElement ele = driver.findElement(By.xpath("//a[.='" + orgName + "']"));
			 * 
			 * wLib.waitForElementPresent(driver, ele, 10); ele.click();
			 * 
			 * //Switching the control back to the parent window
			 * wLib.switchToTabOnURL(driver, "Contacts&action");
			 * 
			 * cOP.getsaveBtn().click();
			 */
		  //driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		  
		  //Verify last name contact
		  ContactInformationPage cip=new ContactInformationPage(driver);
		  String actLastName = cip.getActLastName().gettext(); 
		  //String actLastName = driver.findElement(By.xpath("//span[@id='dtlview_Last Name']")).getText();
		  System.out.println(actLastName);
		  if(actLastName.equals(lastName)) {
			  System.out.println(lastName + " name is verified. Test PASS");
		  }else
		  {
			  System.out.println(lastName + " name is not verified. Test FAIL");
		  }
		  
		  //Verify org name
		  OrganizationInfoPage oIP=new OrganizationInfoPage(driver);
		  String headerInfo=oIP.getGetheaderInfo().getText();
		  //String headerInfo = driver.findElement(By.id("mouseArea_Organization Name")).getText();
		  if(headerInfo.contains(orgName)) {
			  System.out.println(orgName + "  is created and header verified. Test case PASS");
		  }else
		  {
			  System.out.println(orgName + " is not created. Test case FAIL");
		  }
		  
		  //Step 8: Log out
		  hp.logout(driver);
		  /*
			 * WebElement ele1 =
			 * driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			 * wLib.mouseMoveOnElement(driver, ele1);
			 * driver.findElement(By.linkText("Sign Out")).click();
			 */
		  //driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		
		  driver.quit();
}

}
