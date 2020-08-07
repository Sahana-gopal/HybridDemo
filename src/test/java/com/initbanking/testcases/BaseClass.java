package com.initbanking.testcases;

import java.io.File;


import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.initbanking.utilities.ReadConfig;

public class BaseClass {

	ReadConfig readconfig = new ReadConfig();

	public String baseURL = readconfig.getbaseURL();
	public String username = readconfig.getusername();
	public String password = readconfig.getpassword();
	public WebDriver driver;

	@Parameters("browser")
	@BeforeTest
	public WebDriver setup(String br) {

		if (br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Sahana\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");			
			driver = new ChromeDriver();
			driver.get(baseURL);
		} else if (br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\Sahana\\Downloads\\geckodriver-v0.26.0-win64 (1)\\geckodriver.exe");
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		return driver;
	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}
	
	
	public void getScreenshotPath(String testCaseName, WebDriver driver) throws Exception {
		
		 
	TakesScreenshot	ts = (TakesScreenshot)driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	String destinationfile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
	
	FileUtils.copyFile(source, new File(destinationfile));
		 
	}
}
