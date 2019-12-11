package com.tour.mercury.driver.exception;

import com.tour.logger.CustomLogger;
import com.tour.report.listener.Reporter;
import com.tour.test.utils.ScreenShot;

public class FluentWaitException extends Exception {

	private static final long serialVersionUID = 1L;
	private String message = null;

	private static final CustomLogger LOGGER = new CustomLogger(FluentWaitException.class);

	public FluentWaitException() {
		super();
	}

	public FluentWaitException(String message) {

		super(message);
		if (message.contains("Expected condition failed: waiting for visibility of element located")) {
			this.message = "unable to find element using fluent wait ";
			try {
				String fileName = "ExtendedReport/screenshots/" + System.currentTimeMillis() + ".png";
				ScreenShot.takeScreenShot(fileName);
				Reporter.addScreenCaptureFromPath(fileName.replace("ExtendedReport/", ""));
				LOGGER.error("================Error ================\n unable to find element using fluent wait"

						+ "\n\nFailed to Find Element - ");
			} catch (Exception e) {

				e.printStackTrace();
			}

		}
	}
}
