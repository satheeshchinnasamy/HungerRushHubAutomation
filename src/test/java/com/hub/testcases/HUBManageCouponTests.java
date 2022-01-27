package com.hub.testcases;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.hub.annotations.FrameworkAnnotations;
import com.hub.pages.HubHomePage;
import com.hub.pages.HubLoginPage;
import com.hub.pages.HubManagePage;
import com.hub.pages.ManageCouponPage;
import com.hub.reports.ExtentManager;

/**
 * <P>Class hold the Manage-Coupons page related test cases </P>
 * <P>Class extends the base test </P>
 * 25-Jan-2022
 * @author satheesh.c
 * @Version 1.0
 */

public class HUBManageCouponTests extends BaseTest {
	HubLoginPage loginpage=new HubLoginPage();
	HubHomePage homepage= new HubHomePage();
	HubManagePage managepage=new HubManagePage();
	ManageCouponPage couponpage=new ManageCouponPage();

	@FrameworkAnnotations(author = { "Satheesh" }, category = { "Smoke", "Regression" })
	@Test
	public void couponsPageTitle(Map<String, String> data) {

		loginpage.enterUserName("CompanyAdminXBOTest@hungerrush.com")
		.enterPassword("Test@123")
		.clickLoginButton();
		String coupontitle=homepage.hambergerMenuClicking()
				.clickingManageOptions("Coupon")
				.getPageTitle();
		Assertions.assertThat(coupontitle).isEqualTo("HungerRush HUB | Coupon Management");

	}

	@FrameworkAnnotations(author = { "Satheesh" }, category = { "Smoke", "Regression" })
	@Test
	public void addCoupon(Map<String, String> data) throws InterruptedException {
		loginpage.login("satheesh.c@hungerrush.com", "Rush@12");
		String successmessage=homepage.hambergerMenuClicking().clickingManageOptions("Coupon")
				.selectStore("DevOps")
				.clickAddCouponBtn()
				.createNewCoupon()
				.getSuccessMessage();
		Assertions.assertThat(successmessage).isEqualTo("Coupon added successfully!");
		couponpage.closeToaster();
		String coupon=couponpage.getCouponName();
		Assertions.assertThat(coupon).isEqualTo("AutomationTestCoupon");

	}
}
