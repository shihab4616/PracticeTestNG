package com.testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyTitleTest {
	
	WebDriver driver;
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
		Assert.assertEquals(actualtitle,expectedtitle);
		driver.quit();
	}

}
