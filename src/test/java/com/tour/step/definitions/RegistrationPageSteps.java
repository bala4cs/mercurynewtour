package com.tour.step.definitions;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.tour.logger.CustomLogger;
import com.tour.mercury.driver.exception.WebDriverException;
import com.tour.page.objects.RegistrationPage;
import com.tour.test.utils.WaitUtil;
import com.tour.ui.utils.browser.Browsers;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class RegistrationPageSteps extends Browsers{
	
	WebDriver driver = getDriver();
	RegistrationPage registrationPage = new RegistrationPage();
	
	private static final CustomLogger LOGGER = new CustomLogger(RegistrationPageSteps.class);
	
	@Given("^Enter the Contact Information$")
	public void enter_the_Contact_Information(Map<String,String> map){
	    try {
			registrationPage.txtFirstName.sendKeys(map.get("FirstName"));
			registrationPage.txtLastName.sendKeys(map.get("LastName"));
			registrationPage.txtPhone.sendKeys(map.get("Phone"));
			registrationPage.txtEmail.sendKeys(map.get("Email"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			new WebDriverException(e);
		} finally {
			LOGGER.info("Completed the contact information details");
		}
	}

	@Given("^Enter the Mailing Information$")
	public void enter_the_Mailing_Information(Map<String,String> map){
		try {
			registrationPage.txtAddress1.sendKeys(map.get("Address"));
			registrationPage.txtCity.sendKeys(map.get("City"));
			registrationPage.txtState.sendKeys(map.get("State"));
			registrationPage.txtPostalCode.sendKeys(map.get("PostalCode"));
			Select select = new Select(registrationPage.selectcountry);
			select.selectByVisibleText(map.get("Country"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			new WebDriverException(e);
		} finally {
			LOGGER.info("Completed the contact information details");
		}
	}

	@Given("^Enter the User Information$")
	public void enter_the_User_Information(Map<String,String> map){
		try {
			registrationPage.txtUserName.sendKeys(map.get("UserName"));
			registrationPage.txtPassword.sendKeys(map.get("Password"));
			registrationPage.txtConfirmPassword.sendKeys(map.get("ConfirmPassword"));
			registrationPage.btnSubmit.click();
			WaitUtil.fluentWait(registrationPage.lblRegisterCheck);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			new WebDriverException(e);
		} finally {
			LOGGER.info("Completed the contact information details");
		}
	}

	@Then("^Verify the account creation message \"([^\"]*)\"$")
	public void verify_the_account_creation_message(String value){
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertTrue(registrationPage.lblRegisterCheck.getText().contains(value), "Expected message not available in the label");
	}
	
}
