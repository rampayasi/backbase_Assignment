package backbase.Utilties;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.xml.XmlSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Reporting extends TestListenerAdapter{
	
	
	public void onStart(ITestContext testContect)
	{
		System.out.println("***Test Suite***" + testContect.getName() +"**Started***");
	}
	
	public void onTestStart(ITestResult tr)
	{
		ExtentTestManager.startTest(tr.getMethod().getMethodName());
	}
	
	public void onTestSuccess(ITestResult tr)
	{
		System.out.println("***Passed**" + tr.getName() + "***Passed***");
		
		ExtentTestManager.getTest().log(LogStatus.PASS, tr.getName() + " Test Case Passed");
		
	}
	
	public void onTestFailure(ITestResult tr)
	{
		ExtentTestManager.getTest().log(LogStatus.FAIL, tr.getName() + " Test Case Failed");
	}
	
	public void onTestSkipped(ITestResult tr)
	{
		ExtentTestManager.getTest().log(LogStatus.SKIP, tr.getName() + " Test Case skipped");
	}
	
	
	public void onFinish(ITestContext tr)
	{
		ExtentTestManager.endTest();
		ExtentManager.getInstance().flush();
	}
	
	
	
}