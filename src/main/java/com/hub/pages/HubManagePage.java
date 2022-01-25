package com.hub.pages;

import org.openqa.selenium.By;

import com.hub.enums.WaitStrategy;
import com.hub.utils.XpathUtils;
/**
 * <P>Class having Managepage elements and methods</P>
 * 25-Jan-2022
 * @author satheesh.c
 * @Version 1.0
 */
public class HubManagePage extends BasePage{

	private String manageoptions="//*[@id='manageAnchor']//following::ul//following::*[contains(text(),'%replaceable%')]";

	public ManageCouponPage clickingManageOptions(String manageoptiontext) {
		String xpath=XpathUtils.getXpath(manageoptions, manageoptiontext);
		click(By.xpath(xpath), WaitStrategy.CLICKABLE, manageoptiontext);
		return new ManageCouponPage();
	}


}
