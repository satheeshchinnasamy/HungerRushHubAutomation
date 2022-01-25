package com.hub.pages;

import org.openqa.selenium.By;

import com.hub.enums.WaitStrategy;
/**
 * <P>Class holds the Homepage methods and elements</P>
 * 25-Jan-2022
 * @author satheesh.c
 * @Version 1.0
 */
public class HubHomePage extends BasePage {
	
	
	private final By logoff= By.id("logout");
	private final By dashboard= By.id("dashAnchor");
	private final By reports= By.id("rptAnchor");
	private final By manage= By.id("manageAnchor");
	private final By people= By.id("peopleAnchor");
	private final By communicate= By.id("communicateAnchor");
	private final By inventory= By.id("invAnchor");
	private final By loyalty= By.id("lyltyAnchor");
	private final By marketing= By.id("marketingAnchor");
	private final By display= By.id("displayAnchor");
	private final By hungerrushonly= By.id("sysOnlyAnchor");
	
	public HubLoginPage HubLoggOff() {
		click(logoff, WaitStrategy.CLICKABLE, "logoffbtn");
		
		return new HubLoginPage();
	}
	
	public HubManagePage hambergerMenuClicking() {
		click(manage, WaitStrategy.CLICKABLE, "Manage");
		return new HubManagePage();
	}
	
	public String getPageTitle() {
		return pageTitle();
	}
}
