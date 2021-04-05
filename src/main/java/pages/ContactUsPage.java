package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBase{

	public ContactUsPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(id="FullName")
	WebElement fullnametxtbox;
	
	@FindBy(id="Email")
	WebElement emailtxtbox;
	
	@FindBy(id="Enquiry")
	WebElement enquirytxtbox;
	
	@FindBy(css = "button.button-1.contact-us-button")
	WebElement submittbtn;
	
	@FindBy(css = "div.result")
	public WebElement successMessage;
	
	public void contactus(String fullname, String email, String enquiry)
	{
		sendkeys(fullnametxtbox, fullname);
		sendkeys(emailtxtbox, email);
		sendkeys(enquirytxtbox, enquiry);
		clickbutton(submittbtn);
	}

}
