package com.comcast.com.objectrepsirtory;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.com.genericwebdriverutility.JavaUtility;
import com.comcast.com.genericwebdriverutility.WebDriverUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;


	public class createorg {
	public static void main(String[] args) throws Throwable {
			
			//Create object
					 FileUtility fLib = new FileUtility();
					 ExcelUtility eLib = new ExcelUtility();
				      JavaUtility jLib = new JavaUtility();
					 WebDriverUtility wLib = new WebDriverUtility();

			WebDriver driver = null;

			//Read data from properties file using file utility classes
			  String URL = fLib.getDataFromPropertiesFile("url");
			  String BROWSER = fLib.getDataFromPropertiesFile("browser");
			  String UNAME = fLib.getDataFromPropertiesFile("username");
			  String PASSWORD = fLib.getDataFromPropertiesFile("password");
			  
			  
			  //Read test script data from Excel
			  //String orgName = eLib.getdatafromexcel("Org", 1, 2) + jLib.getRandomNumber();
			 
				
			    //read testscript data from excel
				 String lastname=eLib.getdatafromexcel("Sheet2",1,2)+jLib.getrandomnumber();

			  if(BROWSER.equals("chrome"))
			  {
				  driver=new ChromeDriver();
			  }
			  else if(BROWSER.equals("firefox"))
			  {
				  driver=new FirefoxDriver();
			  }
			  else
			  {
				  driver=new ChromeDriver();
			  }
			  //Step 1: Login to the app
			  driver.get(URL);
			  
			  wLib.waitForPageToLoad(driver);

//			  wLib.maximizeWindow(driver);
//			  wLib.waitForPageToLoad(driver);
			  
				/* If we want to call individual element
				 * LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
				 * lp.getUsernameEdt().sendKeys("admin"); lp.getPasswordEdt().sendKeys("admin");
				 * lp.getLoginBtn().click();
				 */
			  
			  //If we want to directly call the action class - helps in optimizing the code
			  
			  loginpage lp=new loginpage(driver);
			  lp.logintoapp(URL, UNAME, PASSWORD);
			  
			  //Step 2: Navigate to the organization module
			   homePage hp = new homePage(driver);
			  hp.getOrglink().click();
			  
			  //Step 3: Click on the Create Organization button
			  organizationspage op=new organizationspage(driver);
			  op.getCreateneworgbtn().click();
			  
			  //Step 4: Enter all the details & create new organization
			  createneworganizationpage cnop=new createneworganizationpage(driver);
			  cnop.createorgg(lastname);
			  /* We prefer using business method in the above 2 lines instead of calling the elements like below
				 * cNP.getorgNameField().sendKeys(orgName); cNP.getsaveBtn().click();
				 */
			  
			  //Verify header msg expected result
			 // String headerinfo=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			  organizationinfopage oip= new organizationinfopage(driver);
			  //String headerInfo =driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			  String headerInfo= oip.getHeadermsg().getText();
			  if(headerInfo.contains(lastname)) {
				  System.out.println(lastname + "  is created and header verified. Test case PASS");
			  }else
			  {
				  System.out.println(lastname + " is not created. Test case FAIL");
			  }
			  
			  //Verify org name in the expected result
//			  organizationinfopage oip=new organizationinfopage(driver);
//			  String actOrgName = oip.getOrginfodata().getText();
//			  System.out.println(actOrgName);
//			  if(actOrgName.equals(lastname)) {
//				  System.out.println(lastname + " org name verified. Test case PASS");
//			  }else {
//				  System.out.println(lastname + " name not verified. Test case FAIL");
//			  }
//			  
//			  //Verify header info in the expected result
//			  String actHeaderInfo = oip.getHeadermsg().getText();
//			  System.out.println(actHeaderInfo);
//			  if(actHeaderInfo.equals(headerInfo)) {
//				  System.out.println(headerInfo + " org name verified. Test case PASS");
//			  }else {
//				  System.out.println(headerInfo + " name not verified. Test case FAIL");
//			  }
//			  
//			  //Step 5: Log out
//			  
		  hp.logout(driver); //Using business method/action class from the POM class-Homepage.java
//			  
//				/* Logging out using webdriver utility method
//				 * WebElement
//				 * ele=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"
//				 * )); wLib.mouseMoveOnElement(driver, ele);
//				 * 
//				 * driver.findElement(By.linkText("Sign Out")).click();
//				 */ //driver.findElement(By.xpath("//a[.='Sign Out']")).click();
//			
			  driver.quit();
	}
}
