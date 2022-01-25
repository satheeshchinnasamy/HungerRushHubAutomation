package com.hub.pages;

import org.openqa.selenium.By;

import com.hub.enums.WaitStrategy;
import com.hub.reports.ExtentLogger;
import com.hub.reports.ExtentManager;
import com.hub.reports.ExtentReport;
/**
 * <P>Class holds LoginPage methods and elements</P>
 * 25-Jan-2022
 * @author satheesh.c
 * @Version 1.0
 */
public class HubLoginPage extends BasePage{
	
	private final By username= By.id("UserName");
	private final By password= By.id("Password");
	private final By loginbutton= By.id("newLogonButton");
	
	
	public HubLoginPage enterUserName(String uname) {
		sendtext(username, WaitStrategy.PRESENT, uname, "username");
		return this;
	}
	
	public HubLoginPage enterPassword(String passwor) {
		sendtext(password, WaitStrategy.PRESENT, passwor, "password");
		return this;
	}
	
	public HubHomePage clickLoginButton() {
		click(loginbutton, WaitStrategy.CLICKABLE, "loginbtn");
		return new HubHomePage();
	}
}
