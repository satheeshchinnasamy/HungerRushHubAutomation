package com.hub.reports;

import com.aventstack.extentreports.ExtentTest;
/**
 * <P>Class handles the ExtentTest thread safety</P>
 * 25-Jan-2022
 * @author satheesh.c
 * @Version 1.0
 */
public class ExtentManager {

	/**
	 * Private constructor to avoid external instantiation
	 */
	private ExtentManager() {

	}

	private static ThreadLocal<ExtentTest> extTest = new ThreadLocal<ExtentTest>();

	public static ExtentTest getExtentTest() {
		return extTest.get();
	}

	static void setExtentTest(ExtentTest test) {
		extTest.set(test);
	}

	static void unload() {
		extTest.remove();
	}
}
