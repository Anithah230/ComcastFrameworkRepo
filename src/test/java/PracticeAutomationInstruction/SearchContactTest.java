package PracticeAutomationInstruction;
/**
 * test class for Contact module
 * @author anith
 */

import org.testng.annotations.Test;

import com.comcast.com.objectrepsirtory.loginpage;
import com.comcast.crm.baseclass.BaseClass;

public class SearchContactTest extends BaseClass {
	/**
	 *  scenario:login()===>navigatecontact==>Createcontact()==verify
	 */
		
	@Test
	public void searchcontactTest() {
		/* step1: login to app*/
		loginpage lp=new loginpage(driver);
		lp.logintoapp("url", "username", "password");
		

	
		
	}

}
