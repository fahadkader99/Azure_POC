package com.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BasePage {
	
	protected WebDriver driver;
	private Actions actions;
	private SoftAssert softAssert;
	
	public BasePage(WebDriver adriver){
		this.driver = adriver;
		actions = new Actions(adriver);
		softAssert = new SoftAssert();
		
	}
	
	
	public void doSoftAssert(String actual, String expected, String message) {
		softAssert.assertEquals(actual.equals(expected), message);
	}
	
	public void doHardAssert(String actual, String expected, String message) {
		Assert.assertEquals(actual.equals(expected), message);
	}
	
	

}
