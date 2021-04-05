package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;

public class ProductHoverMenuTest extends TestBase {
	
	HomePage homeObj;
	
	@Test
	
	public void UserCanSelectSubCatergoryFromMainMenu()
	{
		homeObj=new HomePage(driver);
		homeObj.SelectNotebooksFromComputersHoverMenu();
		Assert.assertTrue(driver.getCurrentUrl().contains("notebooks"));
	}

}
