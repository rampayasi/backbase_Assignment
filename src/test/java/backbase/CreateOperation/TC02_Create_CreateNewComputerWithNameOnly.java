/*
 * Scenario -
 * This Test case will validate following:
 *		a) A new computer is created with just computer name as its the only mandatory field
 *		b) Application is displaying the confirmation message after creating the computer name
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

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import backbase.PageObject.AddScreen;
import backbase.ReadOperation.BaseClass;
import backbase.Utilties.ExtentTestManager;
import backbase.Utilties.TestDataReader;

public class TC02_Create_CreateNewComputerWithNameOnly extends BaseClass {

	
	
	@Test
	public void TC02_Create_CreateNewComputer() throws InterruptedException, IOException 
	{
		
		//********Getting test-data for creating the computer with just name
		TestDataReader td = new TestDataReader();
		String cc = new Object(){}.getClass().getEnclosingMethod().getName();
		String cName = td.returnTestData("TC02_Create_CreateNewComputerWithNameOnly", "Computer Name", null);
		
		//********Initialisation the browser and baseURL
		AddScreen addScreen = new AddScreen(driver);
		WebDriverWait wait = new WebDriverWait(driver, 50);
		driver.get("http://computer-database.herokuapp.com/computers");
		wait.until(ExpectedConditions.visibilityOf(addScreen.getAddNewComputerButton()));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		//********Validating that Add a new computer button is displaying
		try {
		addScreen.getAddNewComputerButton().click();
		wait.until(ExpectedConditions.visibilityOf(addScreen.getAddScreenHeading()));
		ExtentTestManager.getTest().log(LogStatus.PASS, "Add a new computer button is displaying");
		
		}
		catch(NoSuchElementException e)
		{
			e.printStackTrace();
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Add a new computer is not present");
			
		}
		
		Thread.sleep(3000);
		
		
		//********Validating that new computer name is entered in the text field
		try {
		addScreen.getComputerNameFieldInput().sendKeys(cName);// entering the computer name
		ExtentTestManager.getTest().log(LogStatus.PASS, "%s is entered for creating a new computer".formatted(cName));
		
		}
		catch(NoSuchElementException ee)
		{
			ee.printStackTrace();
			ExtentTestManager.getTest().log(LogStatus.FAIL, "%s is not entered for creating a new computer".formatted(cName));
		}
		
		//********Validating that "Create this computer button is clicked
		try {
		addScreen.getCreateThisComputer().click();
		ExtentTestManager.getTest().log(LogStatus.PASS, "Create this computer button is clicked");
		}
		catch(ElementClickInterceptedException ee)
		{
			ee.printStackTrace();
			ExtentTestManager.getTest().log(LogStatus.FAIL, "create this computer button is not clicked");
		}
		
		Thread.sleep(3000);
		
		//********Validating that application is displaying the confirmation message after creating the computer
		try {
		assertTrue(addScreen.getAlertMessage().isDisplayed());
		assertEquals(addScreen.getAlertMessage().getText(), "Done! Computer %s has been created".formatted(cName));
		ExtentTestManager.getTest().log(LogStatus.PASS, "Confirmaton after adding a new computer is displaying correctly");
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Confirmation after adding a new computer is not displaying");
		}
		
	
		//td.writeData("TC02_Create_CreateNewComputerWithNameOnly", "Created", "Yes", null);
		
	
	}
	
	
	
	
}
