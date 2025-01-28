package POM.Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.com.genericwebdriverutility.JavaUtility;
import com.comcast.com.genericwebdriverutility.WebDriverUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;

public class CreateOrgPhoneNumberTest {
	public static void main(String[] args) throws Exception {
		//Create object
				FileUtility fLib=new FileUtility();
				ExcelUtility eLib=new ExcelUtility();
				JavaUtility jLib=new JavaUtility();
				WebDriverUtility wLib=new WebDriverUtility();
				
		WebDriver driver = null;
		  //Read data from properties file using file utility classes
		  String URL = fLib.getDataFromPropertiesFile("baseurl");
		  String BROWSER = fLib.getDataFromPropertiesFile("browser");
		  String UN = fLib.getDataFromPropertiesFile("username");
		  String PWD = fLib.getDataFromPropertiesFile("password");
		  
		  //Read test script data from Excel
		  String orgName = eLib.getdatafromexcel("Org", 7, 2) + jLib.getrandomnumber();
		  String phoneNumber = eLib.getdatafromexcel("Org", 7, 3).toString();
		  
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
		  
		  wLib.maximizeWindow(driver);
		  wLib.waitForPageToLoad(driver);
		  LoginPage lp=new LoginPage(driver);
		  lp.logintoapp(UN, PWD);
		  
		  //Step 2: Navigate to the Org module
		  HomePage hp=new HomePage(driver);
		  hp.getOrglink().click();
		  //driver.findElement(By.xpath("//a[.='Organizations']")).click();
		  
		  //Step 3: Click on the Create Org button
		  OrganizationsPage op=new OrganizationsPage(driver);
		  op.getCreateneworgbtn().click();
		  //driver.findElement(By.xpath("//img[@title='Create Organization...\']")).click();
		  
		  //Step 4: Enter the org name and the phone number, and create new Org
		  createneworganizationPage cOP=new createneworganizationPage(driver);
		  cOP.getOrgnameedit().sendKeys(orgName);
		  //driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgName);
		  cOP.getPhonenumber().sendKeys(phoneNumber);
		  //driver.findElement(By.id("phone")).sendKeys(phoneNumber);
		  
		  cOP.getSavebtn().click();
		  //driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		  
		  //Verify the phone number
		  OrganizationInfoPage oIP=new OrganizationInfoPage(driver);
		  String actPhoneNumber = oIP.getPhoneInfo().getText();
		  //String actPhoneNumber = driver.findElement(By.xpath("//span[@id='dtlview_Phone\']")).getText();
		  System.out.println(actPhoneNumber);
		  if(actPhoneNumber.equals(phoneNumber)) {
			  System.out.println(phoneNumber + " is verified. Test PASS");
		  }else
		  {
			  System.out.println(phoneNumber + " is not verified. Test FAIL");
		  }
		  
		  //Step 5: Log out
//		  hp.logout(driver);
		  
		  /*
			 * WebElement
			 * ele=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"
			 * )); wLib.mouseMoveOnElement(driver, ele);
			 * driver.findElement(By.linkText("Sign Out")).click();
			 */
		  //driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		
		  driver.quit();
	}
}
