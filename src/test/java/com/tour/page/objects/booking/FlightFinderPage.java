package com.tour.page.objects.booking;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tour.ui.utils.browser.Browsers;

public class FlightFinderPage extends Browsers {

	public FlightFinderPage() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath = "//*[@value=\"oneway\"]")
	public WebElement btnRadioOneWay;

	@FindBy(xpath = "//*[@value=\"roundtrip\"]")
	public WebElement btnRadioRoundTrip;
	
	@FindBy(name = "passCount")
	public WebElement sltPassCount;
	
	@FindBy(name = "fromPort")
	public WebElement drpFromPort;
	
	@FindBy(name = "toPort")
	public WebElement drptoPort;
		
	@FindBy(xpath = "//*[@value=\"Business\"]")
	public WebElement btnRadioBClass;
	
	@FindBy(xpath = "//*[@value=\"First\"]")
	public WebElement btnRadioFClass;
	
	@FindBy(name = "airline")
	public WebElement sltAirline;
	
	@FindBy(name = "findFlights")
	public WebElement btnContinue;
	
	
}
