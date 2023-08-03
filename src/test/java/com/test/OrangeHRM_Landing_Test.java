package com.test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.base.BaseTest;
import com.base.Constants;
import com.page.OrangeHRM_page;
import com.reports.ReportTestManager;
import com.reports.TestListener;

@Listeners(TestListener.class)

public class OrangeHRM_Landing_Test extends BaseTest {
	
	
	
	
	
	@Test(testName = "", description = "")
	public void orangeHRM_LandingPage_Test() throws InterruptedException {
		
		ReportTestManager.logText("Getting Orange HRM Landing Page MENU Options.");
		
		driver.get(Constants.ORANGE_HRM);
		Thread.sleep(1000);
		System.out.println("Title: " + driver.getTitle());
		
		
		OrangeHRM_page hrm = new OrangeHRM_page(driver);
		
		if (driver.getTitle().equals("OrangeHRM")) {
			hrm.doLogin();
		}else {
			Assert.fail("\nWrong page loaded");
		}
		Thread.sleep(1000);
		
		hrm.getAllMenuOptions();
		
		
	}

}
