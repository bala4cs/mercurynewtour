package com.tour.page.objects.booking;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tour.ui.utils.browser.Browsers;

public class BookFlightPage extends Browsers {

	public BookFlightPage() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(name = "buyFlights")
	public WebElement btnSecurePurchase;
	
	@FindBy(name = "passFirst0")
	public WebElement txtFirstName;
	
	@FindBy(name = "passLast0")
	public WebElement txtLastName;
	
	@FindBy(name = "creditnumber")
	public WebElement txtCreditNumber;
	
	
	
}
