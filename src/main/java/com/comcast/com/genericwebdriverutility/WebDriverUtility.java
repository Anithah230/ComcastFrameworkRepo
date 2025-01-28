package com.comcast.com.genericwebdriverutility;

import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File;
import com.mysql.jdbc.Driver;


	//All WebDriver utility methods



	//Implicit wait

	public class WebDriverUtility {

		public void waitForPageToLoad(WebDriver driver ) {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		}
		
		
		
	//Explicit wait #1	
		public void waitForElementPresent (WebDriver driver, WebElement element) {
			WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOf(element));
		}
		
//	//Explicit wait #2	
//		public void waitForAllElementsPresent (WebDriver driver, List<WebElement> elements) {
//			WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
//			wait.until(ExpectedConditions.visibilityOfAllElements(elements));
//		}
		
	//Explicit wait #3
		public void waitForURLToBe (WebDriver driver,String element) {
			WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.urlToBe(element));
		}
		
	//Explicit wait #4
		public void waitForUrlContains (WebDriver driver,String str) {
			WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.urlContains(str));
		}
		
	//Explicit wait #5
		public void waitForTitleContains (WebDriver driver,String title) {
			WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.titleContains(title));
		}
		
	//Explicit wait #6
		public void waitForTextToBePresentInElement (WebDriver driver, WebElement element,String text) {
			WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.textToBePresentInElement(element, text));
		}
		
	//Explicit wait #7
		public void waitForElementClickable (WebDriver driver, WebElement element) {
			WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.elementToBeClickable(element));
		}
		
	//Explicit wait #8
		public void waitForFrameToBeAvailableSwitchToIndex (WebDriver driver, int index) {
			WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(index));
		}
		
		//Maximize
		public void maximizeWindow(WebDriver driver) {
			driver.manage().window().maximize();
		}
		
		//Minimize
		public void minimizeWindow(WebDriver driver) {
			driver.manage().window().minimize();
		}
		
		//Dropdown #1
		public void selectVisibleText(WebElement element, String text) {
			Select sel=new Select(element);
			sel.selectByVisibleText(text);
		}
		
		//Dropdown #2
		public void selectIndex(WebElement element, int index) {
			Select sel=new Select(element);
			sel.selectByIndex(index);
		}
		
		//Dropdown #3
		public void selectValue(WebElement element, String data) {
			Select sel=new Select(element);
			sel.selectByValue(data);
		}
		
		
		//Actions - click on element
		public void clickOnElement (WebDriver driver, WebElement element) {
			Actions act=new Actions(driver);
			act.click(element).perform();
		}
		
		//Actions - scroll down
		public void scrollToElement (WebDriver driver, WebElement element) {
			Actions act=new Actions(driver);
			act.scrollToElement(element).perform();
		}
		
		//Actions - scroll until element visible & click
		public void scrollToElementVisibleClick (WebDriver driver, WebElement element) {
			Actions act=new Actions(driver);
			act.moveToElement(element).click().perform();
		}
		
		//Actions - right click
		public void rightClick (WebDriver driver, WebElement element) {
			Actions act=new Actions(driver);
			act.contextClick(element).perform();
		}
		
		//Actions - double click
		public void doubleClick (WebDriver driver, WebElement element) {
			Actions act=new Actions(driver);
			act.doubleClick(element).perform();
		}
		
		//Actions - send keys
		public void sendKeys (WebDriver driver, WebElement element, String key) {
			Actions act=new Actions(driver);
			act.sendKeys(element, key).perform();
		}
		
		//Actions - mouse hover over element
		public void mouseMoveOnElement (WebDriver driver, WebElement element) {
			Actions act=new Actions(driver);
			act.moveToElement(element).perform();
		}
		
		//Frames - parent to child
		public void switchToFrame (WebDriver driver, int index) {
			driver.switchTo().frame(index);
		}
		
		public void switchToFrame (WebDriver driver, String nameID) {
			driver.switchTo().frame(nameID);
		}
		
		public void switchToFrame (WebDriver driver, WebElement element) {
			driver.switchTo().frame(element);
		}
		
		//Frames - child to parent
		public void switchToParentFrame (WebDriver driver) {
			driver.switchTo().parentFrame();
		}
		
		//Frames - child to main frame
		public void switchToMainFrame (WebDriver driver) {
			driver.switchTo().defaultContent();
		}

		//Switch between windows
		public void switchToTabOnURL (WebDriver driver, String partialURL) {
			Set<String> allWh = driver.getWindowHandles();
			  Iterator<String> it = allWh.iterator();
			  
			  while(it.hasNext())
			  {
				  String windowId=it.next();
				  driver.switchTo().window(windowId);
				  String actUrl = driver.getCurrentUrl(); //Example for where we used current url in Seleneium
				  if(actUrl.contains(partialURL))
				  {
					  break;
				  }
			  }
		}
		
		//Switch between windows
		public void switchToTabOnTitle (WebDriver driver, String partialTitle) {
			Set<String> allWh = driver.getWindowHandles();
			  Iterator<String> it = allWh.iterator();
			  
			  while(it.hasNext())
			  {
				  String windowId=it.next();
				  driver.switchTo().window(windowId);
				  String actUrl = driver.getTitle();
				  if(actUrl.contains(partialTitle))
				  {
					  break;
				  }
			  }
		}
		
		//Alert popup method #1
		public void swithchToAlertAndAccept (WebDriver driver) {
			driver.switchTo().alert().accept();
		}
		
		//Alert popup method #2
		public void switchToAlertAndCancel (WebDriver driver) {
			driver.switchTo().alert().dismiss();
		}
		
		//Alert popup method #3
		public void switchToAlertAndGetText (WebDriver driver) {
			driver.switchTo().alert().getText();
		}
		
		//Alert popup method #4
		public void switchToAlertAndSendKeys (WebDriver driver, String text) {
			driver.switchTo().alert().sendKeys(text);;
		}
		
		//Scroll using Javascript Executor
		public void scrollToSpecificLocation(WebDriver driver, WebElement ele) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		Point l = ele.getLocation();
		int x = l.getX();
		int y = l.getY();
		js.executeScript("window.scrollBy("+x+","+y+")");
		}
		
//		//TakeScreenshot
//		public void takeScreenshot(WebDriver driver) throws IOException {
//		String photo="./photos/";
//		Date d=new Date();
//		String d1=d.toString();
//		String d2=d1.replaceAll(":", "-");
//		TakesScreenshot ts=(TakesScreenshot) driver;
//           File src = ts.getScreenshotAs(OutputType.FILE);
////		File dst=new File(photo+d2+".jpeg");
//		FileHandler.copy(src, dst);
	
		}
	


