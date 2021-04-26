package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegistrationPage;

public class MyAccountParallelTesting extends TestBase2{
	
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	MyAccountPage accountobject;
	String email="test14233@gmail.com";
	String oldpassword="123456";
	String newpassword="12345678";

	@Test (priority = 1)
	public void UserCanRegisterSuccessfully()
	{
		homeObject=new HomePage(getdriver());
		registerObject=new UserRegistrationPage(getdriver());

		homeObject.openRegistrationPage();
		registerObject.userResgistration("mohamed", "ahmed", email, oldpassword);
		Assert.assertEquals("Your registration completed", registerObject.successMessage.getText());
	}

	@Test(dependsOnMethods = "UserCanRegisterSuccessfully" )

	public void UserCanChangeHisPassword()
	{
		registerObject=new UserRegistrationPage(getdriver());
		accountobject= new MyAccountPage(getdriver());

		registerObject.openMyAccountPage();
		accountobject.OpenChangePasswordPage();
		accountobject.ChangePasswordPage(oldpassword, newpassword, newpassword);
		Assert.assertEquals("Password was changed", accountobject.successMessage.getText());
		accountobject.CloseNotification();

	}

	@Test(dependsOnMethods = ("UserCanChangeHisPassword"))

	public void RegisteredUserCanLogout()
	{
		
		registerObject.userLogout();
	}


	@Test(dependsOnMethods = ("RegisteredUserCanLogout"))

	public void RegisteredUserCanLogin()
	{
		loginObject=new LoginPage(getdriver());
		homeObject.openLoginPage();
		loginObject.Login(email, newpassword);
		Assert.assertEquals("Log out", registerObject.logoutlink.getText());


	}

}
