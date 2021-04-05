package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class PageBase {
	
	protected WebDriver driver;
	JavascriptExecutor js;
	public Actions action;
	
	public PageBase(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	protected static void  clickbutton(WebElement button)
	{
		button.click();
	}
	
	protected static void sendkeys(WebElement textbox,String text)
	{
		textbox.sendKeys(text);
	}

	public void scrolltobottom()
	{
		
		js.executeScript("scrollBy(0,500)");
	}
	
	public void ClearText(WebElement element)
	{
		element.clear();
	}
}
