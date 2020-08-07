package com.initbanking.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.initbanking.testcases.BaseClass;

public class LoginPage extends BaseClass {

	// By username=By.linkText("Login");
	WebDriver ldriver;

	public LoginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	// @FindBy(linkText="Login")
	// WebElement loginclick;
	@FindBy(xpath = "/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input")
	WebElement username;

	@FindBy(xpath = "/html/body/div[2]/div/div/div/div/div[2]/div/form/div[2]/input")
	WebElement password;
	@FindBy(xpath = "/html/body/div[2]/div/div/div/div/div[2]/div/form/div[3]")
	WebElement LoginButton;

	// public void clicklogin() {
	// loginclick.click();
	// }
	public void setusername(String uid) {
		username.sendKeys(uid);
	}

	public void setpassword(String pwd) {
		password.sendKeys(pwd);
	}

	public void clicksubmit() {
		LoginButton.click();
	}

}
