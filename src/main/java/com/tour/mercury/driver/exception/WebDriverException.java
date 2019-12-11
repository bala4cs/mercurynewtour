package com.tour.mercury.driver.exception;

import java.util.Map;

import com.tour.logger.CustomLogger;
import com.tour.report.listener.Reporter;
import com.tour.test.utils.ScreenShot;


public class WebDriverException extends Exception {

	private static final CustomLogger LOGGER = new CustomLogger(FluentWaitException.class);
	
	private static final long serialVersionUID = 1;

	public WebDriverException(Exception exception, Map<String, String> objectDetails) {
		try {
			String fileName = "ExtendedReport/screenshots/" + System.currentTimeMillis() + ".png";
			ScreenShot.takeScreenShot(fileName);
			Reporter.addScreenCaptureFromPath(fileName.replace("ExtendedReport/", ""));
			LOGGER.error(exception.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public WebDriverException(String message) {
		super(message);
		ScreenShot.addScreenshotToReport();
	}

	public WebDriverException(Throwable cause) {
		super(cause);
		ScreenShot.addScreenshotToReport();
		LOGGER.error("Failed to find Element ", cause);
	}


	public WebDriverException(Exception exception, String objectName) {
		try {
			String fileName = "ExtendedReport/screenshots/" + System.currentTimeMillis() + ".png";
			ScreenShot.takeScreenShot(fileName);
			Reporter.addScreenCaptureFromPath(fileName.replace("ExtendedReport/", ""));
			LOGGER.error("================Error ================ \n" + exception.getMessage()
					+ "\n\nFailed to Find Element - " + objectName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
