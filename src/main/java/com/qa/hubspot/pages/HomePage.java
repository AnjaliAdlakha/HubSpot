package com.qa.hubspot.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.util.TimeUtil;

public class HomePage extends BasePage{
	
	
	@FindBy(xpath = "//h1[@class='private-page__title']")
	WebElement homePageHeader;
	
	@FindBy(xpath = "//span[@class='account-name ']")
	WebElement accountName;

	
	
		public HomePage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}

	
	
		public String getHomePageTitle() {
			return driver.getTitle();
		}
	
	public String getHomePageHeaderText() {
		
		return homePageHeader.getText();
		
	}
		
		public boolean verifyHomePageHeader() {
			
			return homePageHeader.isDisplayed();
		}
		
		
		public String getAccountNameValue() {
			
			return accountName.getText();
			
		}
		

		public boolean verifyAccountNameValue() {
			
			return accountName.isDisplayed();
			
		}
		
		
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

}
