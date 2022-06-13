package com.TestNG_Webportal;

import org.testng.annotations.Test;

@Test (groups= "User-registration")
public class GrpupsDemoTest {
	
	
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
