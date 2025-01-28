package com.comcast.crm.orgtest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.com.genericwebdriverutility.JavaUtility;
import com.comcast.com.genericwebdriverutility.WebDriverUtility;
import com.comcast.com.objectrepsirtory.createneworganizationpage;
import com.comcast.com.objectrepsirtory.homePage;
import com.comcast.com.objectrepsirtory.loginpage;
import com.comcast.com.objectrepsirtory.organizationinfopage;
import com.comcast.com.objectrepsirtory.organizationspage;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;

public class DeleteOrgTest {
	
public static void main(String[] args) throws Throwable {
	 WebDriver driver=null;
	 
	 FileUtility fLib = new FileUtility();
	 ExcelUtility eLib = new ExcelUtility();
      JavaUtility jLib = new JavaUtility();
	 WebDriverUtility wLib = new WebDriverUtility();
	 
	//read common data from property file
	 String URL = fLib.getDataFromPropertiesFile("url");
	  String BROWSER = fLib.getDataFromPropertiesFile("browser");
	  String UNAME = fLib.getDataFromPropertiesFile("username");
	  String PASSWORD = fLib.getDataFromPropertiesFile("password");
	  
	//generate random number
//		Random random=new Random();
//		int randomInt = random.nextInt(1000);
	
    //read testscript data from excel
		String org = eLib.getdatafromexcel("Sheet2", 1, 2
				)+ jLib.getrandomnumber();
	 
	
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
		
		
		//step2
		
		loginpage lp =new loginpage(driver);
		
//		lp.logintoapp(UNAME, PASSWORD);
		//step 3
		 homePage hp = new homePage(driver);
		hp.getOrglink().click();
		
		organizationspage cnp=new organizationspage(driver);
		cnp.getCreateneworgbtn().click();
		
		createneworganizationpage cnop=new createneworganizationpage(driver);
		cnop.getorgnameedit().click();
		
		organizationinfopage oip=new organizationinfopage(driver);
		   String actorgname = oip.getHeadermsg().getText();
		   if(actorgname.contains(org )) {
			   System.out.println(org  +"name is verified ==pass");
		   }
		   
		   else {
			   System.out.println(org  +"name is verified ==fail");
		   }
		   
		   //go back to orgpage
		  hp.getOrglink().click();
		  
		  //search for organaization
		  cnp.getSearchedit().sendKeys(org);
		 wLib.selectVisibleText(cnp.getSearchDD(), "Organization Name");
		 cnp.getSearchnow().click();
		 
		 driver.findElement(By.xpath("//a[text()='"+org+"']/../..td[8]/a[text()='del']")).click();
			
			
				 
		   hp.logout(driver);
		   driver.quit();
		   
}

}
	


