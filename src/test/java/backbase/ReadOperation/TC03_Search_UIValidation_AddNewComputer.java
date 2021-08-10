/*
 * Scenario -
 * This Test case will validate following:
 *		a) Validate that Add a new computer button is displaying
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

public class TC03_Search_UIValidation_AddNewComputer extends BaseClass {
	
	@Test
	public void TC03_Search_UIValidation_AddNewComputer()
	{
		//Initiating the browser and launching the application
		HomeScreen homeScreen = new HomeScreen(driver);
		driver.get("http://computer-database.herokuapp.com/computers");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//Validating that the "Add a new computer" button is displaying
		try {
		assertTrue(homeScreen.getNewComputerButton().isDisplayed());
		ExtentTestManager.getTest().log(LogStatus.PASS, "Add a new computer button is displaying");
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Add a new computer button is not displaying");
		}
		
	}
	
	

}
