package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends PageBase {

	public CheckoutPage(WebDriver driver) {
		super(driver);
		
		js=(JavascriptExecutor) driver;
	}

	@FindBy(css = "button.button-1.checkout-as-guest-button")
	WebElement CheckoutAsGuest;
	
	@FindBy(css = "button.button-1.register-button")
	WebElement registrationbtn;
	
	@FindBy(css = "a.button-1.register-continue-button")
	WebElement ContinueAfterRegbtn;
	
	@FindBy(id = "BillingNewAddress_FirstName")
	WebElement  FirstNametxtbox ;

	@FindBy(id = "BillingNewAddress_LastName")
	WebElement   SecondNametxtbox;

	@FindBy(id = "BillingNewAddress_Email")
	WebElement Emailtxtbox  ;

	@FindBy(id = "BillingNewAddress_CountryId")
	WebElement   Countrydropdownlist;

	@FindBy(id = "BillingNewAddress_City")
	WebElement  Citytxtbox ;

	@FindBy(id = "BillingNewAddress_Address1")
	WebElement   FirstAddresstxtbox;

	@FindBy(id = "BillingNewAddress_ZipPostalCode")
	WebElement  Zipcodetxtbox ;

	@FindBy(id = "BillingNewAddress_PhoneNumber")
	WebElement  Phonenumbertxtbox ;

	@FindBy(css = "button.button-1.new-address-next-step-button")
	WebElement  firstContinuebtn ;

	@FindBy(id = "shippingoption_0")
	WebElement shippingOptioncheckbox;
	;
	@FindBy(css = "button.button-1.shipping-method-next-step-button")
	WebElement  secondContinuebtn ;
	
	@FindBy(id = "paymentmethod_0")
	WebElement paymentMethodcheckbox;
	
	@FindBy(css = "button.button-1.payment-method-next-step-button")
	WebElement ThirdContinuebtn;
	
	@FindBy(css = "button.button-1.payment-info-next-step-button")
	WebElement fourthContinuebtn;
	
	@FindBy(css = "button.button-1.confirm-order-next-step-button")
	WebElement Confirmbtn;
	
	@FindBy(css = "div.title")
	public WebElement successMessage;
	
	@FindBy(linkText = "Click here for order details.")
	WebElement ClickforMoreDetailsLink;
	
	public void openRegistrationPage()
	{
		scrolltobottom();
		clickbutton(registrationbtn);
	}
	
	public void openCheckoutPageAfterRegistration()
	{
		clickbutton(ContinueAfterRegbtn);
		
	}
	
	public void RegisteredUserCheckoutProduct(String country,String city,String address,String postalcode,
			String phonenumber)
	{
		Select select=new Select(Countrydropdownlist);
		select.selectByVisibleText(country);
		sendkeys(Citytxtbox, city);
		sendkeys(FirstAddresstxtbox, address);
		sendkeys(Zipcodetxtbox, postalcode);
		sendkeys(Phonenumbertxtbox, phonenumber);
		clickbutton(firstContinuebtn);
		clickbutton(shippingOptioncheckbox);
		clickbutton(secondContinuebtn);
		clickbutton(paymentMethodcheckbox);
		clickbutton(ThirdContinuebtn);
		clickbutton(fourthContinuebtn);
		clickbutton(Confirmbtn);
		
		
	}
	
	public void OpenMoreDetailsPage()
	{
		clickbutton(ClickforMoreDetailsLink);
	}
	
	public void checkoutAsGuest()
	{
		scrolltobottom();
		clickbutton(CheckoutAsGuest);
	}
	
	public void CheckoutProductAsGuest(String frtname, String lstname, String email, String country, 
			String city, String address, String postalcode, String phonenumber)
	{
		sendkeys(FirstNametxtbox, frtname);
		sendkeys(SecondNametxtbox, lstname);
		sendkeys(Emailtxtbox, email);
		Select dropdown =new Select(Countrydropdownlist);
		dropdown.selectByVisibleText(country);
		sendkeys(Citytxtbox, city);
		sendkeys(FirstAddresstxtbox, address);
		sendkeys(Zipcodetxtbox, postalcode);
		sendkeys(Phonenumbertxtbox, phonenumber);
		clickbutton(firstContinuebtn);
		clickbutton(secondContinuebtn);
		clickbutton(ThirdContinuebtn);
		clickbutton(fourthContinuebtn);
		clickbutton(Confirmbtn);
	}
}
