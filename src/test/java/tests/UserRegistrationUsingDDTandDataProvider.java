package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationUsingDDTandDataProvider  extends TestBase{
	
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	
	
	@DataProvider(name = "testData")
	
	public static  Object[][] userData()
	{
		return new  Object[][] {
			{
				"Khaled","Hamdy","testxxxy12@y.com","1234567"
			},
			{
				"Ahmed","Mohamed","testxxex21@yy.com","12345678"
			}
			};
	}
	
	
	@Test (priority = 1,dataProvider = "testData")
	public void UserCanRegisterSuccessfully(String fname, String lname, String email, String password)
	{
		homeObject=new HomePage(driver);
		registerObject=new UserRegistrationPage(driver);
		
		homeObject.openRegistrationPage();
		registerObject.userResgistration(fname,lname,email,password);
		Assert.assertEquals("Your registration completed", registerObject.successMessage.getText());
		registerObject.userLogout();
		loginObject=new LoginPage(driver);
		homeObject.openLoginPage();
		loginObject.Login(email, password);
		Assert.assertEquals("Log out", registerObject.logoutlink.getText());
		registerObject.userLogout();
	}
	
	
	

}
