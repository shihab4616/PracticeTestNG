package com.testng;

 

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.reporters.HtmlHelper;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.observer.ExtentObserver;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
 
 

public class LoginExtent {
	
	public static WebDriver driver;
 
	//extentreport
	public static ExtentObserver[] htmlReporter;
	public static ExtentReports reports;
	public static ExtentTest test;
	
	 
	@BeforeSuite
	public static void launch_chrome() {
		System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		System.out.println("Before Clss Execute");

	}

	@AfterSuite
	public static void close_chrome()
	{ 
		driver.close();
		System.out.println("After Clss Execute");
	}

	@BeforeTest
	public static void beforeTest() {

		System.out.println("Before Test Execute");	
	}

	@AfterTest
	public static void AfterTest() {

		System.out.println("After Test Execute");	
	}

	@BeforeMethod
	public static void beforeMethod() {

		System.out.println("Before Method Execute");	
	}

	@AfterMethod
	public static void AfterMethod() {

		System.out.println("After Method Execute");	
	}

	@Test (description = "User Email and password Valid")
	public static void Valid_TestCase() {
		
		//Implement extent report
		ExtentSparkReporter HtmlHelper = new ExtentSparkReporter( "./ExtentReports/LoginTest.html");
		reports= new ExtentReports();
		reports.attachReporter(htmlReporter);
		
		//Information added to report
		reports.setSystemInfo("projectName", "HRMOrange");
		reports.setSystemInfo("Module Name", "Login");
		reports.setSystemInfo("Browser", "Chrome");
		reports.setSystemInfo("Test By", "Shihab Ahmed");
		
		
		test= reports.createTest("Login Test");
        //Login Orange HRM webste (User id and password
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		test.log(Status.INFO, "UserName Typing");//for extent report typing usenName
		
		
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		test.log(Status.INFO, "Password Typing");//for extent report typing password
		
		
		driver.findElement(By.id("btnLogin")).click();
		test.log(Status.INFO, "Login Button Click");//for extent report click
		
		System.out.println("Valid Test Case Execute");
		test.log(Status.PASS, "Test Case Executed");//For test case executed
		
		reports.flush();

	}

	
}
