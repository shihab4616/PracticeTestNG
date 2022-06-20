package com.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNGLogin {
	
	WebDriver driver;
	WebDriver element;
	
	@Test
	public  void EnterLoginDetails() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123"); 
		driver.findElement(By.id("btnLogin")).click();
		
	}
	
	@Test
	public void NavigateToMyInfo() {
		
		driver.findElement(By.id("menu_pim_viewMyDetails")).click();
	}
	
	
	@Test
	public void VarifyMyInfo() {
		
		System.out.println(driver.findElement(By.id("employee-details")).isDisplayed());
		driver.quit();
	}
	

}
