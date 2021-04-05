package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CompareProductsPage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class AddProductToCompareTest extends TestBase {

	String productname="mac";
	SearchPage searchObj;
	ProductDetailsPage productobj;
	CompareProductsPage compareObj;

	@Test

	public void UserCanAddAndDeleteProductsToCompareList() throws InterruptedException
	{
		searchObj=new SearchPage(driver);
		productobj=new ProductDetailsPage(driver);
		compareObj=new CompareProductsPage(driver);
		searchObj.ProductSearchUsingAutoComplete("mac");
		Assert.assertTrue(productobj.productNameBreadCrumb.getText().contains("Apple MacBook Pro 13-inch"));
		productobj.AddToCompareList();
		searchObj.ProductSearchUsingAutoComplete("asu");
		productobj.AddToCompareList();
		driver.navigate().to("https://demo.nopcommerce.com/compareproducts");
		driver.navigate().refresh();
		Assert.assertTrue(compareObj.firstProductName.isDisplayed());
		Assert.assertTrue(compareObj.secondProductName.isDisplayed());
		compareObj.PrintAllDataFromCompareTable();
		compareObj.ClearCompareList();
		Assert.assertEquals("You have no items to compare.", compareObj.EmptyTableMessage.getText());
	}





}
