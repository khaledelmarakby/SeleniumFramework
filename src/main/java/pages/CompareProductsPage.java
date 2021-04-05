package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CompareProductsPage extends PageBase {

	public CompareProductsPage(WebDriver driver) {
		super(driver);
		
	}

	@FindBy(css = "a.clear-list")
	WebElement ClearListbtn;
	
	@FindBy(css = "div.no-data")
	public WebElement EmptyTableMessage;
	
	@FindBy(css = "table.compare-products-table")
	WebElement CompareTable;
	
	@FindBy(tagName = "tr")
	List<WebElement> allrows;
	
	@FindBy(tagName = "td")
	List<WebElement> allcol;
	
	@FindBy(linkText = "Asus N551JK-XO076H Laptop")
	public WebElement firstProductName;
	
	@FindBy(linkText = "Apple MacBook Pro 13-inch")
	public WebElement secondProductName;
	
	
	
	public void PrintAllDataFromCompareTable()
	{
		for(WebElement row:allrows)
		{
			System.out.println(row.getText() + "\t");
			for(WebElement col : allcol)
			{
				System.out.println(col.getText() + "\t");
			}
		}
	}
	
	public void ClearCompareList()
	{
		clickbutton(ClearListbtn);
	}
}
