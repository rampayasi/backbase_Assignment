package backbase.Utilties;

import java.util.HashMap;
import java.util.Map;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ExtentTestManager {
	
	
	static Map<Integer, ExtentTest> extentTestMap = new HashMap<Integer, ExtentTest>();
	static ExtentReports extent = ExtentManager.getInstance();
	
	public static synchronized ExtentTest getTest() {
		
		System.out.println("Extent instance" + extent);
		
		return (ExtentTest) extentTestMap.get((int)(long)(Thread.currentThread().getId()));
		
	}
	
	public static synchronized void  endTest()
	{
		System.out.println("The Report is ending");
		extent.flush();
	}
	
	public static synchronized ExtentTest startTest(String testName)
	{
		System.out.println("Test Case which is going to start" + testName);
		ExtentTest test = extent.startTest(testName);
		extentTestMap.put((int)(long)(Thread.currentThread().getId()), test);
		return test;
		
	}

}
