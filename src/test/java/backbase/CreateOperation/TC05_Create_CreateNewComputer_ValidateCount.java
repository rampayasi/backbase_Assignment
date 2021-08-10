/*
 * Scenario -
 * This Test case will validate following:
 *		a) Application is displaying the error message to fill the mandatory information if member clicks on the Create this computer button
 *		   without entering any information.
 * Test Data - 
 * 		a)TestDataReader is called to get the data specific to test-case
 * Reporting - 
 * 		a) Once the test-case is executed by Test-NG file, then report will generate in the reports folder.
 * 		b) screenshot functionality is not implemented
 */



package backbase.CreateOperation;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import backbase.PageObject.HomeScreen;
import backbase.ReadOperation.BaseClass;
import backbase.Utilties.ExtentTestManager;
import backbase.Utilties.TestDataReader;

public class TC05_Create_CreateNewComputer_ValidateCount  extends BaseClass{
	
	@Test
	public void TC05_Create_CreateNewComputer_ValidateCount() throws InterruptedException, IOException
	{
		
		
		//********Initiating the browser and launching the application baseURL
		HomeScreen homeScreen = new HomeScreen(driver);
		WebDriverWait wait = new WebDriverWait(driver, 50);
		driver.get("http://computer-database.herokuapp.com/computers");
		

		//Reading the total number of records from the table
		String record_on_title = homeScreen.getRecordCountOnTitle().getText();
		String [] count = record_on_title.split("\\s+");
		int before_count = Integer.parseInt(count[0]);

		
		Thread.sleep(3000);
		
		//Creating a new record (computer
		TC03_Create_CreateNewComputerwithAllTheField ccNew = new TC03_Create_CreateNewComputerwithAllTheField();
		try {
			ccNew.TC03_Create_CreateNewComputerwithAllTheField();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Reading the counter after creating the records ( computer)
		String record_on_title_after = homeScreen.getRecordCountOnTitle().getText();
		String [] count_after = record_on_title_after.split("\\s+");
		int after_count = Integer.parseInt(count_after[0]);
		
		//Now asserting that the counter is increased by 1 after adding it
		

		try {
		assertEquals(after_count, before_count+1);
		ExtentTestManager.getTest().log(LogStatus.PASS, "Total computer count is increased after adding the computer");
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Total computer count is not increased after adding the computer");
		}
		
	}
	
	
	@Test
	public void TC06_Create_CreateNewComputer_SearchCreatedEntry() throws IOException
	{
		
		//********Reading test data for executing this case
		TestDataReader td = new TestDataReader();
		String cName = td.returnTestData("TC02_Create_CreateNewComputerWithNameOnly", "Computer Name", null);
		
		HomeScreen homeScreen = new HomeScreen(driver);	
		WebDriverWait wait = new WebDriverWait(driver, 50);
		driver.get("http://computer-database.herokuapp.com/computers");
		
		//********Enter the newly created computer name in the search field
		try {
		homeScreen.getSearchTextField().sendKeys(cName);
		ExtentTestManager.getTest().log(LogStatus.PASS, "%s is entered for searching the computer name".formatted(cName));
		}
		catch(NoSuchElementException ee)
		{
			ee.printStackTrace();
			ExtentTestManager.getTest().log(LogStatus.FAIL, "%s is not entered for searching the computer name".formatted(cName));
		}
		catch(Exception e)
		{
			e.printStackTrace();
			ExtentTestManager.getTest().log(LogStatus.FAIL, "%s is not entered for searching the computer name".formatted(cName));
		}
		
		//********click on the search button
		try {
		homeScreen.getSearchButton().click();
		ExtentTestManager.getTest().log(LogStatus.PASS, "Search button is clicked");
		}
		catch(NoSuchElementException ee)
		{
			ee.printStackTrace();
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Search button is not clicked");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Search button is not clicked");
		}
	
		
		// Validating the record count present in the table is matching with count present in the page title and page navigation
		
		String record_on_title = homeScreen.getRecordCountOnTitle().getText();
		
		System.out.println("The Title count          " +record_on_title);
		String[] count_title = record_on_title.split(" ");
		
		List<WebElement> records = homeScreen.getTableRecords();
		assertEquals(Integer.parseInt(count_title[0]), records.size());
		
		//Validating that the computer name is not null and also validate that searched computer name contains the searched string.
		for(int i = 0; i<records.size(); i++)
		{
			assertNotNull(records.get(i).getText());
			
			System.out.println();
			assertEquals((records.get(i).getText().toUpperCase()).contains(cName.toUpperCase()), true);
		
		
		
		}
	}
	

}
