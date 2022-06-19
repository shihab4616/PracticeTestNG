package com.extent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Extent_Screenshot {
	public static WebDriver driver;
	
	public static void main(String[] args) {
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("target/extent_Log.html");
		extent.attachReporter(spark);
		
		//For Browser
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.google.com");
		
		//For ScreenShot any report;
		extent
		.createTest("ScreenShot Test-1", "This is for attaching screenshot to the report")
		.info("This is info message");

		extent.flush();

	}
}
