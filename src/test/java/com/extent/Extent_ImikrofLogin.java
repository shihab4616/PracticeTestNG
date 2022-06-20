package com.extent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extent_ImikrofLogin {

	private static WebDriver driver;

	@BeforeTest  
	public static void beforeTest() {

		ExtentSparkReporter spark = new ExtentSparkReporter("target/Extent_ImikrofLogin.html");
		//Create ExtentReports and attached report
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(spark);

		//create google search
		ExtentTest test1= extent.createTest("Google search test One")
				.assignAuthor("Shihab Ahmed")
				.assignCategory("Smoke Test")
				.assignDevice("Google Chrome");
		//extent browser info
		test1.info("Open Chrome Driver");


		System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://timf.imikrof.com");
		test1.pass("chrome driver successful done");
	}



	@Test
	public static void Validation() {
		ExtentReports extent = new ExtentReports();
		
		ExtentTest test2= extent.createTest("User E-mail validation")
				.assignAuthor("Shimul")
				.assignCategory("Sanity Test")
				.assignDevice("Firefox");
		//extent info
		test2.info("This is user Email Address");
		//extent fail report
		test2.log(Status.FAIL, "User Input wrong email");
		WebElement Username=driver.findElement(By.name("user_name"));
		//extent info clear email report 
		test2.log(Status.INFO, "User Clear email");
		Username.clear();
		//extent user send valid email
		Username.sendKeys("imikrof");


		//user password
		ExtentTest test3= extent.createTest("User password validation")
				.assignAuthor("Asmin")
				.assignCategory("Regression Test")
				.assignDevice("Edge");
		//extent warning
		test3.log(Status.WARNING, "Please give valid password");
		//extent info
		test3.log(Status.INFO, "User type valid pass");
		WebElement Password=driver.findElement(By.name("password"));
		Password.clear();
		//extent pass 
		test3.log(Status.PASS, "User pass is valid");
		Password.sendKeys("##imikrof@2021");

		//user password
		ExtentTest test4= extent.createTest("User Click validation")
				.assignAuthor("Asmin")
				.assignCategory("Functional Test")
				.assignDevice("Opera");

		test4.log(Status.INFO, "User Click valid");
		//click for login Imikrof
		test4.log(Status.PASS, "User click ID is valid");
		WebElement Login=driver.findElement(By.xpath("/html/body/section/div/div/div[3]/div/div[3]/form/div/div[3]/input"));
		Login.click();
		
		//this content for generate html report 
		extent.flush();

	}

	@AfterTest
	public void afterTest() {
		
		
		driver.quit();

}


}