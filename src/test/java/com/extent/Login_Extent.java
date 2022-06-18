package com.extent;

import java.security.Key;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Login_Extent {
	
	private static WebDriver driver;

	public static void main(String[] args) {
		
		
		ExtentSparkReporter spark = new ExtentSparkReporter("ExtentReports.html");
		
		//Create ExtentReports and attached report
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(spark);
		
		//create google search
		ExtentTest test1= extent.createTest("Google search test One","THis is a test to validate google search functiolality");
	
		System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		test1.log(Status.INFO, "Starting test case");
		driver.get("https://google.com");
		test1.pass("Navigated to google.com");
		
		driver.findElement(By.name("q")).sendKeys("Automation");
		test1.pass("Entered text in search Box");
		
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		test1.pass("pressed keyboard enter key");
		
		driver.close();
		driver.quit();
		test1.pass("Close the browser");
		
		test1.info("Test Completed");
		
		//Calling flush write everything to the log fiel
		extent.flush();
		
	
	}
}
