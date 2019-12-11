package com.tour.test.utils;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.tour.logger.CustomLogger;
import com.tour.ui.utils.browser.Browsers;

public class RunTimeVariable {
	private static final CustomLogger LOGGER = new CustomLogger(RunTimeVariable.class);
	
	private static RunTimeVariable _instance;

	private static Map<String, String> data = new HashMap<String, String>();

	private RunTimeVariable() {
	}

	public static RunTimeVariable getInstance() {

		if (_instance == null) {
			_instance = new RunTimeVariable();
		}
		return _instance;
	}

	public static String getValue(String key) {
		Capabilities cap = ((RemoteWebDriver) Browsers.getDriver()).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		return data.get(key + ":" + browserName);
	}

	public static void setValue(String key, String value) {
		Capabilities cap = ((RemoteWebDriver) Browsers.getDriver()).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		if (getInstance() != null) {
			getInstance();
			LOGGER.info("Runtime Key :: " + key + " Runtime Value :: " + value);
			data.put(key + ":" + browserName, value);
		} else {
			data.put(key + ":" + browserName, value);
		}

	}

}
