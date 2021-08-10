/*
 * Scenario -
 * This Test case will validate following:
 *		a) Validate count on the top of the page and count on the pagination is matching
 * Test Data - 
 * 		a)TestDataReader is called to get the data specific to test-case
 * Reporting - 
 * 		a) Once the test-case is executed by Test-NG file, then report will generate in the reports folder.
 * 		b) screenshot functionality is not implemented
 */


package backbase.ReadOperation;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import backbase.PageObject.HomeScreen;
import backbase.Utilties.ExtentTestManager;

public class TC04_Search_UIValidation_RecordCountValidation extends BaseClass {
	
	@Test
	public void TC04_Search_UIValidation_RecordCountValidation()
	{
		//Initiating the browser and launching the application
		HomeScreen homeScreen = new HomeScreen(driver);		
		driver.get("http://computer-database.herokuapp.com/computers");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		
		// Validating the number of records
		
		String record_on_title = homeScreen.getRecordCountOnTitle().getText();
		String [] count = record_on_title.split("\\s+");
		
		String record_on_pagination = homeScreen.getRecordOnPagination().getText();
		String  [] count_page = record_on_pagination.split(" ");
		
		//Asserting the count
		try {
		assertEquals(count[0], count_page[5]);
		ExtentTestManager.getTest().log(LogStatus.PASS, "Record is matching on pagination");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Record is not matching on pagination");
		}
		
	}

}
