package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase{

	public HomePage(WebDriver driver) {
		super(driver);
		js=(JavascriptExecutor) driver;
		action=new Actions(driver);
	}
	
	
	@FindBy(linkText = "Register")
	WebElement registerlink;
	
	public void openRegistrationPage()
	{
		clickbutton(registerlink);
	}

	@FindBy(linkText = "Log in")
	WebElement Loginbtn ;
	
	@FindBy(linkText = "Contact us")
	WebElement contactusLink;
	
	
	@FindBy(id = "customerCurrency")
	WebElement CurrencyDropdownlist;
	
	@FindBy(css = "span.price.actual-price")
	public WebElement PriceinEuro;
	
	@FindBy(linkText = "Computers")
	WebElement ComputersHoverMenu;
	
	@FindBy(linkText = "Notebooks")
	WebElement NoteBooksInsideComputersMenu;
	
	public void openLoginPage() 
	{
		clickbutton(Loginbtn);
	}
	
	public void openContactUsPage()
	{
		
		scrolltobottom();
		clickbutton(contactusLink);
	}
	
	public void changeCurrency()
	{
		Select currency=new Select(CurrencyDropdownlist);
		currency.selectByVisibleText("Euro");
		scrolltobottom();
	}
	
	public void SelectNotebooksFromComputersHoverMenu()
	{
		action.moveToElement(ComputersHoverMenu).moveToElement(NoteBooksInsideComputersMenu).click()
		.build().perform();
	}
}
