package com.hub.pages;

import org.openqa.selenium.By;

import com.hub.enums.WaitStrategy;

/**
 * <P>Class holds Coupons page method and element</P>
 * 25-Jan-2022
 * @author satheesh.c
 * @Version 1.0
 */
public class ManageCouponPage extends BasePage{

	private final By addnewcoupon=By.id("newCpn");
	private final By onlineseq=By.id("onlineSeq");
	private final By firstonlineord=By.id("firstOOCpn");
	private final By storedropdown=By.xpath("//*[@id='storesDD']");
	private final By couponscope=By.xpath("//*[@id='divCpnScopes']//following::span[contains(text(),'Order')]");
	private final By coupontype=By.xpath("//*[@id='divCpnTypes']//following::span[contains(text(),'Amt Off')]");
	private final By name=By.xpath("//*[@id='Cpnname']");
	private final By buttonname=By.xpath("//*[@id='CpnBtnName']");
	private final By receiptname=By.id("Cpnname");
	private final By description=By.id("Cpnname");
	private final By addBtn=By.xpath("/html/body/div[3]/div[3]/div/button/span");
	private final By successtoaster=By.id("ItemsPopup");
	private final By createdcoupon=By.xpath("//*[@id='tblCpns']//following::td[contains(text(),'AutomationTestCoupon')]");
	



	public ManageCouponPage selectStore(String storename) {
		selectOptions(storedropdown, WaitStrategy.VISIBLE, storename);
		return this;
	}

	public ManageCouponPage clickAddCouponBtn() {
		click(addnewcoupon, WaitStrategy.CLICKABLE, "Add new coupon btn");
		return this;
	}

	public ManageCouponPage createNewCoupon() {
		click(couponscope, WaitStrategy.VISIBLE, "couponscope");
		click(coupontype, WaitStrategy.VISIBLE, "coupontype");
		sendtext(name, WaitStrategy.PRESENT, "AutomationTestCoupon", "Couponname");
		click(buttonname, WaitStrategy.PRESENT, null);
		click(addBtn, WaitStrategy.PRESENT, "Add Button");
		return this;
	}

	public String getSuccessMessage() throws InterruptedException {
		Thread.sleep(3000);
		return getToasterMessage(successtoaster, WaitStrategy.PRESENT);
	}
	
	public ManageCouponPage closeToaster() {
		popupclose(WaitStrategy.CLICKABLE);
		return this;
	}
	
	public String getCouponName() {
		return getElementTex(createdcoupon, WaitStrategy.VISIBLE);
	}

	public String getPageTitle() { 
		return pageTitle();
	}

	


}
