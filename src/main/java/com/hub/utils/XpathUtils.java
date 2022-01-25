package com.hub.utils;
/**
 * <P>Handles the dynamic xpath to avoid repeated codes for dynamic elements</P>
 * 25-Jan-2022
 * @author satheesh.c
 * @Version 1.0
 */
public class XpathUtils {

	/**
	 * Private constructor to avoid external instantiation
	 */
	private XpathUtils() {
		
	}
	
	public static String getXpath(String xpath, String replacetext) {
		return xpath.replace("%replaceable%", replacetext);
	}
	
}
