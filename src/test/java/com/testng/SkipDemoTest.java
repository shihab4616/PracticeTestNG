package com.testng;

 
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class SkipDemoTest {
	
	@BeforeGroups
	public void BeforeClass() 
	{
		System.out.println("This code RUn Before Class");
	}
	
	  
	
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
