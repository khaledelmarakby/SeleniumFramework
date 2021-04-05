package steps;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.UserRegistrationPage;
import tests.TestBase;

public class UserRegistration extends TestBase{
	
	HomePage home;
	UserRegistrationPage regObj;
	
	@Given("the user in the home page")
	public void the_user_in_the_home_page() {
	    
	}
	@When("I click on the register link")
	public void i_click_on_the_register_link() {
	   home=new HomePage(driver);
	   home.openRegistrationPage();
	}

	/*
	 * @When("I entered the user data") public void i_entered_the_user_data() {
	 * regObj=new UserRegistrationPage(driver);
	 * regObj.userResgistration("khaled", "ahmed", "test@test.com" ,"12345678" ); }
	 */
	
	@When("I enter {string} , {string} , {string} , {string}")
	public void i_enter(String firstname, String lastname, String email, String password) {
		regObj=new UserRegistrationPage(driver);
		regObj.userResgistration(firstname,lastname,email,password );
	}
	
	@Then("The registration page is displayed successfully")
	public void the_registration_page_is_displayed_successfully() {
		Assert.assertEquals("Your registration completed", regObj.successMessage.getText());
		regObj.userLogout();
	}

}
