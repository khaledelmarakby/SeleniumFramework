package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase {

	public MyAccountPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(linkText = "Change password")
	WebElement ChangePasswordLink;
	
	public void OpenChangePasswordPage()
	{
		clickbutton(ChangePasswordLink);
	}

	@FindBy(id = "OldPassword")
	WebElement oldPasswordtxtbox;
	
	@FindBy(id = "NewPassword")
	WebElement newPasswordtxtbox;
	
	@FindBy(id="ConfirmNewPassword")
	WebElement confirmNewPasswordtxtbox;
	
	@FindBy(css  = "button.button-1.change-password-button")
	WebElement ChangePasswordbtn;
	
	@FindBy(css = "p.content")
	public WebElement successMessage;
	
	@FindBy(css = "span.close")
	public WebElement NotificationAlert;
	
	public void ChangePasswordPage(String oldpassword, String newpassword,String confirmnewpassword)
	{
		sendkeys(oldPasswordtxtbox, oldpassword);
		sendkeys(newPasswordtxtbox, newpassword);
		sendkeys(confirmNewPasswordtxtbox, confirmnewpassword);
		clickbutton(ChangePasswordbtn);
	}
	
	public void CloseNotification()
	{
		clickbutton(NotificationAlert);
	}
}
