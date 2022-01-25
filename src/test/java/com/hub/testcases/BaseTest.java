package com.hub.testcases;

import java.util.Map;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.hub.driver.Driver;
import com.hub.reports.ExtentReport;
/**
 * <P>Before and after test methods are encapsulated in the Class</P>
 * 25-Jan-2022
 * @author satheesh.c
 * @Version 1.0
 */
public class BaseTest {

	protected BaseTest() {
	}
		
	@BeforeMethod
	protected void setUp(Object[] data) throws Exception {
		Map<String,String>map=(Map<String, String>)data[0];
		Driver.initDriver(map.get("browser"));
	}

	@AfterMethod
	protected void tearDown() {
		Driver.quitDriver();
	}

}
