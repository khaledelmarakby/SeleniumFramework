package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTest extends TestBase{
	
	HomePage homeObj;
	ContactUsPage contactObj;
	
	@Test
	
	public void UserCanContactTheWebsite()
	{
		homeObj=new HomePage(driver);
		contactObj=new ContactUsPage(driver);
		homeObj.openContactUsPage();
		contactObj.contactus("dsaddas", "test@123.com", "sadasdasd");
		Assert.assertEquals("Your enquiry has been successfully sent to the store owner.", contactObj.successMessage.getText());
		
	}
	

}
