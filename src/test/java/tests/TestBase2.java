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

import data.loadProperties;

public class TestBase2 {
	
	public static String  Username = loadProperties.sauceUserData.getProperty("username");
	public static String  accessKey=loadProperties.sauceUserData.getProperty("accesskey");
	public static String sauceLabsURL="http://"+Username+":"+accessKey+
			loadProperties.sauceUserData.getProperty("selenium URL");
	
	public static String baseURL ="https://demo.nopcommerce.com/";
	protected ThreadLocal<RemoteWebDriver> driver =null;
	
	@BeforeClass
	@Parameters(value= {"browser"})
	public void setup(@Optional("chrome")String browser) throws MalformedURLException
	{
		driver=new ThreadLocal<RemoteWebDriver>();
		DesiredCapabilities caps =new DesiredCapabilities();
		caps.setCapability("browserName", browser);
		//run on selenium grid locally
		//driver.set(new RemoteWebDriver(new URL("http://localhost.com:4444/wd/hub"), caps));
		// run on saucelabs on cloud
		driver.set(new RemoteWebDriver(new URL(sauceLabsURL), caps));
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
