package backbase.ReadOperation;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestNGListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.w3c.dom.UserDataHandler;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.IReporter;
import com.relevantcodes.extentreports.LogStatus;

import jdk.internal.org.jline.utils.Log;

public class BaseClass {

	public static WebDriver driver;
	//public static ExtentTest test;
	//public static ExtentReports report;
	
@BeforeClass
public static void setup()
{
	System.setProperty("webdriver.chrome.driver",  System.getProperty("user.dir")+"//driver//chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	LocalDate dateTime = LocalDate.now();
	//report = new ExtentReports(System.getProperty("user.dir")+"//reports//ExtentReportResults.html", true);
	//test = report.startTest("ExtentDemo");
	
	}



@AfterClass
public static void tierDown()
{
	
	driver.quit();

}


}
