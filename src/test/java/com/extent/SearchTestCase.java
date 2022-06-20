package com.extent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchTestCase {
	WebDriver driver;
	ExtentReports extent = new ExtentReports();
	ExtentSparkReporter spark = new ExtentSparkReporter("target/SearchTest.html");


	@BeforeTest
	public void browserLaunch() {
		spark.config().setTheme(Theme.STANDARD);
		spark.config().setDocumentTitle("MyReport");
		extent.attachReporter(spark);

		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://www.google.com");

	}

	@Test
	public void Extent_TC_001() {

		//for title extent test case
		ExtentTest test1 = extent.createTest("Varify My page title")
				.assignAuthor("Shihab")
				.assignAuthor("AsminKhan")
				.assignCategory("Functional Test Case")
				.assignDevice("Chrome");

		test1.info("i am capturing the page title");
		String pagetitle=driver.getTitle();


		//use condition for page title matched or not;
		test1.info("capture the title as:"+pagetitle);
		if(pagetitle.equals("google"))
		{
			test1.pass("page title is varified: Title captured") ;
		}
		else
		{
			test1.fail("paged title is not mathched expected results:");
		}		

	}

	@Test
	public void Extent_TC_002() {
		ExtentTest test2 = extent.createTest("Varify User Email")
				.assignAuthor("Rashiduzzman")
				.assignAuthor("Shihab")
				.assignCategory("Smoke test")
				.assignDevice("Edge");

		test2.log(Status.PASS, "You are success to type EMail");
		test2.info("Email type Success ");
	}

	@Test
	public void Extent_TC_003() {
		ExtentTest test3 = extent.createTest("Varify LogIn Password")
				.assignAuthor("Asmin Khan")
				.assignCategory("Regression test")
				.assignDevice("FireFox");

		test3.log(Status.SKIP, "You must be type your password");
		test3.info("Your pass is wrong");
	}


	@AfterTest
	public void afterTest() {
		extent.flush();
		driver.quit();
	}

}
