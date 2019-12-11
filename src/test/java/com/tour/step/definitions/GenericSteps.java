package com.tour.step.definitions;

import static com.tour.test.utils.ConfigurationUtil.getValue;

import java.util.List;

import org.openqa.selenium.WebDriver;

import com.tour.logger.CustomLogger;
import com.tour.mercury.driver.exception.WebDriverException;
import com.tour.page.objects.LandingPage;
import com.tour.ui.utils.browser.Browsers;

import cucumber.api.java.en.Given;

public class GenericSteps extends Browsers {

	WebDriver driver = getDriver();
	LandingPage lp = new LandingPage();
	
	private static final CustomLogger LOGGER = new CustomLogger(GenericSteps.class);

	@Given("^Login to the application with the username and password$")
	public void login_to_the_application_with_the_username_and_password(List<String> inputList) {
		try {
			driver.navigate().to(getValue("LOGIN_URL"));
			lp.txtUserName.sendKeys(inputList.get(0));
			lp.txtPassword.sendKeys(inputList.get(1));
			lp.btnLogin.click();
		} catch (Exception e) {
			new WebDriverException(e);
		} finally {
			LOGGER.info("Successfully logged into the application", inputList);
		}
	}
	
	

}
