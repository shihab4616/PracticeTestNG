package com.testng;

import org.testng.annotations.Test;

public class PrirotyTestNG {
	
	
	//Priority use na korle login pore success hoy but priority use korle login age success hoy 
	//amra jodi a,b,c use kori tahole a er kaj age hobe erpor b er por c 
	
	@Test (priority=1, description="This is a login Test") 
	public void LoginTest()
	{
		System.out.println("Login Test successful");
	}
	
	//priority use korar age dekha jay logout age success hoy but priority use korle Logout pore ar Login age success hoy
	
	@Test (priority=2, description="This is a LogOut Test")
	public void LogOutTest()
	{
		System.out.println("LogOut Test successful");
	}

}
