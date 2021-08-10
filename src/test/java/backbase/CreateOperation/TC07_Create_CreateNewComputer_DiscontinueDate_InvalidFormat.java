/*
 * Scenario -
 * This Test case will validate following:
 *		a) Validate that application is displaying the error if introduced date is entered in wrong format
 * Test Data - 
 * 		a)TestDataReader is called to get the data specific to test-case
 * Reporting - 
 * 		a) Once the test-case is executed by Test-NG file, then report will generate in the reports folder.
 * 		b) screenshot functionality is not implemented
 */




package backbase.CreateOperation;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

import backbase.PageObject.AddScreen;
import backbase.ReadOperation.BaseClass;
import backbase.Utilties.ExtentTestManager;
import backbase.Utilties.TestDataReader;

public class TC07_Create_CreateNewComputer_DiscontinueDate_InvalidFormat extends BaseClass {
	
	
	public void TC07_Create_CreateNewComputer_DiscontinueDate_InvalidFormat() throws IOException, InterruptedException
	{
	
	
			//***********Getting test data ( I could have used Data provider class from TestNG but this more customize function
			TestDataReader td = new TestDataReader();
			String cc = new Object(){}.getClass().getEnclosingMethod().getName();
			String cName = td.returnTestData("TC07_Create_CreateNewComputer_DiscontinueDate_InvalidFormat", "Computer Name", null);
			String iName = td.returnTestData("TC07_Create_CreateNewComputer_DiscontinueDate_InvalidFormat", "Introduced Date", null);
			String dName = td.returnTestData("TC07_Create_CreateNewComputer_DiscontinueDate_InvalidFormat", "Discontinued Date", null);
			//*************initiating the browser instance and launching the baseURL
			
			AddScreen addScreen = new AddScreen(driver);
			WebDriverWait wait = new WebDriverWait(driver, 50);
			driver.get("http://computer-database.herokuapp.com/computers");
			wait.until(ExpectedConditions.visibilityOf(addScreen.getAddNewComputerButton()));
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			

			//*************Validating that a add a new computer button is clicked
			try {
			addScreen.getAddNewComputerButton().click();
			wait.until(ExpectedConditions.visibilityOf(addScreen.getAddScreenHeading()));
			
			}
			catch(NoSuchElementException ee)
			{
				ee.printStackTrace();
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Add a new computer button is not clicked");
			}
			catch (Exception e)
			{
				e.printStackTrace();
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Add a new computer button is not clicked");
			}
			
			Thread.sleep(300);
			
			//*************Validating that computer name is entered
			try {
			addScreen.getComputerNameFieldInput().sendKeys(cName); // entering the computer name
			ExtentTestManager.getTest().log(LogStatus.PASS, "%s is entered for creating a new computer".formatted(cName));
			
			}
			catch (NoSuchElementException ee)
			{
				ee.printStackTrace();
				ExtentTestManager.getTest().log(LogStatus.FAIL, "%s is not entered for creating a new computer".formatted(cName));
			}
			catch (Exception e)
			{
				e.printStackTrace();
				ExtentTestManager.getTest().log(LogStatus.FAIL, "%s is not entered for creating a new computer".formatted(cName));
			}

			//*************Validating that introduced date is entered
			try {
			addScreen.getIntroducedDate().sendKeys(iName);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Introduced date is entered");
			}
			catch(NoSuchElementException ee)
			{
				ee.printStackTrace();
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Introduced date is not entered");
			}
			catch(Exception e)
			{
				e.printStackTrace();
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Introduced date is not entered");
			}
			
			
			
			//*************Validate that computer button is clicked
			try {
			addScreen.getCreateThisComputer().click();
			ExtentTestManager.getTest().log(LogStatus.PASS, "create this computer button clicked");
			}
			catch(NoSuchElementException ee)
			{
				ee.printStackTrace();
				ExtentTestManager.getTest().log(LogStatus.FAIL, "create this computer button is not clicked");
			}
			catch (Exception e)
			{
				e.printStackTrace();
				ExtentTestManager.getTest().log(LogStatus.FAIL, "create this computer button is not clicked");
			}
			
			//*************Validate that Discontinued date is entered
			
			try {
			addScreen.getDiscontinuedDate().sendKeys(dName);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Discontinued date is displaying");
			}
			catch (NoSuchElementException ee)
			{
				ee.printStackTrace();
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Discontinued date is not displaying");
			}
			
			catch(Exception e)
			{
				e.printStackTrace();
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Discontinued date is not displaying");
			}
			
			
			Thread.sleep(3000);
			
			//*************Validate that application is displaying the confirmation message after creating the computer
			try {
			assertTrue(addScreen.getAlertMessage().isDisplayed());
			assertEquals(addScreen.getAlertMessage().getText(), "Done! Computer %s has been created".formatted(cName));
			
			}
			catch (ElementNotVisibleException ee)
			{
				ee.printStackTrace();
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Confirmation message after creating the computer is not displaying");
			}
			catch (Exception e)
			{
				e.printStackTrace();
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Confirmation message after creating the computer is not displaying");
			}
			//td.writeData("TC03_Create_CreateNewComputerwithAllTheField", "Created", "Yes", null);
		
		}
		


}

