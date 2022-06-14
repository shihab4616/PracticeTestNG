package com.testng;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Before_AfterTestNG {
	
	//if we use before test this is run after test ( Test shuru hobar age eita run hobe then test case run hobe)
	//amra jodi @Beforeclass use kori tahole calss er age run korbe
	@BeforeTest
	public  void LoginToApplication() {
		
		System.out.println("Login TO Application");	
	}
	
	//If we use after test this is run last (puro test case sesh hobar por eita run hobe)
	@AfterTest
    public  void LogOutFromApplication() {
		
		System.out.println("LogOut From Application");	
	}
	
	
	@Test (priority=1, description="This is a login Test") 
	public void LoginTest()
	{
		System.out.println("Login Test successful");
	}
	

	@Test (priority=2, description="This is a LogOut Test")
	public void LogOutTest()
	{
		System.out.println("LogOut Test successful");
	}

}
