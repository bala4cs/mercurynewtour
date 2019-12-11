package com.tour.step.definitions.booking;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.tour.logger.CustomLogger;
import com.tour.mercury.driver.exception.WebDriverException;
import com.tour.page.objects.booking.BookFlightPage;
import com.tour.page.objects.booking.FlightFinderPage;
import com.tour.page.objects.booking.ItineraryPage;
import com.tour.page.objects.booking.SelectFlightPage;
import com.tour.ui.utils.browser.Browsers;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FlightBookingSteps extends Browsers {

	WebDriver driver = getDriver();
	BookFlightPage bookFlightPage = new BookFlightPage();
	FlightFinderPage flightFinderPage = new FlightFinderPage();
	SelectFlightPage selectFlightPage = new SelectFlightPage();
	ItineraryPage itineraryPage = new ItineraryPage();

	private static final CustomLogger LOGGER = new CustomLogger(FlightBookingSteps.class);

	@When("^Provide the flight details$")
	public void provide_the_flight_details(Map<String, String> map) {
		try {
			if(map.get("Type").equals("oneway")) {
				flightFinderPage.btnRadioOneWay.click();
			}else {
				flightFinderPage.btnRadioRoundTrip.click();
			}
			Select selectDepartFrom = new Select(flightFinderPage.drpFromPort);
			selectDepartFrom.selectByVisibleText(map.get("DepartingFrom"));
			Select selectPassenger = new Select(flightFinderPage.sltPassCount);
			selectPassenger.selectByVisibleText(map.get("Passenger"));
			Select selectDepartTo = new Select(flightFinderPage.drptoPort);
			selectDepartTo.selectByVisibleText(map.get("DepartingTo"));
		} catch (Exception e) {
			new WebDriverException(e);
		} finally {
			LOGGER.info("Provided the flight details...", map.toString());
		}
	}

	@When("^Provide the Preference details$")
	public void provide_the_Preference_details(Map<String, String> map) {
		try {
			if (map.get("Service").equals("Business")) {
				flightFinderPage.btnRadioBClass.click();
				LOGGER.info("Clicked the services details");
			} else if (map.get("Service").equals("FirstClass")) {
				flightFinderPage.btnRadioFClass.click();
				LOGGER.info("Clicked the services details");
			}			
			Select selectAirline = new Select(flightFinderPage.sltAirline);
			selectAirline.selectByVisibleText(map.get("Airline"));
			LOGGER.info("Successfully selected the Airlines details");
		} catch (Exception e) {
			new WebDriverException(e);
		}finally {
			LOGGER.info("Provided the preference details", map.toString());
		}
	}

	@When("^click the continue button from flight finder page$")
	public void click_the_continue_button_from_flight_finder_page() {
		try {
			flightFinderPage.btnContinue.click();
		} catch (Exception e) {
			new WebDriverException(e);
		}
	}

	@When("^click the continue button from the select flight page$")
	public void click_the_continue_button_from_the_select_flight_page() {
		try {
			selectFlightPage.btnReserve.click();
		} catch (Exception e) {
			new WebDriverException(e);
		}
	}

	@When("^Book a flight with mandatory params$")
	public void book_a_flight_with_mandatory_params(Map<String, String> map) {
		try {
			bookFlightPage.txtFirstName.sendKeys(map.get("FirstName"));
			bookFlightPage.txtLastName.sendKeys(map.get("LastName"));
			bookFlightPage.txtCreditNumber.sendKeys(map.get("CardNumber"));
			bookFlightPage.btnSecurePurchase.click();
			LOGGER.info("Provided the details in book flight page", map.toString());
		} catch (Exception e) {
			new WebDriverException(e);
		} 
	}

	@Then("^verify the itinerary has been booked$")
	public void verify_the_itinerary_has_been_booked() {
		// Write code here that turns the phrase above into concrete actions
		try {
			Assert.assertTrue(itineraryPage.lblFlightConfirmation.isDisplayed(), "Failed to display the booking confirmation");;
		} catch (Exception e) {
			new WebDriverException(e);
		}
	}

}
