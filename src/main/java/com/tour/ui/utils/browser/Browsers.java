package com.tour.ui.utils.browser;

import java.util.logging.Level;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.tour.logger.CustomLogger;

public class Browsers extends BrowserAbstract {

	private static final CustomLogger LOGGER = new CustomLogger(Browsers.class);
	
	@Override
	public void setDriver(String myBrowser) {
		// TODO Auto-generated method stub
		WebDriver driver = null;

		switch (myBrowser) {
		
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			options.addArguments("--start-maximized");
			driver = new ChromeDriver(options);
			((RemoteWebDriver) driver).setLogLevel(Level.INFO);
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
			DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
			desiredCapabilities.setAcceptInsecureCerts(true);
			driver = new FirefoxDriver(desiredCapabilities);
			driver.manage().window().maximize();
			break;
		case "edge":
			try {
				driver = new EdgeDriver();
				Thread.sleep(10000);
			} catch (InterruptedException we) {
				LOGGER.error(we.getMessage());
			}
			break;
		case "ie":
			System.setProperty("webdriver.ie.driver", "drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			break;
		default:
			throw new IllegalStateException("Browser is not supported");
		}

		setWebDriver(driver);
	}

	@Override
	public void closeDriver() {
		// TODO Auto-generated method stub
		getDriver().quit();
	}

}
