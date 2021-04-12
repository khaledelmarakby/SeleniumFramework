package tests;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import utilities.Helper;

public class TestBase extends AbstractTestNGCucumberTests {
	
	public static WebDriver driver;
	public static String downloadpath=System.getProperty("user.dir")+"\\Downloads";
	
	public static ChromeOptions chromeoption()
	{
		ChromeOptions option=new ChromeOptions();
		HashMap<String,Object> chromePrefs=new HashMap<String, Object>();
		chromePrefs.put("profile.default.content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadpath);
		option.setExperimentalOption("prefs", chromePrefs);
		option.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		return option;
	}
	
	@SuppressWarnings("deprecation")
	@BeforeSuite
	@Parameters({"browser"})
	public void openURL(@Optional("chrome") String browserName)
	{
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			String path=System.getProperty("user.dir")+"//drivers//chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", path);
		    driver=new ChromeDriver(chromeoption());
		}
		
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			String path=System.getProperty("user.dir")+"//drivers//geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", path);
		    driver=new FirefoxDriver();
		}
		
		else if(browserName.equalsIgnoreCase("headless"))
		{
			String path=System.getProperty("user.dir")+"//drivers//phantomjs.exe";
			DesiredCapabilities caps=new DesiredCapabilities();
			caps.setJavascriptEnabled(true);
			caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, path);
			String[] phantomJSargs= {"--web-security=no","--ignore-ssl-errors=yes"};
			caps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, phantomJSargs);
			driver=new PhantomJSDriver(caps);
		}
		
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
	    driver.navigate().to("https://demo.nopcommerce.com/");
		
	}
	
	@AfterSuite
	
	public void closeURL()
	{
		driver.close();
	}
	
	@AfterMethod
	 public void takescreenshot(ITestResult result)
	 {
		if(ITestResult.FAILURE==result.getStatus())
		{
			System.out.println("Failed!!");
			System.out.println("Taking a screenshot...");
			Helper.takeScreenShot(driver, result.getName());
		}
	 }
}
