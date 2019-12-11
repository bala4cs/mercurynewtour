package com.tour.page.objects.booking;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tour.ui.utils.browser.Browsers;

public class ItineraryPage extends Browsers {
	
	
	public ItineraryPage() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy( xpath = "(//*[@class=\"frame_header_info\"])[1]")
	public WebElement lblFlightConfirmation;
			
}
