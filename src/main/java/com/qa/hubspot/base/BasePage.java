package com.qa.hubspot.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.hubspot.util.TimeUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author anjali
 *
 */


public class BasePage {
	
	public WebDriver driver;
	public Properties prop;

	/**
	 * This method is used to Initialize the webdriver
	 * @param prop
	 * @return driver
	 * 
	 */
	public WebDriver initialize_driver(Properties prop) {
		
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver","C:\\Users\\anjali\\Downloads\\chromedriver_win32 (6)\\chromedriver.exe");	
//WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		
		else if(browserName.equals("firefox")) {
			
			WebDriverManager.firefoxdriver().setup();	
			driver = new FirefoxDriver();
		
		}
		
		else {
			System.out.println("Browser" + browserName + " is defined in properties file, please give the correct browser name");
		}
	
	
	driver.manage().deleteAllCookies();
	driver.manage().window().fullscreen();
	driver.get(prop.getProperty("url"));
     TimeUtil.mediumWait();
	
	
	return driver;
	
	}
	
	
	/**
	 * This method is used to Initialize the properties and it will return properties reference
	 * @return prop
	 * 
	 * 
	 */
public Properties initialize_Properties() {
		
		prop = new Properties();
	
		try {
			FileInputStream ip = new FileInputStream("C:\\Users\\anjali\\eclipse-workspace\\PageObjectModel\\src\\main\\java\\com\\qa\\hubspot\\configuration\\config.properties");
		
		
			try {
				prop.load(ip);
			} catch (IOException e) {
				e.printStackTrace();
			}
			} catch (FileNotFoundException e) {
				
				
				e.printStackTrace();
			}	
		
		return prop;
}
}
