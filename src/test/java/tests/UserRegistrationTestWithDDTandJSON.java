package tests;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import data.JSONDataReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTestWithDDTandJSON extends TestBase {
	
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	
	
	
	
	@Test (priority = 1)
	public void UserCanRegisterSuccessfully() throws IOException, ParseException
	{
		JSONDataReader datareader=new JSONDataReader();
		datareader.JsonReader();
		homeObject=new HomePage(driver);
		registerObject=new UserRegistrationPage(driver);
		
		homeObject.openRegistrationPage();
		registerObject.userResgistration(datareader.firstname,datareader.lastname,datareader.email
				,datareader.password);
		Assert.assertEquals("Your registration completed", registerObject.successMessage.getText());
		registerObject.userLogout();
		loginObject=new LoginPage(driver);
		homeObject.openLoginPage();
		loginObject.Login(datareader.email,datareader.password);
		Assert.assertEquals("Log out", registerObject.logoutlink.getText());
		registerObject.userLogout();
	}
	
	

}
