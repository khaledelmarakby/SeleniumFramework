package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CheckoutPage;
import pages.OrderDetailsPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;
import pages.UserRegistrationPage;

public class RegisteredUserCheckoutProductTest extends TestBase {
	
	/* 1-Register User
	 * 2- Search for product
	 * 3- Add to cart
	 * 4- checkout
	 * 5- logout
	 */

	SearchPage searchObj;
	ProductDetailsPage detailsObj;
	ShoppingCartPage cartObj;
	CheckoutPage checkOutObj;
	UserRegistrationPage regObj;
	OrderDetailsPage orderObj;

	@Test

	public void RegisteredUserCheckOutProduct() throws InterruptedException
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
		checkOutObj.openRegistrationPage();
		regObj.userResgistration("sada", "asdas", "test@test333.com", "123456");
		checkOutObj.openCheckoutPageAfterRegistration();
		cartObj.openCheckoutPage();
		checkOutObj.RegisteredUserCheckoutProduct("Egypt", "cairo","sadsad", "1234", "1123443223");
		Assert.assertTrue(checkOutObj.successMessage.isDisplayed());
		checkOutObj.OpenMoreDetailsPage();
		orderObj.DownloadPDFInvoice();
		orderObj.PrintInvoice();
		Assert.assertTrue(driver.getCurrentUrl().contains("orderdetails"));

	}

}
