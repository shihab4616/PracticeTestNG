package com.testng;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

 
public class OrangeHRM {
	
	WebDriver driver;
	WebDriver element;
	
	@Test
	public  void LaunchApp() {
		
     
        WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");	
		
	}
	
	@Test
	public  void EnterLoginDetails() {
		
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
	
	@Test
	public void VarifyLogin() {
		
		System.out.println(driver.findElement(By.id("welcome")).isDisplayed());
		System.out.println(element.getTitle());
		driver.quit();
	}
	
	

}
