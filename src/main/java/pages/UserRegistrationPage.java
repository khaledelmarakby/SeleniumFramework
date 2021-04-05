package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegistrationPage extends PageBase {

	public UserRegistrationPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(id = "gender-male")
	WebElement genderRdoBtn;
	
	@FindBy(id = "FirstName")
	WebElement firstNametxtBox;
	
	@FindBy(id = "LastName")
	WebElement lastNametxtBox;
	
	@FindBy(id = "Email")
	WebElement emailtxtBox;
	
	@FindBy(id = "Password")
	WebElement passwordtxtBox;
	
	@FindBy(id = "ConfirmPassword")
	WebElement confirmpasswordtxtBox;
	
	@FindBy(id = "register-button")
	WebElement registerbtn;
	
	@FindBy(css = "div.result")
	 public WebElement successMessage;
	
	@FindBy(css = "a.ico-logout")
	public WebElement logoutlink;
	
	@FindBy(linkText = "My account")
	WebElement myAccountbtn;
	
	
	
	public void userResgistration(String firstName , String lastName , String email , String password)
	{
		clickbutton(genderRdoBtn);
		sendkeys(firstNametxtBox, firstName);
		sendkeys(lastNametxtBox, lastName);
		sendkeys(emailtxtBox, email);
		sendkeys(passwordtxtBox,password);
		sendkeys(confirmpasswordtxtBox, password);
		clickbutton(registerbtn);
	}
	
	public void userLogout()
	{
		clickbutton(logoutlink);
	}

	public void openMyAccountPage()
	{
		clickbutton(myAccountbtn);
	}
}
