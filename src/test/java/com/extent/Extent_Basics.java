package com.extent;

import java.security.PublicKey;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extent_Basics {
	
	//Create ExtentReports and attached report
	ExtentSparkReporter spark = new ExtentSparkReporter("ExtentReports.html");
	ExtentReports extent = new ExtentReports();

	@Test 
	public void f1() {
		
		//For author name test name and browser name detail's
		ExtentTest test1= extent.createTest("Launch Browser & Website").assignAuthor("Shihab Ahmed")
				.assignCategory("Smoke Test").assignDevice("Google Chrome");
		//for user log test
		test1.log(Status.PASS, "Launch Browser & Website");
		//for user pass test
		test1.pass("User Launced Website Varified");

	}
    
	@Test 
	public void f2() {
		ExtentTest test1= extent.createTest(" Varify Login").assignAuthor("Shihab Ahmed")
				.assignCategory("Sanity Test").assignDevice("Safari");
        //For user Detail's
		test1.info("  Alert Displaying");
		test1.pass("User Loged into application");
		test1.warning("Reset password alart displaying");//FOr warning;
		


	}
	
	@Test 
	public  void f3() {
		ExtentTest test1= extent.createTest("Varify Dashboard").assignAuthor("Shihab Ahmed")
				.assignCategory("Business Test").assignDevice("Firefox Driver");
		test1.skip("varify dashboard skipping");//For skip test; 


	}

	@Test
	public  void f4() {
		ExtentTest test1= extent.createTest("Varify user send email from test application").assignAuthor("Shihab Ahmed")
				.assignCategory("Smoke Test").assignDevice("Edge ");
		test1.fail("Unable to load reports due to server fail");// If any test case fail;


	}
	
	@Test 
	public  void f5() {
		//For author name test naem and browser name detail's
		ExtentTest test1= extent.createTest("Varify LogOut").assignAuthor("Shihab Ahmed")
				.assignCategory("Smoke Test").assignDevice("Opera");
		test1.pass("LogOut is succussful");

	}
	
	@BeforeTest
	public  void beforeTest() {
		
		extent.attachReporter(spark);

	}
	
	@AfterTest
	public void afterTest() {
		extent.flush();//THis is most important for generate html report if we don't give this we don't get report;
	}
	
	
}
