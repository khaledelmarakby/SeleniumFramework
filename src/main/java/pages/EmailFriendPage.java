package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailFriendPage extends PageBase {

	public EmailFriendPage(WebDriver driver) {
		super(driver);
		
	}

	@FindBy(id = "FriendEmail")
	WebElement friendemailtxtbox;
	
	@FindBy(id = "PersonalMessage")
	WebElement personalmessagetxtbox;
	
	@FindBy(css = "button.button-1.send-email-a-friend-button")
	WebElement sendEmailbtn;
	
	@FindBy(css = "div.result")
	public WebElement successMessage;
	
	public void Emailafriend(String friendemail,String personalmessage)
	{
		sendkeys(friendemailtxtbox, friendemail);
		sendkeys(personalmessagetxtbox, personalmessage);
		clickbutton(sendEmailbtn);
	}
	

}
