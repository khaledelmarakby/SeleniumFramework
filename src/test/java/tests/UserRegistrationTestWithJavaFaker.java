package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTestWithJavaFaker extends TestBase {
	
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	
	Faker fakeData =new Faker();
	String firstname=fakeData.name().firstName();
	String lastname=fakeData.name().lastName();
	String email=fakeData.internet().emailAddress();
	String password=fakeData.internet().password();
	
	@Test (priority = 1)
	public void UserCanRegisterSuccessfully()
	{
		homeObject=new HomePage(driver);
		registerObject=new UserRegistrationPage(driver);
		
		homeObject.openRegistrationPage();
		registerObject.userResgistration(firstname,lastname,email,password);
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
		loginObject.Login(email,password);
		Assert.assertEquals("Log out", registerObject.logoutlink.getText());
	
	
	}
	

}
