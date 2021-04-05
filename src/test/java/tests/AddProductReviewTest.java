package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.ProductReviewPage;
import pages.SearchPage;
import pages.UserRegistrationPage;

public class AddProductReviewTest extends TestBase {


	HomePage homeObject;
	UserRegistrationPage registerObject;
	String productname="mac";
	SearchPage searchObj;
	ProductDetailsPage productobj;
	ProductReviewPage reviewObj;


	@Test (priority = 1)
	public void UserCanRegisterSuccessfully()
	{
		homeObject=new HomePage(driver);
		registerObject=new UserRegistrationPage(driver);

		homeObject.openRegistrationPage();
		registerObject.userResgistration("mohamed", "ahmed", "test12@gmail.com", "123456");
		Assert.assertEquals("Your registration completed", registerObject.successMessage.getText());
	}


	@Test(priority = 2)

	public void userCanSearchUsingAutoComplete() throws InterruptedException
	{
		searchObj=new SearchPage(driver);
		productobj=new ProductDetailsPage(driver);
		searchObj.ProductSearchUsingAutoComplete(productname);
		Assert.assertTrue(productobj.productNameBreadCrumb.getText().contains("Apple MacBook Pro 13-inch"));
	}
	
	@Test(priority = 3)
	
	public void UserCanAddReviewForProduct()
	{
		productobj=new ProductDetailsPage(driver);
		productobj.openAddReviewPage();
		reviewObj=new ProductReviewPage(driver);
		reviewObj.ProductReview("My review", "The product is very good and it meets my expectations");
		Assert.assertEquals("Product review is successfully added.", reviewObj.reviewMessage.getText());
	}
}
