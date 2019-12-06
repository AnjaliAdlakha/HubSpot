package com.qa.hubspot.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.util.TimeUtil;

public class LoginPage extends BasePage {

	@FindBy(id = "username")
	WebElement emailId;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(id = "loginBtn")
	WebElement loginButton;

	@FindBy(linkText = "Sign up")
	WebElement signUpLink;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean verifySigupLinkDisplayed() {
		return signUpLink.isDisplayed();
	}

   public HomePage doLogin(String username, String pwd){
		
		System.out.println("credentials:" + username + "/" + pwd);
		
		emailId.sendKeys(username);
		
		password.sendKeys(pwd);
		
		loginButton.click();
		
		 TimeUtil.mediumWait();
		return new HomePage(driver);
		
	
	}

}