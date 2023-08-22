package com.base;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.IOException;

public class BaseTest {

    public static WebDriver driver;

    @BeforeTest
    public void setup(){
    	
    	ChromeOptions options = new ChromeOptions();
    	options.setBrowserVersion("stable");
    	options.addArguments("--remote-allow-origins=*", "--ignore-certificate-errors");
        driver = new ChromeDriver(options);
        driver.manage().deleteAllCookies();

    }
    
    public WebDriver getDriver() {
    	return driver;
    }

    @AfterTest
    public void tearDown(){
    	try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //driver.close();
    }

    public static String takeScreenShot(String fileName){
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File("src/test/resources/screenShots/" + fileName);                        //new File("./ScreenShots/" + fileName);         - for project directory
        try {
            FileHandler.copy(sourceFile, destFile);
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("Screenshot saved successfully");

        return destFile.getAbsoluteFile().toString();                                                          // we need the destination path as we need to pass it to the report

    }
}
