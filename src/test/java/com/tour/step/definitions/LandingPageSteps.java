package com.tour.step.definitions;

import static com.tour.test.utils.ConfigurationUtil.getValue;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.tour.logger.CustomLogger;
import com.tour.mercury.driver.exception.WebDriverException;
import com.tour.page.objects.LandingPage;
import com.tour.ui.utils.browser.Browsers;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LandingPageSteps extends Browsers{
	
	WebDriver driver = getDriver();
	LandingPage lp = new LandingPage();
	
	private static final CustomLogger LOGGER = new CustomLogger(LandingPageSteps.class);
	
	@Given("^Open the browser url \"([^\"]*)\"$")
	public void open_the_browser_url(String url){
		driver.navigate().to(getValue(url));
	}

	@Given("^Enter the username and password$")
	public void enter_the_username_and_password(DataTable data){
		try {
			List<String> list = data.asList(String.class);
			lp.txtUserName.sendKeys(list.get(0));
			lp.txtPassword.sendKeys(list.get(1));
		} catch (Exception e) {
			new WebDriverException(e);
		} finally {
			LOGGER.info("Completed the step");
		}
	}

	@When("^Click the Sign-In button$")
	public void click_the_Sign_In_button(){
	    // Write code here that turns the phrase above into concrete actions
	    try {
	    	lp.btnLogin.click();
	    }catch(Exception e) {
	    	new WebDriverException(e);
	    }
	}
	
	@Then("^Verify the url \"([^\"]*)\"$")
	public void verify_the_url(String url) {
	    // Write code here that turns the phrase above into concrete actions
		try {
			Assert.assertTrue(driver.getCurrentUrl().contains(getValue(url)));
		}catch(Exception e) {
			new WebDriverException(e);
		}
	}
}
