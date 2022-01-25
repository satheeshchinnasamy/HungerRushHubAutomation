package com.hub.factories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hub.constants.FrameworkConstants;
import com.hub.driver.DriverManager;
import com.hub.enums.WaitStrategy;
/**
 * <P>Class having the method which explicity wait for the condition mentioned</P>
 * 25-Jan-2022
 * @author satheesh.c
 * @Version 1.0
 */
public class ExplicitWaitFactory {
	
	/**
	 * 
	 * 25-Jan-2022
	 * @author satheesh.c
	 * @param waitstrategy Values from com.hub.enums.WaitStrategy
	 * @param by Webelemnt getting supplied in the page layers
	 * @return wait for the action and will return the webelement
	 */
	public static WebElement performExplicitWait(WaitStrategy waitstrategy, By by) {
		WebElement element=null;
		
		if(waitstrategy==waitstrategy.CLICKABLE) {
			element=new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitwait())
			.until(ExpectedConditions.elementToBeClickable(by));
		}
		else if(waitstrategy==waitstrategy.PRESENT){
			element=new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitwait())
			.until(ExpectedConditions.elementToBeClickable(by));
		}
		else if(waitstrategy==waitstrategy.VISIBLE){
			element=new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitwait())
			.until(ExpectedConditions.visibilityOfElementLocated(by));
		}
		return element;
		
	}

}
