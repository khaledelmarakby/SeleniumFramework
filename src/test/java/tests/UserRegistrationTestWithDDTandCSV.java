package tests;

import java.io.FileReader;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTestWithDDTandCSV extends TestBase {
	
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	
	CSVReader reader;
	

	@Test (priority = 1)
	public void UserCanRegisterSuccessfully() throws CsvValidationException, IOException
	{
		String CSV_path=System.getProperty("user.dir")+"/src/test/java/data/UserData.csv";
		reader=new CSVReader(new FileReader(CSV_path));
		
		String[] CSV_cell;
		
		while((CSV_cell=reader.readNext()) != null)
		{
			String firstname=CSV_cell[0];
			String lastname=CSV_cell[1];
			String email =CSV_cell[2];
			String password=CSV_cell[3];
		
		homeObject=new HomePage(driver);
		registerObject=new UserRegistrationPage(driver);
		
		homeObject.openRegistrationPage();
		registerObject.userResgistration(firstname,lastname,email,password);
		Assert.assertEquals("Your registration completed", registerObject.successMessage.getText());
		registerObject.userLogout();
		loginObject=new LoginPage(driver);
		homeObject.openLoginPage();
		loginObject.Login(email,password);
		Assert.assertEquals("Log out", registerObject.logoutlink.getText());
		registerObject.userLogout();
		}
	}
	
	
}
