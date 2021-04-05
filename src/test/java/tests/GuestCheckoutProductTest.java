package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CheckoutPage;
import pages.OrderDetailsPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;
import pages.UserRegistrationPage;

public class GuestCheckoutProductTest extends TestBase {

	SearchPage searchObj;
	ProductDetailsPage detailsObj;
	ShoppingCartPage cartObj;
	CheckoutPage checkOutObj;
	UserRegistrationPage regObj;
	OrderDetailsPage orderObj;


	@Test

	public void GuestCanCheckoutProduct() throws InterruptedException
	{
		searchObj=new SearchPage(driver);
		detailsObj=new ProductDetailsPage(driver);
		cartObj=new ShoppingCartPage(driver);
		checkOutObj=new CheckoutPage(driver);
		regObj=new UserRegistrationPage(driver);
		orderObj=new OrderDetailsPage(driver);
		searchObj.ProductSearchUsingAutoComplete("mac");
		detailsObj.AddToCart();
		driver.navigate().to("https://demo.nopcommerce.com/cart");
		cartObj.openCheckoutPage();
		checkOutObj.checkoutAsGuest();
		checkOutObj.CheckoutProductAsGuest("test", "test11","test@test6.com", "Egypt", "cairo",
				"sadads", "213213", "32423434234");
		Assert.assertTrue(checkOutObj.successMessage.isDisplayed());
		


	}
}
