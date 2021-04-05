package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;

public class ChangeCurrencyTest extends TestBase {
	
	HomePage homeObj;
	
	@Test
	
	public void UserCanChangeCurrency()
	{
		homeObj =new HomePage(driver);
		homeObj.changeCurrency();
		Assert.assertEquals("€1032.00", homeObj.PriceinEuro.getText());
	}

}
