package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchProductTest extends TestBase {

	String productName="Apple MacBook Pro 13-inch";
	SearchPage searchObj;
	ProductDetailsPage productObj;

	@Test

	public void UserCanSearchForProducts()
	{

		searchObj=new SearchPage(driver);
		productObj=new ProductDetailsPage(driver);
		searchObj.ProductSearch(productName);
		searchObj.openProductDetailsPage();
		Assert.assertTrue(productObj.productNameBreadCrumb.getText().contains("Apple MacBook Pro 13-inch"));

	}
}
