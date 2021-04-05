package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderDetailsPage extends PageBase {

	public OrderDetailsPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(css = "a.button-2.print-order-button")
	WebElement  Printbtn  ;
	
	@FindBy(css = "a.button-2.pdf-invoice-button")
	WebElement    PDFinvoiceDownloadbtn;
	
	public void PrintInvoice()
	{
		clickbutton(Printbtn);

	}
	
	public void DownloadPDFInvoice() throws InterruptedException
	{
		clickbutton(PDFinvoiceDownloadbtn);
		Thread.sleep(1000);
	}

}
