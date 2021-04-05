package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase {

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(css = "strong.current-item")
	public WebElement productNameBreadCrumb ;
	
	@FindBy(css = "button.button-2.email-a-friend-button")
	WebElement emailFriendbtn;
	
	@FindBy(linkText = "Add your review")
	WebElement addreviewLink;
	
	@FindBy(id = "add-to-wishlist-button-4")
	WebElement AddtoWishlistbtn;
	
	@FindBy(css = "button.button-2.add-to-compare-list-button")
	WebElement AddToCompareListbtn;
	
	@FindBy(id = "add-to-cart-button-4")
	WebElement AddtoCartbtn;
	
	
	public void openEmailtoFriendPage()
	{
		clickbutton(emailFriendbtn);
	}
	
	public void openAddReviewPage()
	{
		clickbutton(addreviewLink);
	}

	public void AddtoWishList()
	{
		clickbutton(AddtoWishlistbtn);
	}
	
	public void AddToCompareList()
	{
		clickbutton(AddToCompareListbtn);
	}
	
	public void AddToCart()
	{
		clickbutton(AddtoCartbtn);
	}
}
