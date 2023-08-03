package com.test;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.base.BaseTest;
import com.base.Constants;
import com.page.OrangeHRM_page;
import com.reports.ReportTestManager;
import com.reports.TestListener;

@Listeners(TestListener.class)

public class OrangeHRM_Login_Test extends BaseTest{
	

	
	
	@Test(testName = "Orange HRM", description = "TC - 1")
	public void loginTest() throws InterruptedException {
		ReportTestManager.logText("Log in test for - Orange HRM");
		
		driver.get(Constants.ORANGE_HRM);
		Thread.sleep(500);
		
		OrangeHRM_page hrm = new OrangeHRM_page(driver);
		
		hrm.doLogin();
		hrm.validateLandingPage();				
		
	}

}
