package Assignments;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.baseclass.BaseClass;

//@Listeners(com.comcast.crm.Listenerutility.Listener.class)

public class InvoiceTest extends BaseClass{
	@Test
	public void  createinvoiceTest() {
		System.out.println("execute createInvoiceTest");
		System.out.println("step-1");
		System.out.println("step-2");
		String actTitle=driver.getTitle();
		Assert.assertEquals(actTitle, "Login");
		System.out.println("step-3");
		System.out.println("step-4");
		
		
		
	}
	
	@Test
	public void  createinvoicewithcontactTest() {
		System.out.println("execute createinvoicewithcontactTest");
		System.out.println("step-1");
		System.out.println("step-2");
	   System.out.println("step-3");
		System.out.println("step-4");
		
		
	}

}
