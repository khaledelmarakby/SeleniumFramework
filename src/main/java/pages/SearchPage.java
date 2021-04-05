package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageBase {

	public SearchPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(id = "small-searchterms")
	WebElement searchtxtbox;
	
	@FindBy(css = "button.button-1.search-box-button")
	WebElement searchbtn;
	
	@FindBy(id = "ui-id-1")
	List<WebElement> ProductList;
	
	@FindBy(linkText = "Apple MacBook Pro 13-inch")
	WebElement productTitle;
	
	public void ProductSearch(String productName)
	{
		sendkeys(searchtxtbox, productName);
		clickbutton(searchbtn);
	}
	
	public void openProductDetailsPage()
	{
		clickbutton(productTitle);
	}
	
	public void ProductSearchUsingAutoComplete(String productname) throws InterruptedException
	{
		sendkeys(searchtxtbox, productname);
		Thread.sleep(1000);
		ProductList.get(0).click();
	}

}
