package com.comcast.crm.Listenerutility;



import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.com.genericwebdriverutility.UtilityClassObject;
import com.comcast.crm.baseclass.BaseClass;

public class Listener implements ITestListener, ISuiteListener {
	
	public static ExtentReports report;
	public static ExtentTest test;
	
		@Override
		public void onStart(ISuite suite) {
			// TODO Auto-generated method stub
			System.out.println("Report configuration");
//			String time=new Date().toString().replace(" ","_").replace(":","_");
			
			
			//Spark Report config
//			ExtentSparkReporter spark=new ExtentSparkReporter("./AdvanceReport/report_"+time+".html");
			ExtentSparkReporter spark=new ExtentSparkReporter("./AdvanceReport1/report.html");
			spark.config().setDocumentTitle("CRM Test Suite Results");
			spark.config().setReportName("CRM Report");
			spark.config().setTheme(Theme.DARK);
			
			//add environment & create test
			report=new ExtentReports();
		    report.attachReporter(spark);
			report.setSystemInfo("OS", "Windows-10");
			report.setSystemInfo("BROWSER", "CHROME-100");
			
		}
	
		@Override
		public void onFinish(ISuite suite) {
			// TODO Auto-generated method stub
			System.out.println("Report backup");
			report.flush();
			
			
		}

		@Override
		public void onTestStart(ITestResult result) {
			// TODO Auto-generated method stub
			System.out.println("==============="+result.getMethod().getMethodName()+"=====START=====");
			 test = report.createTest(result.getMethod().getMethodName());
			 UtilityClassObject.setTest(test);
			 test.log(Status.INFO, result.getMethod().getMethodName()+"===>STARTED<==");
		}

		@Override
		public void onTestSuccess(ITestResult result) {
			// TODO Auto-generated method stub
			System.out.println("==============="+result.getMethod().getMethodName()+"=====END=====");
			 test.log(Status.PASS, result.getMethod().getMethodName()+"===>COMPLETED<==");
		}
		

		@Override
		public void onTestFailure(ITestResult result) {
			// TODO Auto-generated method stub
			String testname=result.getMethod().getMethodName();		
		
//			TakesScreenshot tss=(TakesScreenshot)BaseClass.sdriver;
//			File srcfile=tss.getScreenshotAs(OutputType.FILE);
//			String time=new Date().toString().replace(" ","_").replace(":","");
//			try {
//				FileUtils.copyFile(srcfile, new File("./Screenshot/"+testname+".png"));
//			}
//			catch(IOException e)
//			{
//				e.printStackTrace();
//			}
			
			 TakesScreenshot ts = (TakesScreenshot)BaseClass.sdriver;
			 String filepath = ts.getScreenshotAs(OutputType.BASE64);
			
			String time=new Date().toString().replace(" ","_").replace(":","");
			test.addScreenCaptureFromBase64String(filepath, testname+"_"+time);
			
			 test.log(Status.FAIL, result.getMethod().getMethodName()+"===>FAILED<==");
		
				
//			File srcfile=edriver.(OutputType.FILE);
//			String time=new Date().toString().replace(" ","").replace("s","");
			
		}

		@Override
		public void onTestSkipped(ITestResult result) {
			// TODO Auto-generated method stub
//			test.log(Status.SKIP, result.getMethod().getMethodName()+"===>SKIPPED<==");
			
		}

		@Override
		public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onTestFailedWithTimeout(ITestResult result) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onStart(ITestContext context) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFinish(ITestContext context) {
			// TODO Auto-generated method stub
			
		}
}
