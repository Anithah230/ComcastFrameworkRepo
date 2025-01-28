package com.comcast.crm.Listenerutility;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Activatesim {
	@Test(retryAnalyzer =  com.comcast.crm.Listenerutility.RetryListener.class)
	public void  createinvoiceTest() {
		System.out.println("execute createInvoiceTest");
		System.out.println("step-1");
		System.out.println("step-2");
		Assert.assertEquals("", "Login");
		System.out.println("step-3");
		System.out.println("step-4");
		
	}	

}
