package com.extent;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.github.dockerjava.api.model.Info;

public class extent_Log {

	public static void main(String[] args) {

		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("target/extent_Log.html");
		extent.attachReporter(spark);


		//For Extent all log uses (Priroty wise log report);

		extent //this extent is called by ExtentReports (extent)
		.createTest("For all log test:")
		.log(Status.INFO, "THis is for info")//5th priority
		.log(Status.FAIL, "This is for failed")//1st proroty
		.log(Status.SKIP, "THis is for skip")//2nd priroty
		.log(Status.WARNING, "THis is for warning")//3rd priroty
		.log(Status.PASS, "THis is for pass")//4th priority


		//For italic, bold, Heading  text(same as html);
		.log(Status.INFO, "<h1>This text for Heading</h1>")
		.log(Status.INFO, "<i>THis text for italic</i>")
		.log(Status.INFO, "<b>THis text for Bold</b>");

		//List and Order wise data insert array;

		//I don't complete Orderlist i will try to at this home (https://www.youtube.com/watch?v=79irFF_yJV8)video after 16 min


		//For Text heighlight;
		extent 
		.createTest("This test for Heighlight text")
		.info(MarkupHelper.createLabel("This is a heighlight message", ExtentColor.RED));
		extent.flush();
	}

}
