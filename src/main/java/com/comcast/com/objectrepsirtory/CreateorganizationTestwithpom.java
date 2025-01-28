package com.comcast.com.objectrepsirtory;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.comcast.com.genericwebdriverutility.JavaUtility;
import com.comcast.com.genericwebdriverutility.WebDriverUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;

public class CreateorganizationTestwithpom {
	
		public static void main(String[] args) throws Throwable {
			
			 
		 FileUtility fu = new FileUtility();
		 ExcelUtility eu = new ExcelUtility();
		 JavaUtility jlib=new JavaUtility();
		 WebDriverUtility wu = new WebDriverUtility();
		
		//read common data from property file
		String BROWSER=fu.getDataFromPropertiesFile("browser");
		String URL=fu.getDataFromPropertiesFile("url");
		String UNAME=fu.getDataFromPropertiesFile("username");
		String PASSWORD=fu.getDataFromPropertiesFile("password");
		
		//generate random number
//		Random r=new Random();
//		int randomInt=r.nextInt(1000);
		
	   
		//read testscript data from excel
		 String lastname=eu.getdatafromexcel("Sheet1",1,2)+jlib.getrandomnumber();
		 
		 WebDriver driver=null;
			if(BROWSER.equals("chrome"))
			{
			driver=new  ChromeDriver();
			}
			
			else if(BROWSER.equals("edge")) {
				
					driver=new EdgeDriver();
				}
		
			
			//step1
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.get(URL);
			
			//step2
			
			loginpage lp =new loginpage(driver);
			
			lp.logintoapp(URL,UNAME, PASSWORD);
			//step 3
			 homePage hp = new homePage(driver);
			hp.getOrglink().click();
			
			
			
			//step 4
			organizationspage op=new organizationspage(driver);
			op.getCreateneworgbtn().click();
			
			
			//step5:
			createneworganizationpage cnop=new createneworganizationpage(driver);
			cnop.createorgg(lastname);
			
			organizationinfopage oip=new organizationinfopage(driver);
			String actorgname=oip.getHeadermsg().getText();
			
			if(actorgname.contains(lastname))
			{
			System.out.println(lastname+"is verified===PASS");
			}
			else
			{
				System.out.println(lastname+"is not verified===FAIL");
			}
			
			hp.logout(driver);
			
			
			driver.quit();
		}
	}
	

