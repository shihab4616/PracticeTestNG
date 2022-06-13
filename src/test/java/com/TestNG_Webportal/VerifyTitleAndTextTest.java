package com.TestNG_Webportal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyTitleAndTextTest {
	
	WebDriver driver;
	@Test
	public void textTest()  
	{
		//This code for text varification
		//ami je lekhata expected e diyechi seta jodi actual er sathe mile jay thle thik ache otherwise vul
		String exceptedtext= "Search";
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.ebay.com/");
		String actualtext= driver.findElement(By.xpath("//*[@id=\"gh-btn\"]")).getAttribute("Value");
		System.out.println("Varifying text");
		Assert.assertEquals(actualtext, exceptedtext, "Text varification failed" );
		driver.quit();
	}
	
	@Test
	public void titleTest() 
	{
		//Expected title hobe eita (Electronics, Cars, Fashion, Collectibles & More | eBay) but ami vul diye test kore dekhlam fail ase
		//Right title ta dile ar fail asbe naa
		//This is for assertion 
		String expectedtitle= "jhggggggggggggggg"; 
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.ebay.com/");
		String actualtitle = driver.getTitle();
		System.out.println("Varifying title");
		Assert.assertEquals(actualtitle,expectedtitle);
		driver.quit();
	}

}
