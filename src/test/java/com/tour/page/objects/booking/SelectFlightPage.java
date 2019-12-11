package com.tour.page.objects.booking;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tour.ui.utils.browser.Browsers;

public class SelectFlightPage extends Browsers {

	public SelectFlightPage() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(name = "reserveFlights")
	public WebElement btnReserve;
	
	
}
