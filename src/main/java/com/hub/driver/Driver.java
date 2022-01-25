package com.hub.driver;

import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.hub.constants.FrameworkConstants;
import com.hub.enums.ConfigProperties;
import com.hub.utils.PropertyUtils;

import io.github.bonigarcia.wdm.WebDriverManager;


/**
 * <P>Class having methods to initialize the driver and quit the driver</P>
 * 22-Jan-2022
 * @author satheesh.c
 * @Version 1.0
 */

public final class Driver {


	/*
	 * Private constructor to avoid external instantiation
	 */
	private Driver() {}
	
	/**
	 * @ author satheesh
	 * @ 22-Jan-2022
	 * @param browser values are coming from Base Test. Values will be chrome or firefox
	 * @throws Exception
	 * @see WebDriverManger
	 * @see com.hub.testcases.BaseTests
	 */
	public static void initDriver(String browser) throws Exception {



		if(Objects.isNull(DriverManager.getDriver())) {
			if(browser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				DriverManager.setDriver(new ChromeDriver());
			}else if(browser.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				DriverManager.setDriver(new FirefoxDriver());
			}else
				System.out.println("Choosen browser was not there");
		}
		DriverManager.getDriver().get(PropertyUtils.getValue(ConfigProperties.URL));
		DriverManager.getDriver().manage().window().maximize();
	}

	public static void quitDriver() {
		if(Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}
}
