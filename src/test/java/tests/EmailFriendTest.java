package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.EmailFriendPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.UserRegistrationPage;

public class EmailFriendTest extends TestBase {

	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	String productname="mac";
	SearchPage searchObj;
	ProductDetailsPage productobj;
	EmailFriendPage emailObj;

	@Test (priority = 1)
	public void UserCanRegisterSuccessfully()
	{
		homeObject=new HomePage(driver);
		registerObject=new UserRegistrationPage(driver);

		homeObject.openRegistrationPage();
		registerObject.userResgistration("mohamed", "ahmed", "test1500@gmail.com", "123456");
		Assert.assertEquals("Your registration completed", registerObject.successMessage.getText());
	}

	@Test(dependsOnMethods = ("UserCanRegisterSuccessfully"))

	public void userCanSearchUsingAutoComplete() throws InterruptedException
	{
		searchObj=new SearchPage(driver);
		productobj=new ProductDetailsPage(driver);
		searchObj.ProductSearchUsingAutoComplete(productname);
		Assert.assertTrue(productobj.productNameBreadCrumb.getText().contains("Apple MacBook Pro 13-inch"));
	}
	
	@Test(dependsOnMethods = ("userCanSearchUsingAutoComplete"))
	
	public void UserCanSendEmailToHisFriend()
	{
		productobj=new ProductDetailsPage(driver);
		productobj.openEmailtoFriendPage();
		emailObj=new EmailFriendPage(driver);
		emailObj.Emailafriend("friend@123.com", "I think this product matches the one you're searching for");
		Assert.assertEquals("Your message has been sent.", emailObj.successMessage.getText());
	}


	@Test(dependsOnMethods = ("UserCanSendEmailToHisFriend"))

	public void RegisteredUserCanLogout()
	{
		registerObject.userLogout();
	}

}
