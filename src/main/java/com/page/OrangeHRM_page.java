package com.page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.base.BasePage;

public class OrangeHRM_page extends BasePage{
	
	public OrangeHRM_page(WebDriver driver){
		super(driver);
	}
	
	/*
	 * Elements
	 */
	
	By userName = By.xpath("//input[@name='username']");
	By pass = By.xpath("//input[@name='password']");
	By logInBtn = By.xpath("//button[@type='submit']");
	By mainMenu = By.xpath("//ul[@class='oxd-main-menu']/li");
	
	
	
	/*
	 * Methods
	 */
	public void doLogin() throws InterruptedException {
		
		driver.findElement(userName).sendKeys("Admin");
		Thread.sleep(500);
		driver.findElement(pass).sendKeys("admin123");
		Thread.sleep(500);
		driver.findElement(logInBtn).click();
		
	}
	
	
	public void validateLandingPage() {
		String actualTitle = driver.getTitle();
		System.out.println("Title: " + actualTitle);
		
		String exteptedTitle = "N?A";															// OrangeHRM
		doSoftAssert(actualTitle, exteptedTitle, "Title miss-matched");
		//doHardAssert(actualTitle, exteptedTitle, "Title miss-matched");
				
		
	}
	
	public void getAllMenuOptions() {
		
		List<WebElement> menuOptions = driver.findElements(mainMenu);
		List<String> optionsList = new ArrayList<String>();
		
		for(WebElement e: menuOptions) {
			String option = e.getText();
			if (!option.isEmpty()) {
				optionsList.add(option);
			}
			System.out.println(option);
		}
		System.out.println("\nAll menus: " + optionsList);
		
		if (menuOptions.size() == 0) {
			Assert.fail("Empty list returned");
		}
		
		
		
		
	}

}
