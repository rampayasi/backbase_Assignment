/*
 * Scenario -
 * This Test case will validate following:
 *		a) update the computer name and validate the application is displaying the confirmation screen
 * Test Data - 
 * 		a)TestDataReader is called to get the data specific to test-case
 * Reporting - 
 * 		a) Once the test-case is executed by Test-NG file, then report will generate in the reports folder.
 * 		b) screenshot functionality is not implemented
 */

package backbase.UpdateOperation;

import java.io.IOException;
import java.text.ParseException;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import backbase.PageObject.EditScreen;
import backbase.ReadOperation.BaseClass;
import backbase.Utilties.ExtentTestManager;
import backbase.Utilties.TestDataReader;

public class TC02_Update_UpdateComputerName extends BaseClass{

	@Test
	public void TC02_Update_UpdateComputerName() throws IOException
	{
		//Reading the test Data
		TestDataReader td = new TestDataReader();
		String cName = td.returnTestData("TC02_Update_UpdateComputerName", "Computer Name", null);
		
		EditScreen ee = new EditScreen(driver);
		
		TC01_Update_ValidateAutoPopulatedScreen update = new TC01_Update_ValidateAutoPopulatedScreen();
		try {
			update.TC01_Update_ValidateAutoPopulatedScreen();
		} catch (InterruptedException | ParseException e) {
			e.printStackTrace();
		}
		
		
		try {
		ee.getEditComputerName().clear();
		ExtentTestManager.getTest().log(LogStatus.PASS, "Edit field is cleared");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Edit field is not cleared");
		}
		
		
		try {
		ee.getEditComputerName().sendKeys(cName);
		ExtentTestManager.getTest().log(LogStatus.PASS, "New computer is entered for update");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			ExtentTestManager.getTest().log(LogStatus.FAIL, "New computer name is not entered");
		}
		
		
		try {
		ee.getUpdateoComputerNameButton().click();
		ExtentTestManager.getTest().log(LogStatus.PASS, "Update button is clicked");
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Update buttton is not clicked");
		}
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String expectedString = "Done! Computer %s has been updated".formatted(cName);
		String updateAlertMessage = ee.getUpdateAlertMessage().getText();
		
		if(expectedString.equals(updateAlertMessage))
		{
			ExtentTestManager.getTest().log(LogStatus.PASS, "Computer record is updated successfully");
		}
		else
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Computer record is not updated successfully");

		
		
		
		
	}
	
	
	
	
}
