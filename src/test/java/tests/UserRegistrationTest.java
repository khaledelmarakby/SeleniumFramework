package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTest extends TestBase {
	
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	
	@Test (priority = 1)
	public void UserCanRegisterSuccessfully()
	{
		homeObject=new HomePage(driver);
		registerObject=new UserRegistrationPage(driver);
		
		homeObject.openRegistrationPage();
		registerObject.userResgistration("mohamed", "ahmed", "test12@gmail.com", "123456");
		Assert.assertEquals("Your registration completed", registerObject.successMessage.getText());
	}
	
	@Test(dependsOnMethods = ("UserCanRegisterSuccessfully"))
	
	public void RegisteredUserCanLogout()
	{
		registerObject.userLogout();
	}
	
	
	@Test(dependsOnMethods = ("RegisteredUserCanLogout"))
	
	public void RegisteredUserCanLogin()
	{
		loginObject=new LoginPage(driver);
		homeObject.openLoginPage();
		loginObject.Login("test12@gmail.com", "123456");
		Assert.assertEquals("Log out", registerObject.logoutlink.getText());
	
	
	}
	

}
