/*
 * Scenario -
 * This Test case will validate following:
 *		a) Validate that Delete this computer button is displaying after clicking on the any computer name
 *		b) Validate that the computer name is getting deleted after clicking on the Delete this computer button
 * Test Data - 
 * 		a)TestDataReader is called to get the data specific to test-case
 * Reporting - 
 * 		a) Once the test-case is executed by Test-NG file, then report will generate in the reports folder.
 * 		b) screenshot functionality is not implemented
 * Limitation -
 * 		a) Since, application store duplicate records, its difficult to identify the unique records when all 4 fields are same. hence
 * 			in this, case the first item will be selected for deletion
 */


package backbase.DeleteOperation;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import backbase.PageObject.DeleteScreen;
import backbase.PageObject.HomeScreen;
import backbase.ReadOperation.BaseClass;
import backbase.Utilties.ExtentTestManager;
import backbase.Utilties.TestDataReader;

public class TC01_Delete_deleteReocords extends BaseClass {

	@Test
	public void TC01_Delete_deleteReocords() throws IOException
	{
		
		//*******Getting test data for executing this case
		TestDataReader td = new TestDataReader();
		String cName = td.returnTestData("TC01_Delete_deleteReocords", "Computer Name", null);
		
		//Initiating browser and launching the baseURL
		DeleteScreen del = new DeleteScreen(driver);
		HomeScreen homeScreen = new HomeScreen(driver);	
		WebDriverWait wait = new WebDriverWait(driver, 50);
		driver.get("http://computer-database.herokuapp.com/computers");
		
		
		//**********Getting the count from home screen

		String before_record_on_title = homeScreen.getRecordCountOnTitle().getText();
		String [] before_count = before_record_on_title.split("\\s+");
		int before_counta = Integer.parseInt(before_count[0]);
		
		//**********Enter computer name which is to be deleted and click on the search button
		try {
		del.getSearchTextField().sendKeys(cName);
		ExtentTestManager.getTest().log(LogStatus.PASS, "Computer name %s is entered for deletion".formatted(cName));
		
		}
		catch(NoSuchElementException ee)
		{
			ee.printStackTrace();
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Computer name %s is not entered for delete".formatted(cName));
		}
		catch(Exception e)
		{
			e.printStackTrace();
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Computer name %s is not entered for delete".formatted(cName));
		}
		
		//**********Click on the search button 
		try {
			del.getSearchButton().click();
			ExtentTestManager.getTest().log(LogStatus.PASS, "Search button is  clicked");
		}
		catch(NoSuchElementException e)
		{
			e.printStackTrace();
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Search button is not clicked");
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Search button is not clicked");
		}
		
		//**********Click on the computer name for update/delete
		try {
		del.getComputerNameForUpdate(1, 1).click();
		ExtentTestManager.getTest().log(LogStatus.PASS, "Computer name is entered");
		}
		catch(ElementClickInterceptedException ee)
		{
			ee.printStackTrace();
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Computer name is not clicked");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Computer name is not clicked");
		}
		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		//**********Validate that delete button is displaying and also validate that delete button is clicked
		try {
		del.getDeleteButton().click();
		ExtentTestManager.getTest().log(LogStatus.PASS, "Delete button is clicked");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Delete button is not clicked");
		}
		

		String after_record_on_title = homeScreen.getRecordCountOnTitle().getText();
		String [] after_count = after_record_on_title.split("\\s+");
		int after_counta = Integer.parseInt(after_count[0]);
		
		
		//**********Validate the total count on homescreen and pagination after deleting the record
		try {
		
		assertEquals(after_counta, before_counta-1);
		ExtentTestManager.getTest().log(LogStatus.PASS, "Computer record is deleted succesfully");
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Computer record is not deleted successfully");
		}
	
	
	}
	
	
}
