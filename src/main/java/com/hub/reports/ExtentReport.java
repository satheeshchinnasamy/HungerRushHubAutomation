package com.hub.reports;

import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.hub.constants.FrameworkConstants;
/**
 * <P>Class contains methods to initialize the reports</P>
 * 24-Jan-2022
 * @author satheesh.c
 * @Version 1.0
 */
public final class ExtentReport {
	/*
	 * Private constructor to avoid external instantiation
	 */
	private ExtentReport() {}

	private static ExtentReports extent;

	/**
	 * <P>Method intializing the extent report</p>
	 * 24-Jan-2022
	 * @author satheesh.c
	 * @throws Exception
	 */
	public static void initReports() throws Exception  {
		if(Objects.isNull(extent)) {
			extent=new ExtentReports();
			ExtentSparkReporter spark= new ExtentSparkReporter(FrameworkConstants.getExtentReportPath());
			extent.attachReporter(spark);
			spark.config().setTheme(Theme.STANDARD);
			spark.config().setDocumentTitle("Test Automation");
			spark.config().setReportName("HUB Test Report");
		}
	}
	public static void flushReports() {
		if(Objects.nonNull(extent)) {
			extent.flush();
		}
		ExtentManager.unload();
	}

	public static void createTest(String testcasename) {
		ExtentManager.setExtentTest(extent.createTest(testcasename));

	}
	
	/*
	 * Adding the author to the test cases in the report
	 */
	public static void addAuthors(String[] author) {
		for(String temp: author) {
			ExtentManager.getExtentTest().assignAuthor(temp);
		}
	}
	/*
	 * Adding the categories to the test cases in the report
	 */
	public static void addCategories(String[] categories) {
		for(String temp: categories) {
			ExtentManager.getExtentTest().assignCategory(temp);
		}
	}
}
