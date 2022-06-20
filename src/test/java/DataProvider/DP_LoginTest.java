package DataProvider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class DP_LoginTest {

	private static WebDriver driver;

	@BeforeTest  
	public static void beforeTest() {
        
		//generate a htmll report this location
		ExtentSparkReporter spark = new ExtentSparkReporter("target/DP_LoginTest.html");
		//Create ExtentReports and attached report
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(spark);

		//create google search
		ExtentTest test1= extent.createTest("Google search test One")
				.assignAuthor("Shihab Ahmed")
				.assignCategory("Smoke Test")
				.assignDevice("Google Chrome");
		//extent browser info
		test1.info("Open Chrome Driver");


		System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://timf.imikrof.com");
		test1.pass("chrome driver successful done");
	}



	@Test (dataProvider = "LoginData")
	public static void Validation(String DP_Email, String DP_Pass) //string email, password pass korbe 
	{
		ExtentReports extent = new ExtentReports();

		ExtentTest test2= extent.createTest("User E-mail validation")
				.assignAuthor("Shimul")
				.assignCategory("Sanity Test")
				.assignDevice("Firefox");
		//extent info
		test2.info("This is user Email Address");
		//extent fail report
		test2.log(Status.FAIL, "User Input wrong email");
		WebElement Username=driver.findElement(By.name("user_name"));
		//extent info clear email report 
		test2.log(Status.INFO, "User Clear email");
		Username.clear();
		//jehetu amra string e call korchi tai eikhane email dite hobe naaaa
		Username.sendKeys(DP_Email);


		//user password
		ExtentTest test3= extent.createTest("User password validation")
				.assignAuthor("Asmin")
				.assignCategory("Regression Test")
				.assignDevice("Edge");
		//extent warning
		test3.log(Status.WARNING, "Please give valid password");
		//extent info
		test3.log(Status.INFO, "User type valid pass");
		WebElement Password=driver.findElement(By.name("password"));
		Password.clear();
		//extent pass 
		test3.log(Status.PASS, "User pass is valid");
		//jehetu amra string e call korchi tai eikhane pass dite hobe naaaa
		Password.sendKeys(DP_Pass);

		//user password
		ExtentTest test4= extent.createTest("User Click validation")
				.assignAuthor("Asmin")
				.assignCategory("Functional Test")
				.assignDevice("Opera");

		test4.log(Status.INFO, "User Click valid");
		//click for login Imikrof
		test4.log(Status.PASS, "User click ID is valid");
		WebElement Login=driver.findElement(By.xpath("/html/body/section/div/div/div[3]/div/div[3]/form/div/div[3]/input"));
		Login.click();

		//this content for generate html report 
		extent.flush();

	}

	@AfterTest
	public void afterTest() {


		driver.quit();

	}

	//amder onk somoy onk mail diye varification korte hoy alada alada mail use na kore eivabe use korle 
	//eksathe onk mail diye differene vabe check korbe;
	@DataProvider(name="LoginData")
	public Object [][] data(){

		Object [][] data= new Object[3][2];

		//set 1
		data[0][0]="mail1@gmail.com";
		data[0][1]="12345";

		//set 2
		data[1][0]="mail2@gmail.com";
		data[1][1]="12345";

		//set 3
		data[2][0]="mail3@gmail.com";
		data[2][1]="12345";

		return data;
	}


}
