package com.tour.test.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.tour.report.listener.Reporter;
import com.tour.ui.utils.browser.Browsers;


public class ScreenShot extends Browsers{
	
	
	/**
	 * Take the screen shot of the current screen and Store in the
	 * ExtendedReport/screenshots Folder
	 */
	public static void takeScreenShot(String filePath) {
		
		File scrFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			// Copy paste file at destination folder location
			FileUtils.copyFile(scrFile, new File(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void addScreenshotToReport() {
		try {
			String fileName = "ExtendedReport/screenshots/" + System.currentTimeMillis() + ".png";
			takeScreenShot(fileName);
			Reporter.addScreenCaptureFromPath(fileName.replace("ExtendedReport/", ""));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
