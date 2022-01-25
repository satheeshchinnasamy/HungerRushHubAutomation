package com.hub.reports;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.hub.driver.DriverManager;
import com.hub.enums.ConfigProperties;
import com.hub.utils.PropertyUtils;
import com.hub.utils.ScreenShotUtils;
/**
 * 
 * <P>Class is responsible for logs</P>
 * <P>Holding the methods for logging the pass, fail and skip details</P>
 * 24-Jan-2022
 * @author satheesh.c
 * @Version 1.0
 */
public class ExtentLogger {

	public  ExtentLogger () {}

	/**
	 * <P>Method is to log the pass message</P>
	 * 24-Jan-2022
	 * @author satheesh.c
	 * @param message, String is passed to the method from the page class
	 */
	public static void pass(String message) {
		ExtentManager.getExtentTest().pass(message);
	}
	/**
	 * <P>Method is to log the fail message</P>
	 * 24-Jan-2022
	 * @author satheesh.c
	 * @param message, String is passed to the method from the page class
	 */
	public static void fail(String message) {
		ExtentManager.getExtentTest().fail(message);
	}
	public static void skip(String message) {
		ExtentManager.getExtentTest().skip(message);
	}

	/**
	 * 
	 * 24-Jan-2022
	 * @author satheesh.c
	 * @param message String is passed to the method from the page class
	 * @param isScreenShotNeeded User provide the boolean value, value will be true or false
	 * @throws Exception
	 */
	public static void pass(String message, boolean isScreenShotNeeded) throws Exception {
		if(PropertyUtils.getValue(ConfigProperties.PASSEDSTEPSSCREENSHOTS).equalsIgnoreCase("YES")
				&& isScreenShotNeeded) {
			ExtentManager.getExtentTest().pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShotUtils.getBase64Image()).build());
		}
		else {
			pass(message);
		}
	}
	/**
	 * 
	 * 24-Jan-2022
	 * @author satheesh.c
	 * @param message message, String is passed to the method from the page class
	 * @param isScreenShotNeeded User provide the boolean value, value will be true or false
	 * @throws Exception
	 */
	public static void fail(String message, boolean isScreenShotNeeded) throws Exception {
		if(PropertyUtils.getValue(ConfigProperties.FAILEDSTEPSSCREENSHOTS).equalsIgnoreCase("YES")
				&& isScreenShotNeeded) {
			ExtentManager.getExtentTest().fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShotUtils.getBase64Image()).build());
		}
		else {
			fail(message);
		}
	}
}
