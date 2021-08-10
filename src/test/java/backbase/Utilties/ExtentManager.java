package backbase.Utilties;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {

	private static ExtentReports extent;
	
	public static ExtentReports getInstance()
	{
		
		if(extent == null)
		{
			createInstance();
		}
		
		return extent;
	}
	
	public  static ExtentReports createInstance() 
	{
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		//String repName = "TestReport"+timeStamp+".html";
		String repName = "ExtentReport.html";
		System.out.println("The Report name is "+ "");
		String reportFilepath = "C:\\SDET\\backbase\\reports\\"+repName;
		System.out.println(reportFilepath);
		extent = new ExtentReports(System.getProperty("user.dir")+"//reports//ExtentReportResults.html");
		return extent;
		
		
	}
	
	
}
