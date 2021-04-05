package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase{

	public LoginPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(id = "Email")
	WebElement EmailTxtBox;
	
	@FindBy(id = "Password")
	WebElement passwordTxtBox;
	
	@FindBy(css = "button.button-1.login-button")
	WebElement Loginbtn;
	
	public void Login(String email, String password)
	{
		sendkeys(EmailTxtBox, email);
		sendkeys(passwordTxtBox, password);
		clickbutton(Loginbtn);
	}

}
