package tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class TestBase2 {
	
	public static String baseURL ="https://demo.nopcommerce.com/";
	protected ThreadLocal<RemoteWebDriver> driver =null;
	
	@BeforeClass
	@Parameters(value= {"browser"})
	public void setup(@Optional("chrome")String browser) throws MalformedURLException
	{
		driver=new ThreadLocal<RemoteWebDriver>();
		DesiredCapabilities caps =new DesiredCapabilities();
		caps.setCapability("browserName", browser);
		driver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps));
		getdriver().navigate().to(baseURL);
	}
	
	
	public WebDriver getdriver()
	{
		return driver.get();
	}
	
	
	@AfterClass
	
	public void closeURL()
	{
		getdriver().quit();
		driver.remove();
	}

}
