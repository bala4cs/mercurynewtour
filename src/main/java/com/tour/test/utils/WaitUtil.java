package com.tour.test.utils;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tour.logger.CustomLogger;
import com.tour.mercury.driver.exception.FluentWaitException;
import com.tour.ui.utils.browser.Browsers;

public class WaitUtil extends Browsers{
	
	private static final CustomLogger LOGGER = new CustomLogger(WaitUtil.class);
	
	WebDriver driver;
	
	private static long sleep = 5000;
	
	public WaitUtil() {
		// TODO Auto-generated constructor stub
		driver = getDriver();
	}
	
	public static void fluentWait(WebElement element) {
		try {
			@SuppressWarnings({ "deprecation", "rawtypes" })
			FluentWait<WebDriver> driverwait =  new FluentWait<WebDriver>(Browsers.getDriver())
					.withTimeout(15, TimeUnit.SECONDS)  // wait maximum 30 seconds
					.pollingEvery(600, TimeUnit.MILLISECONDS)  // check after every 600 Milliseconds
					.ignoring(NoSuchElementException.class)  // ignore NoSuchElementException
					.ignoring(ElementNotInteractableException.class);
			driverwait.until(ExpectedConditions.visibilityOf(element));
			LOGGER.info("Check the locator in the page. . ");		
		} catch (Exception e) {
			 new FluentWaitException(e.getMessage());
		}
	}
			
	/**
	 * Selenium WebDriver has borrowed the idea of implicit waits from Watir.
	 * Implicit means that we can tell Selenium that we would like it to wait for a certain amount of time before throwing an exception that it cannot find the element on the page. 
	 * We should note that implicit waits will be in place for the entire time the browser is open. 
	 * This means that any search for elements on the page could take the time the implicit wait is set for.
	 */
	public static void implictWait(){
		Browsers.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	
	public static boolean waitUntilClickable(WebElement webe) {
		try {
			WebDriverWait wait = new WebDriverWait(Browsers.getDriver(), 30);
			wait.until(ExpectedConditions.elementToBeClickable(webe));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * 
	 */
	public static void defaultSleep(){
		try {
			Thread.sleep(sleep);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
