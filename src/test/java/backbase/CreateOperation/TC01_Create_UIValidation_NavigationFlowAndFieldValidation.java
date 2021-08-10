/*
 * Scenario -
 * This Test case will validate following:
 *		a) Create a new computer button on home screen
 *		b) Application is redirecting to add a home screen after clicking on the " Add a new computer" button
 * 		c) All the labels on the add a computer screen
 * 		d) create this computer button
 * 		c) cancel button
 * Reporting - 
 * 		a) Once the test-case is executed by Test-NG file, then report will generate in the reports folder.
 * 		b) screenshot functionality is not implemented
 */


package backbase.CreateOperation;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import backbase.PageObject.AddScreen;
import backbase.ReadOperation.BaseClass;
import backbase.Utilties.ExtentTestManager;

public class TC01_Create_UIValidation_NavigationFlowAndFieldValidation extends BaseClass {

	@Test
	public void TC01_Create_UIValidation_NavigationFlowAndFieldValidation() throws InterruptedException
	{
		
		
		AddScreen addScreen = new AddScreen(driver);
		WebDriverWait wait = new WebDriverWait(driver, 50);
		driver.get("http://computer-database.herokuapp.com/computers");
		wait.until(ExpectedConditions.visibilityOf(addScreen.getHomeSceenLabel()));
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		//**************Validating that the URL is launched successfully***********
		try {
		assertEquals(driver.getTitle(), "Computers database");
		ExtentTestManager.getTest().log(LogStatus.PASS, "The Test URL is successfully launched");

		}
		catch (ElementNotVisibleException ee)
		{
			ee.printStackTrace();
			ExtentTestManager.getTest().log(LogStatus.FAIL, "The Test URL is not launched successfully");
		
		}
		Thread.sleep(3000); // introduced this to slow down the speed..
		
		
		
		//***********Validating that the "Add a new computer is displaying on the home screen*********
		try {
		assertEquals(addScreen.getAddNewComputerButton().isDisplayed(), true); // asserting that add new computer button is available on the home screen
		ExtentTestManager.getTest().log(LogStatus.PASS, "Add a new computer button is displaying");
		
		
		}
		catch (ElementNotVisibleException ee)
		{
			ee.printStackTrace();
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Add a new computer button is not visiable");
			
		}
		
		//*******Validating that the "Add a new computer button is clicked"
		try {
		addScreen.getAddNewComputerButton().click();
		wait.until(ExpectedConditions.visibilityOf(addScreen.getHomeSceenLabel()));
		ExtentTestManager.getTest().log(LogStatus.PASS, "Add a new computer button clicked");
		
		}
		catch(ElementClickInterceptedException ee)
		{
			ee.printStackTrace();
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Error while clicking on the 'Add a new computer button'");
			
		}
		
		//*******Validating that application is displaying Add a new computer screen after clicking on the "Add a new computer" button
		
		try {
		assertEquals(addScreen.getAddScreenHeading().isDisplayed(), true);
		assertEquals(addScreen.getAddScreenHeading().getText(), "Add a computer"); 
		ExtentTestManager.getTest().log(LogStatus.PASS, "Add a computer heading is displayed after clicking on the 'add a new comupter button'");
		
		}
		catch(NoSuchElementException ee)
		{
			ee.printStackTrace();
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Add a computer heading is not displaying after clicking on the 'add a new computer button'");
			
			
		}
		
		// ********Validating that all the labels are displaying on the add home screen
		String [] label = {"Computer name", "Introduced date", "Discontinued date", "Company", "Required", "Date ('yyyy-MM-dd')"};
		List<String> labelList = new ArrayList<>(Arrays.asList(label));
		List<WebElement> fieldLable = addScreen.getFieldLabel();
		
		for(int i = 0; i<fieldLable.size(); i++)
		{
			String name = fieldLable.get(i).getText();
			
			try {
			assertTrue(labelList.contains(name));
			ExtentTestManager.getTest().log(LogStatus.PASS, "%s lable is displaying".formatted(name));
			
			
			}
			catch (NoSuchElementException ee)
			{
				ee.printStackTrace();
				ExtentTestManager.getTest().log(LogStatus.FAIL, "%s lable is missing".formatted(name));
				
			}
			
		
		}
		
		//Validating that the create button and cancel button is present on the add home screen.
		
		try {
		assertTrue((addScreen.getCreateThisComputer().isDisplayed())); 
		ExtentTestManager.getTest().log(LogStatus.PASS, "Create this computer button is displaying");
		
		}
		catch(NoSuchElementException ee)
		{
			ee.printStackTrace();
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Create this computer button is not displaying");
			
		}
		
		try {
		assertTrue((addScreen.getCancelButton().isDisplayed()));
		ExtentTestManager.getTest().log(LogStatus.PASS, "Cancel button is displaying");
		
		}
		catch(NoSuchElementException ee)
		{
			ee.printStackTrace();
			ExtentTestManager.getTest().log(LogStatus.PASS, "Cancel button is not displaying");
		
		}
		
		
		
	}



}
