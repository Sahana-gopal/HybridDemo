package com.initbanking.utilities;


import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.initbanking.testcases.BaseClass;
import com.initbanking.utilities.Reporting;

public class Listeners extends BaseClass implements ITestListener{
    
	ExtentTest test;
	ExtentReports extent= Reporting.config();
	
	
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		
		//test.fail(result.getThrowable());
		WebDriver driver=null;
		String testMethodName=result.getMethod().getMethodName();
		
		
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e1) {
			
		}
		
		
		try {
			getScreenshotPath(testMethodName, driver);
		} catch (Exception e) {
			
		
		}

	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		ExtentTest test = extent.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	}

}




