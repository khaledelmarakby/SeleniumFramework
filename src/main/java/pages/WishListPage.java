package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishListPage extends PageBase{

	public WishListPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(css = "span.product-subtotal")
	public WebElement TotalPrice;

	@FindBy(css = "button.remove-btn")
	WebElement Removebtn;

	@FindBy(css="div.no-data")
	public WebElement RemovalMessage;
	
	public void RemoveProductFromWishList()
	{
		clickbutton(Removebtn);
	}


}
