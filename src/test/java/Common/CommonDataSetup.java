package Common;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class CommonDataSetup {
	
	@BeforeSuite
	public void dataSetup()
	{
		System.out.println("Common Data Setup");
	}
	
	@AfterSuite
	public void dataTeardown()
	{
		System.out.println("Common Data CleanUp");
	}

}
