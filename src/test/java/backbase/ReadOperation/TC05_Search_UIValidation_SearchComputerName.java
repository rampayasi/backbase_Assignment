/*
 * Scenario -
 * This Test case will validate following:
 *		a) Search by entering the computer name
 *		b) Validate all the searched records contains the searched string
 *		c) Validate the count is matching
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

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import backbase.PageObject.HomeScreen;
import backbase.Utilties.ExtentTestManager;
import backbase.Utilties.TestDataReader;

public class TC05_Search_UIValidation_SearchComputerName extends BaseClass {
	
@Test(groups = "SearchFunction")
public void TC05_Search_UIValidation_SearchComputerName() throws InterruptedException, IOException
{
	//Getting test-data to execute this test-case
	TestDataReader td = new TestDataReader();
	String cc = new Object(){}.getClass().getEnclosingMethod().getName();
	String cName = td.returnTestData("TC05_Search_UIValidation_SearchComputerName", "Computer Name", null);
	
	HomeScreen homeScreen = new HomeScreen(driver);
	WebDriverWait wait = new WebDriverWait(driver, 50);
	driver.get("http://computer-database.herokuapp.com/computers");
	wait.until(ExpectedConditions.visibilityOf(homeScreen.getHomeSceenLabel()));
	
	
	
	try {
	homeScreen.getSearchTextField().sendKeys(cName);
	ExtentTestManager.getTest().log(LogStatus.PASS, "%s is entered for search".formatted(cName));
	}
	catch(Exception ee)
	{
		ee.printStackTrace();
		ExtentTestManager.getTest().log(LogStatus.FAIL, "%s is entered for search".formatted(cName));
	}
	
	try {
	homeScreen.getSearchButton().click();
	ExtentTestManager.getTest().log(LogStatus.PASS, "Search button is clicked");
	}
	catch(Exception ee)
	{
		ee.printStackTrace();
		ExtentTestManager.getTest().log(LogStatus.FAIL, "Search button is not clicked");
	}
	
	Thread.sleep(3000);// included this to slow the speed of execution so that we can validate it
	
	//Validating that the search count is displaying correctly
	
	String record_on_title = homeScreen.getRecordCountOnTitle().getText();
	String[] count_title = record_on_title.split(" ");
	
	String record_on_pagination = homeScreen.getRecordOnPagination().getText();
	String[] count_pagination = record_on_pagination.split(" ");
	
	try {
	assertEquals(count_title[0], count_pagination[5]);
	ExtentTestManager.getTest().log(LogStatus.PASS, "Count on title and pagination is matching");
	}
	catch(Exception ee)
	{
		ee.printStackTrace();
		ExtentTestManager.getTest().log(LogStatus.FAIL, "Count on title and count on the pagination is not matching");
	}
	// Validating the record count present in the table is matching with count present in the page title and page navigation
	
	List<WebElement> records = homeScreen.getTableRecords();
	assertEquals(Integer.parseInt(count_title[0]), records.size());
	
	//Validating that the computer name is not null and also validate that searched computer name contains the searched string.
	for(int i = 0; i<records.size(); i++)
	{
		assertNotNull(records.get(i).getText());
		
		try {
		assertEquals((records.get(i).getText().toUpperCase()).contains(cName.toUpperCase()), true);
		ExtentTestManager.getTest().log(LogStatus.PASS, "Total number of searched records is matching with count on title and pagination");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Total number of searched records is not matching with count on title and pagination");
		}
	
	
	
	}
}



}
