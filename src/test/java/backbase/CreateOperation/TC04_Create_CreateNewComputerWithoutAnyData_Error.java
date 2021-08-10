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

import static org.testng.Assert.assertTrue;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import backbase.PageObject.AddScreen;
import backbase.ReadOperation.BaseClass;
import backbase.Utilties.ExtentTestManager;

public class TC04_Create_CreateNewComputerWithoutAnyData_Error extends BaseClass {

	@Test
	public void TC04_Create_CreateNewComputerWithoutAnyData_Error() throws InterruptedException 
	{
		
		//********Initiating the browser and launching the application baseURL
		AddScreen addScreen = new AddScreen(driver);
		WebDriverWait wait = new WebDriverWait(driver, 50);
		driver.get("http://computer-database.herokuapp.com/computers");
		wait.until(ExpectedConditions.visibilityOf(addScreen.getAddNewComputerButton()));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		//********Validating that create a new computer button is displaying
		try {
		addScreen.getAddNewComputerButton().click();
		wait.until(ExpectedConditions.visibilityOf(addScreen.getAddScreenHeading()));
		ExtentTestManager.getTest().log(LogStatus.PASS, "Create a new computer button is clicked");
		}
		catch(NoSuchElementException ee)
		{
			ee.printStackTrace();
			ExtentTestManager.getTest().log(LogStatus.ERROR, "Create a new computer button is not clicked");
		}
		Thread.sleep(300);
		
		//********Validating that create this computer button is clicked without entering any information and application displays error
		try {
		addScreen.getCreateThisComputer().click();
		assertTrue(addScreen.getMandatoryError().isDisplayed());
		ExtentTestManager.getTest().log(LogStatus.PASS, "Create this computer is clicked and expected error for mandatory field is displayed");
		}
		catch(NoSuchElementException ee)
		{
			ee.printStackTrace();
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Create this computer button is not clicked");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Create this computer button is not clicked");
		}
		
		
		
		
	}
	
	
	
	
}
