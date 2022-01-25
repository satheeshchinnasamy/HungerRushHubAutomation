package com.hub.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.hub.driver.DriverManager;
import com.hub.enums.WaitStrategy;
import com.hub.factories.ExplicitWaitFactory;
import com.hub.reports.ExtentLogger;

/**
 * Base page contains the methods used in the page layers
 * 24-Jan-2022
 * @author satheesh.c
 * @Version 1.0
 */
public class BasePage {
	
	/**
	 *
	 * <P>Method is to click the element</P>
	 * 24-Jan-2022
	 * @author satheesh.c
	 * @param by WebElements passed from the Page class
	 * @param waitstrategy Calling the defined waitstrategy from {@link com.hub.factories.ExplicitWaitFactory}
	 * @param elementname Element name passed by the user for logger in the extent report
	 */
	protected void click(By by, WaitStrategy waitstrategy, String elementname) {
		WebElement element=ExplicitWaitFactory.performExplicitWait(waitstrategy, by);
		element.click();
		try {
			ExtentLogger.pass(elementname+" is clicked successfully", true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
	/**
	 * 
	 * <P>Method is to perform enter the texts in the page layers</P>
	 * 24-Jan-2022
	 * @author satheesh.c
	 * @param by WebElements passed from the Page class
	 * @param waitstrategy Calling the defined waitstrategy from {@link com.hub.factories.ExplicitWaitFactory}
	 * @param text Text value passed from dataprovider at the runtime
	 * @param elementname
	 */
	protected void sendtext(By by, WaitStrategy waitstrategy, String text, String elementname) {
		WebElement element=ExplicitWaitFactory.performExplicitWait(waitstrategy, by);
		element.sendKeys(text);
		try {
			ExtentLogger.pass(text+" is entered in the "+elementname+ " successfully", true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected String pageTitle() {
		return DriverManager.getDriver().getTitle();
	}
	
	
}
