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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Createorgwithindustry {
	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("./configAppData/commondata.properties.txt");
		Properties pobj = new Properties();
		pobj.load(fis);
		 String BROWSER=pobj.getProperty("browser");
		String URL=pobj.getProperty("url");
		String USERNAME=pobj.getProperty("username");
		String PASSWORD=pobj.getProperty("password");
		
		Random random=new Random();
		int randomInt = random.nextInt(1000);
		
		FileInputStream fis1=new FileInputStream("./testdata/GenericUtility.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("org");
		 Row r = sh.getRow(4);
		 String orgName = r.getCell(2).toString()+randomInt;
		 String industry = r.getCell(3).toString();
		 String type = r.getCell(4).toString();
		 wb.close();
		 WebDriver driver=null;
		 if(BROWSER.equals("chrome")) {
			 driver=new ChromeDriver();
		 }
		 else if(BROWSER.equals("firfox")) {
		 driver=new FirefoxDriver();
		 }
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.get("http://49.249.28.218:8888/index.php?action=Login&module=Users");
			driver.findElement(By.name("user_name")).sendKeys("admin");
			driver.findElement(By.name("user_password")).sendKeys("admin");
			driver.findElement(By.id("submitButton")).click();
			driver.findElement(By.linkText("organizations")).click();
			driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
			driver.findElement(By.name("accountname")).sendKeys("orgName");	
			WebElement wbsele1 = driver.findElement(By.name("industry"));
			Select sell1=new Select(wbsele1);
			sell1.selectByVisibleText(industry);
			WebElement wbsele2 = driver.findElement(By.name("accounttype"));
			Select sell2=new Select(wbsele2);
		//sell2.selectByContainsVisibleText(type);
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]')")).click();
			
			//verify industries and type info
			String actIndustries=driver.findElement(By.id("dtlview_Industry")).getText();
			if(actIndustries.equals(industry)) {
				System.out.println(industry + "is verified==PASS");
			}
			else {
				System.out.println(industry + "is not verified==FAIL");
			}
			
//			String actType=driver.findElement((By.id("dtlview_Type")).getText
//			if(actType.equals(type)) {
//				System.out.println(type+ "information is not verified==PASS");
//			}
//			else {
//				System.out.println(type+ "information is not verified==FAIL");
//			}
//			
}
}