package com.hub.constants;

import com.hub.enums.ConfigProperties;
import com.hub.utils.PropertyUtils;
/**
 * <P>Class contains private static final variables and they are used across the framework through getter and setter</P> 
 * <P> All the variables are declared as private and called by getter and setter method<P/>
 * 24-Jan-2022
 * @author satheesh.c
 * @Version 1.0
 */
public final class FrameworkConstants {
	
	/**
	 * Private constructor to avoid external instantiation
	 */
	private FrameworkConstants() {
		
	}
	
	private static final String RESOURCEPATH = System.getProperty("user.dir")+"/src/test/resources";
	private static final String CHROMEDRIVERPATH = RESOURCEPATH + "/executables/chromedriver.exe";
	private static final String GECKODRIVERPATH = RESOURCEPATH + "/executables/geckodriver.exe";
	private static final String CONFIGFILEPATH = RESOURCEPATH + "/config/config.properties";
	private static final String EXTENTREPORTPATH= System.getProperty("user.dir")+"/extent-test-report/";
	private static final String EXCELPATH= RESOURCEPATH + "/excel/testdata.xlsx";
	private static final String DATASHEET= "LOGINDATA";
	

	public static String getExtentReportPath() throws Exception {
		if(PropertyUtils.getValue(ConfigProperties.DYNAMICREPORTS).equalsIgnoreCase("yes")) {
			return EXTENTREPORTPATH+System.currentTimeMillis()+"index.html";
		}else {
			return EXTENTREPORTPATH+ "index.html";
		}
		
	}

	
	private static final int EXPLICITWAIT=10;

	public static String getConfigFilePath() {
		return CONFIGFILEPATH;
	}

	public static String getExcelpath() {
		return EXCELPATH;
	}
	public static String getDatasheet() {
		return DATASHEET;
	}
	public static int getExplicitwait() {
		return EXPLICITWAIT;
	}

	public static String getChromeDriverPath() {
		return CHROMEDRIVERPATH;
	}

	public static String getGeckodriverpath() {
		return GECKODRIVERPATH;
	}
	

}
