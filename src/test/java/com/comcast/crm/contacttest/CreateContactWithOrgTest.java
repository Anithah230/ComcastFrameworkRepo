package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateContactWithOrgTest {
	public static void main(String[] args) throws IOException {
		WebDriver driver = null;
		FileInputStream fis = new FileInputStream("./configAppData/commondata.properties.txt");
		Properties pobj = new Properties();
		pobj.load(fis);
		String BROWSER = pobj.getProperty("browser");
		String URL = pobj.getProperty("url");
		String USERNAME = pobj.getProperty("username");
		String PASSWORD = pobj.getProperty("password");

		Random random = new Random();
		int randomInt = random.nextInt();

		FileInputStream fis1 = new FileInputStream("./src/test/resources/GenericUtility_CreateContactWithOrgTest.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("org");
		Row r = sh.getRow(7);
		String orgName = r.getCell(2).toString() + randomInt;
		String contactLastName = r.getCell(3).getStringCellValue();
		wb.close();

		
		if (BROWSER.contains("chrome")) 
			driver = new ChromeDriver();
		else if (BROWSER.contains("firefox")) 
			driver = new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys("orgName");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]')")).click();

		String headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (headerInfo.contains(orgName)) {
			System.out.println(orgName + "is created==PASS");
		} else {
			System.out.println(orgName + "is not created==FAIL");

		}
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.linkText("lastname")).click();
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();

		// switch to child window
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String windowID = it.next();
			driver.switchTo().window(windowID);
			String acturl = driver.getCurrentUrl();
			if (acturl.contains("modules=Accounts")) {
				break;
			}

		}
		driver.findElement(By.name("search_text")).sendKeys(orgName);
		driver.findElement(By.name("search")).sendKeys("admin");
		driver.findElement(By.xpath("//a[text()='" + orgName + "']")).click();

		// switch to parent window
		Set<String> set1 = driver.getWindowHandles();
		Iterator<String> it1 = set.iterator();

		while (it1.hasNext()) {
			String windowID = it1.next();
			driver.switchTo().window(windowID);
			String acturl = driver.getCurrentUrl();
			if (acturl.contains("Contacts&action")) {
				break;
			}

		}
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]')")).click();
		headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (headerInfo.contains(contactLastName)) {
			System.out.println(contactLastName + "header verified==PASS");
		} else {
			System.out.println(contactLastName + "is header verified==FAIL");
		}

		String actorgName = driver.findElement(By.id("mouseArea_organization Name")).getText();
		if (actorgName.equals(orgName)) {
			System.out.println(orgName + "information is verified==PASS");
		} else {
			System.out.println(orgName + "information is not verified==FAIL");
		}

	}

}