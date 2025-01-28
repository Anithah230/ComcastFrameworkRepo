package com.comcast.crm.orgtest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateOrganizationwithPhoneNumber {
	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("./configAppData/commondata.properties.txt");
		Properties pobj = new Properties();
		pobj.load(fis);
		 String BROWSER=pobj.getProperty("browser");
		String URL=pobj.getProperty("url");
		String USERNAME=pobj.getProperty("username");
		String PASSWORD=pobj.getProperty("password");
		
		Random random=new Random();
		int randomInt = random.nextInt();
		
		FileInputStream fis1=new FileInputStream("./testdata/GenericUtility - CreateContactWithSupportDateTest.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("org");
		 Row r = sh.getRow(7);
		 String orgName = r.getCell(2).toString()+randomInt;
		 String phoneNumber = r.getCell(3).getStringCellValue();
		  wb.close();
		 
		 
		 WebDriver driver=null;
		 if(BROWSER.equals("chrome")) {
			 driver=new ChromeDriver();
		 }
		 else if(BROWSER.equals("firfox")) {
		 driver=new FirefoxDriver();
		 }
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.get(URL);
			driver.findElement(By.name("user_name")).sendKeys("admin");
			driver.findElement(By.name("user_password")).sendKeys("admin");
			driver.findElement(By.id("submitButton")).click();
			driver.findElement(By.linkText("organizations")).click();
			driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
			driver.findElement(By.name("accountname")).sendKeys("orgName");
			driver.findElement(By.name("phone")).sendKeys("phoneNumber");
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]')")).click();
//			
//			Actions act=new Actions(driver);
//			act.moveToElement(driver.findElement(By.xpath("//img[@src=\'themes/softed/images/user.PNG']"))).perform();
//			driver.findElement(By.linkText("Sign Out")).click();
//			driver.close();
			
			
			String actPhoneNumber=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			if(actPhoneNumber.contains(phoneNumber)) {
				System.out.println(phoneNumber + "is created==PASS");
			}
			else {
				System.out.println(phoneNumber + "is not created==FAIL");
			}
			
			
	}

}
