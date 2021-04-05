package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchProductUsingAutoCompleteTest extends TestBase {

	String productname="mac";
	SearchPage searchObj;
	ProductDetailsPage productobj;
	
	@Test
	
	public void userCanSearchUsingAutoComplete() throws InterruptedException
	{
		searchObj=new SearchPage(driver);
		productobj=new ProductDetailsPage(driver);
		searchObj.ProductSearchUsingAutoComplete(productname);
		Assert.assertTrue(productobj.productNameBreadCrumb.getText().contains("Apple MacBook Pro 13-inch"));
	}
}
