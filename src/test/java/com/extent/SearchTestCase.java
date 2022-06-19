package com.extent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchTestCase {
	 WebDriver driver;
	
	ExtentReports extent = new ExtentReports();
	ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
	
	 
	@BeforeTest
	public void browserLaunch() {
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("MyReport");
		extent.attachReporter(spark);
		
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://www.google.com");
		
	}
	
	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}
	
	@Test
	public void TestCase_001() {
		
		//for title extent test case
		ExtentTest test = extent.createTest("Varify My page title").assignAuthor("Shihab").
				 assignCategory("Functional Test Case").assignDevice("Chrome");
		
		test.info("i am capturing the page title");
		String pagetitle=driver.getTitle();
		
		test.info("capture the title as:"+pagetitle);
		if(pagetitle.equals("google"))
		{
			test.pass("page title is varified: Title captured") ;
		}
		else
		{
			test.fail("paged title is not mathched expected results:");
		}
			
		
	}

}
