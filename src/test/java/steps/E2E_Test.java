package steps;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CheckoutPage;
import pages.HomePage;
import pages.OrderDetailsPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;
import tests.TestBase;

public class E2E_Test  extends TestBase {
	
	HomePage homeObj;
	SearchPage searchObj;
	CheckoutPage checkoutObj;
	ProductDetailsPage detailsObj;
	ShoppingCartPage cartObj;
	OrderDetailsPage orderObj;
	
	
	@Given("The home page is opened")
	public void the_home_page_is_opened() {
	    
	}
	
	@When("the user search for {string}")
	public void the_user_search_for(String productname ) throws InterruptedException {
	    searchObj=new SearchPage(driver);
	    searchObj.ProductSearchUsingAutoComplete(productname);
	}
	
	@When("add the product to cart")
	public void add_the_product_to_cart() {
		detailsObj=new ProductDetailsPage(driver);
		cartObj=new ShoppingCartPage(driver);
		detailsObj.AddToCart();
		driver.navigate().to("https://demo.nopcommerce.com/cart");
	    cartObj.openCheckoutPage();
	}
	
	@When("enters all the required details on checkout page and make an order")
	public void enters_all_the_required_details_on_checkout_page_and_make_an_order() {
	    checkoutObj=new CheckoutPage(driver);
	    checkoutObj.checkoutAsGuest();
	    checkoutObj.CheckoutProductAsGuest("test", "test11","test@test6.com", "Egypt", "cairo",
				"sadads", "213213", "32423434234");
	    Assert.assertTrue(checkoutObj.successMessage.isDisplayed());
	}
	
	@Then("the user can see invoice and download it")
	public void the_user_can_see_invoice_and_download_it() throws InterruptedException {
		checkoutObj=new CheckoutPage(driver);
		orderObj=new  OrderDetailsPage(driver);
		checkoutObj.OpenMoreDetailsPage();
		orderObj.DownloadPDFInvoice();
		orderObj.PrintInvoice();
		Assert.assertTrue(driver.getCurrentUrl().contains("orderdetails"));
	    
	}


}
