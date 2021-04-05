package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;

public class AddProductToShoppingCartTest  extends TestBase {


	SearchPage searchObj;
	String NewQuantity="5";
	ShoppingCartPage cartObj;
	ProductDetailsPage detailsObj;

	@Test(priority = 1)

	public void AddProductToCart() throws InterruptedException
	{
		searchObj=new SearchPage(driver);
		detailsObj=new ProductDetailsPage(driver);
		cartObj=new ShoppingCartPage(driver);
		searchObj.ProductSearchUsingAutoComplete("mac");
		detailsObj.AddToCart();
		driver.navigate().to("https://demo.nopcommerce.com/cart");
		cartObj.UpdateProductQuantity(NewQuantity);
		Assert.assertEquals("$9,000.00", cartObj.TotalPrice.getText());

	}

	@Test(priority = 2)

	public void RemoveProductFromCart()
	{
		cartObj=new ShoppingCartPage(driver);
		cartObj.RemoveProductFromCart();
		Assert.assertEquals("Your Shopping Cart is empty!", cartObj.EmptyCartMessage.getText());
	}

}
