package com.hub.testcases;
import java.util.Map;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.hub.annotations.FrameworkAnnotations;
import com.hub.pages.HubHomePage;
import com.hub.pages.HubLoginPage;
import com.hub.reports.ExtentManager;
import com.hub.reports.ExtentReport;
import com.hub.utils.DataProviderUtils;

/**
 * <P>Class hold the Login page related test cases </P>
 * <P>Class extends the base test </P>
 * 25-Jan-2022
 * @author satheesh.c
 * @Version 1.0
 */
public class HUBLoginTests extends BaseTest{

	@FrameworkAnnotations(author = { "Satheesh" }, category = { "Smoke", "Regression" })
	@Test
	public void loginTest(Map<String, String> data) {
		
		HubLoginPage loginpage=new HubLoginPage();
		HubHomePage homepage= new HubHomePage();
		
		String title=loginpage.enterUserName(data.get("username"))
				.enterPassword(data.get("password"))
				.clickLoginButton()
				.getPageTitle();
		Assertions.assertThat(title).isEqualTo("HungerRush HUB | Dashboard");
		homepage.HubLoggOff();
		
	}	

}
