package com.testng;

import org.testng.annotations.Test;

import Common.CommonDataSetup;

@Test (groups= "User-registration")
public class GrpupsDemoTest2  extends CommonDataSetup{
	
	
	@Test (priority=1, groups="regression")
	public void aTest1() 
	{
		System.out.println("test1");
	}
	
	
	@Test (priority=2, groups="regression")
	public void bTest2()
	{
		System.out.println("test2");
	}
	
	
	@Test (groups={"regression", "abc"})
	public void bTest3()
	{
		System.out.println("test3");
	}
	
	
	@Test (groups="abc")
	public void bTest4()
	{
		System.out.println("test4");
	}
	

}
