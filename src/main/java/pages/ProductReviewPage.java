package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductReviewPage extends PageBase {

	public ProductReviewPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(id = "AddProductReview_Title")
	WebElement reviewtitle;
	
	@FindBy(id = "AddProductReview_ReviewText")
	WebElement reviewtext;
	
	@FindBy(id = "addproductrating_4")
	WebElement ratingradiobutton;
	
	@FindBy(css = "button.button-1.write-product-review-button")
	WebElement submitbutton;
	
	@FindBy(css = "div.result")
	public WebElement reviewMessage;
	
	public void ProductReview(String title, String text)
	{
		sendkeys(reviewtitle, title);
		sendkeys(reviewtext, text);
		clickbutton(ratingradiobutton);
		clickbutton(submitbutton);
		
	}

}
