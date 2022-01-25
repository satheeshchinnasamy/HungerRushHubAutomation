package com.hub.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.hub.driver.DriverManager;
/**
 * 
 * <P>Utility class to take screenshot</P>
 * 25-Jan-2022
 * @author satheesh.c
 * @Version 1.0
 */
public final class ScreenShotUtils {
	/**
	 * Private constructor to avoid external instantiation
	 */
	private ScreenShotUtils() {}

	public static String getBase64Image() {
		return ((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);

	}
}
