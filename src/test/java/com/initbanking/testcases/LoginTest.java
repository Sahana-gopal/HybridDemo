package com.initbanking.testcases;

import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.initbanking.pageobjects.LoginPage;


public class LoginTest extends BaseClass {

	public static Logger Log = LogManager.getLogger(LoginTest.class.getName());

	@Test
	public void loginTest() throws Exception {

		Log.info("URL is opened");

		LoginPage lp = new LoginPage(driver);
		// lp.clicklogin();
		lp.setusername(username);
		Log.info("username entered");
		lp.setpassword(password);
		Log.info("password entered");
		Thread.sleep(3000);
		lp.clicksubmit();

		if (driver.getTitle().equals(
				"Online Shopping Site for Mobiles, Electronics, Grocery, Lifestyle, Books & More. Best Offers!")) {
			Assert.assertTrue(true);
			Log.info("test case passed");
		} else {
			Assert.assertTrue(false);
			Log.info("Test case failed");
		}
	}

}
