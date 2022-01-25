package com.hub.driver;

import org.openqa.selenium.WebDriver;

/**
 * <P>Class is handling the thread safety for the static Webdriver<P>
 * 24-Jan-2022
 * @author satheesh.c
 * @Version 1.0
 */


public final class DriverManager {

	/**
	 * Private constructor to avoid external instantiation
	 */
	private DriverManager() {

		}

	private static ThreadLocal<WebDriver> dr = new ThreadLocal<WebDriver>();
/**
 * <P>Method is to call the WebDriver</p>
 * 24-Jan-2022
 * @author satheesh.c
 * @return WebDriver
 */
	public static WebDriver getDriver() {
		return dr.get();
	}
/**
 * Method is to set the driver reference
 * 
 * 24-Jan-2022
 * @author satheesh.c
 * @param driverref
 */
	public static void setDriver(WebDriver driverref) {
		dr.set(driverref);
	}
/**
 *  Method to remove the driver instance, once the operation was over
 * 24-Jan-2022
 * @author satheesh.c
 * 
 */
	public static void unload() {
		dr.remove();
	}

}
