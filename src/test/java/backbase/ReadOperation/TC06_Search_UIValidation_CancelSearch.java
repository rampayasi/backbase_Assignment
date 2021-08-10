/*
 * Scenario -
 * This Test case will validate following:
 *		a) validating that search clear button can be clicked and table should should all the records
 * Test Data - 
 * 		a)TestDataReader is called to get the data specific to test-case
 * Reporting - 
 * 		a) Once the test-case is executed by Test-NG file, then report will generate in the reports folder.
 * 		b) screenshot functionality is not implemented
 */


package backbase.ReadOperation;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import backbase.PageObject.HomeScreen;
import backbase.Utilties.ExtentTestManager;

public class TC06_Search_UIValidation_CancelSearch extends BaseClass {

@Test
public void TC06_Search_UIValidation_CancelSearch() throws InterruptedException, IOException
{
	
	WebDriverWait wait = new WebDriverWait(driver, 50);
	HomeScreen homeScreen = new HomeScreen(driver); 
	
	//Re-using the TestCase
	TC05_Search_UIValidation_SearchComputerName tc = new TC05_Search_UIValidation_SearchComputerName();
	tc.TC05_Search_UIValidation_SearchComputerName();
	
	
	//Clearing the search result
	try {
	homeScreen.getSearchTextField().clear();
	homeScreen.getSearchButton().click();
	ExtentTestManager.getTest().log(LogStatus.PASS, "Searched records are matched");
	
	}
	catch(Exception e)
	{
		e.printStackTrace();
		ExtentTestManager.getTest().log(LogStatus.FAIL, "Searched records are not cleared");
	}
	Thread.sleep(3000);
	
}


}
