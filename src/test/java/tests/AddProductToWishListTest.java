package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.WishListPage;

public class AddProductToWishListTest  extends TestBase {
	
	String productname="mac";
	SearchPage searchObj;
	ProductDetailsPage productobj;
	WishListPage WishObj;
	
	@Test(priority = 1)
	
	public void userCanSearchUsingAutoComplete() throws InterruptedException
	{
		searchObj=new SearchPage(driver);
		productobj=new ProductDetailsPage(driver);
		searchObj.ProductSearchUsingAutoComplete(productname);
		Assert.assertTrue(productobj.productNameBreadCrumb.getText().contains("Apple MacBook Pro 13-inch"));
	}
	
	@Test(priority = 2)
	
	public void AddandRemoveProductFromWishList()
	{
		productobj=new ProductDetailsPage(driver);
		WishObj=new WishListPage(driver);
		productobj.AddtoWishList();
		driver.navigate().to("https://demo.nopcommerce.com/wishlist");
		Assert.assertEquals("$3,600.00",WishObj.TotalPrice.getText());
		WishObj.RemoveProductFromWishList();
		Assert.assertEquals("The wishlist is empty!", WishObj.RemovalMessage.getText());
	}

}
