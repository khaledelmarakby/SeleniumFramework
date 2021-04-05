package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcelReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;


public class UserRegistrationTestWithDDTandExcel extends TestBase {
	
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	
	
	@DataProvider(name="ExcelData")
	
	public Object[][] userRegisterdata() throws IOException
	{
		ExcelReader data=new ExcelReader();
		return data.getExcelData();
	}
	
	
	
	@Test (priority = 1,dataProvider = "ExcelData")
	public void UserCanRegisterSuccessfully(String fn,String ls,String email,String password)
	{
		homeObject=new HomePage(driver);
		registerObject=new UserRegistrationPage(driver);
		
		homeObject.openRegistrationPage();
		registerObject.userResgistration(fn,ls,email,password);
		Assert.assertEquals("Your registration completed", registerObject.successMessage.getText());
		registerObject.userLogout();
		loginObject=new LoginPage(driver);
		homeObject.openLoginPage();
		loginObject.Login(email,password);
		Assert.assertEquals("Log out", registerObject.logoutlink.getText());
		registerObject.userLogout();
	}
	
	
	

}
