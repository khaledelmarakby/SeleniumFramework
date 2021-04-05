package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import data.loadProperties;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationWithDDTandPropertiesFile extends TestBase {
	
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	
	String fn=loadProperties.Userdata.getProperty("firstname");
	String ln=loadProperties.Userdata.getProperty("lastname");
	String email=loadProperties.Userdata.getProperty("email");
	String password=loadProperties.Userdata.getProperty("password");
	
	@Test (priority = 1)
	public void UserCanRegisterSuccessfully()
	{
		homeObject=new HomePage(driver);
		registerObject=new UserRegistrationPage(driver);
		
		homeObject.openRegistrationPage();
		registerObject.userResgistration(fn,ln,email,password);
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
		loginObject.Login(email, password);
		Assert.assertEquals("Log out", registerObject.logoutlink.getText());
	
	
	}
	

}
