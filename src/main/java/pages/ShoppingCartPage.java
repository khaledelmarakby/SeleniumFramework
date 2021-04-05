package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage  extends PageBase  {

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
		
	}

	@FindBy(name="updatecart")
	WebElement RemoveFromCartbtn;
	
	@FindBy(name = "itemquantity11216")
	WebElement Quantitytxtbox;
	
	@FindBy(css = "button.button-2.update-cart-button")
	WebElement UpdateCartbtn;
	
	@FindBy(css = "div.no-data")
	public WebElement EmptyCartMessage;
	
	@FindBy(css = "span.product-subtotal")
	public WebElement TotalPrice;
	
	@FindBy(id = "checkout")
	WebElement checkoutbtn;
	
	@FindBy(id = "termsofservice")
	WebElement termsofserviceCheckBox;
	
	public void RemoveProductFromCart()
	{
		clickbutton(RemoveFromCartbtn);
	}
	
	public void UpdateProductQuantity(String number)
	{
		ClearText(Quantitytxtbox);
		sendkeys(Quantitytxtbox, number);
		clickbutton(UpdateCartbtn);
	}
	
	public void openCheckoutPage()
	{
		clickbutton(termsofserviceCheckBox);
		clickbutton(checkoutbtn);
	}
}
