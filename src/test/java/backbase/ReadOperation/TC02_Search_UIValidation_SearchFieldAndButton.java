/*
 * Scenario -
 * This Test case will validate following:
 *		a) Validate that search field and search button is displaying correctly
 * Test Data - 
 * 		a)TestDataReader is called to get the data specific to test-case
 * Reporting - 
 * 		a) Once the test-case is executed by Test-NG file, then report will generate in the reports folder.
 * 		b) screenshot functionality is not implemented
 */


package backbase.ReadOperation;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import backbase.PageObject.HomeScreen;
import backbase.Utilties.ExtentTestManager;

public class TC02_Search_UIValidation_SearchFieldAndButton extends BaseClass {


@Test
public void TC02_Search_UIValidation_SearchFieldAndButton()
{
	
	//***********Initiating the browser and launching the application
	HomeScreen homeScreen = new HomeScreen(driver);
	driver.get("http://computer-database.herokuapp.com/computers");
	
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
	
	//validating that the search button and search text field is displaying
	try {
	assertTrue(homeScreen.getSearchTextField().isDisplayed());
	assertTrue(homeScreen.getSearchButton().isDisplayed());
	ExtentTestManager.getTest().log(LogStatus.PASS, "Search text field and button is displaying");
	
	}
	catch(Exception ee)
	{
		ee.printStackTrace();
		ExtentTestManager.getTest().log(LogStatus.INFO, "TTT");
		ExtentTestManager.getTest().log(LogStatus.FAIL, "Search text field and button is not displaying");
	}
	
	}
	
	


}
