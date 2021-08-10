/*
 * Scenario -
 * This Test case will validate following:
 *		a) Validate that 4 columns (Computer name, introduced, discontinued and company name) is displaying on the home screen
 * Test Data - 
 * 		a)TestDataReader is called to get the data specific to test-case
 * Reporting - 
 * 		a) Once the test-case is executed by Test-NG file, then report will generate in the reports folder.
 * 		b) screenshot functionality is not implemented
 */




package backbase.ReadOperation;

import static org.testng.Assert.assertEquals;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import backbase.PageObject.HomeScreen;
import backbase.Utilties.ExtentTestManager;

class TC01_Search_UIValidation_SearchRecordTable extends BaseClass{
	
	@Test
	public void TC01_Search_UIValidation_SearchRecordTable()
	{
		
		//***********Initiating the browser and launching the application
		HomeScreen homeScreen = new HomeScreen(driver);
		driver.get("http://computer-database.herokuapp.com/computers");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		wait.until(ExpectedConditions.visibilityOf(homeScreen.getHomeSceenLabel()));
		
		//Validating the column name in the table
		try {
		String firstCol = homeScreen.getFirstColumnNameofSearchTable().getText();
		assertEquals(firstCol, "Computer name");
		ExtentTestManager.getTest().log(LogStatus.PASS, "Computer name column is present");
		} 
		catch(NoSuchElementException ee)
		{
		ee.printStackTrace();
		ExtentTestManager.getTest().log(LogStatus.FAIL, "Computer name is not present");
		}
	
		try {
		String secondCol = homeScreen.getSecondColumnNameofSearchTable().getText();
		assertEquals(secondCol, "Introduced");
		ExtentTestManager.getTest().log(LogStatus.PASS, "Introduced column is present");
		}
		catch (NoSuchElementException ee)
		{
			ee.printStackTrace();
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Introduced Column is not present");
		}
		
		try {
		String thirdCol = homeScreen.getThirdColumnNameofSearchTable().getText();
		assertEquals(thirdCol, "Discontinued");
		ExtentTestManager.getTest().log(LogStatus.PASS, "Distributed column is present");
		}
		catch(NoSuchElementException ee)
		{
			ee.printStackTrace();
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Discontinued Column is not present");
		}
		
		
		try {
		String FourthCol = homeScreen.getFourthColumnNameofSearchTable().getText();
		assertEquals(FourthCol, "Company");
		ExtentTestManager.getTest().log(LogStatus.PASS, "Company column is present");
		}
		catch (NoSuchElementException ee)
		{
			ee.printStackTrace();
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Company column is not present");
		}
		
		
	}
	
}