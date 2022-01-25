package com.hub.listener;

import java.util.Arrays;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.hub.annotations.FrameworkAnnotations;
import com.hub.reports.ExtentLogger;
import com.hub.reports.ExtentReport;
/**
 * <P>Class listen test execution and invoke the methods accordingly</P>
 * <P>Class provides the implementation to the two interfaces</P>
 * 24-Jan-2022
 * @author satheesh.c
 * @Version 1.0
 */

public class ListenerClass implements ITestListener, ISuiteListener{
	
	
	public void onStart(ISuite arg0) {
		try {
			ExtentReport.initReports();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void onFinish(ISuite arg0) {
		ExtentReport.flushReports();
	}

	public void onFinish(ITestContext arg0) {
	}

	public void onStart(ITestContext arg0) {
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
	}

	

	
	public void onTestStart(ITestResult m) {
		ExtentReport.createTest(m.getMethod().getMethodName());
		ExtentReport.addAuthors(m.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotations.class).author());
		ExtentReport.addCategories(m.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotations.class).category());
	}

	public void onTestSuccess(ITestResult result) {
		ExtentLogger.pass(result.getMethod().getMethodName()+ " is passed");
	}

	public void onTestFailure(ITestResult result) {
		ExtentLogger.fail(result.getMethod().getMethodName()+ " is failed");
		try {
			ExtentLogger.fail(result.getMethod().getMethodName()+ " is failed", true);
			ExtentLogger.fail(result.getThrowable().toString());
			ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void onTestSkipped(ITestResult result) {
		ExtentLogger.skip(result.getMethod().getMethodName()+ " is skipped");
	}

}
