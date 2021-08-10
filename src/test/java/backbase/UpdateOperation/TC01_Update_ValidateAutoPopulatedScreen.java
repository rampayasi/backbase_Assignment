/*
 * Scenario -
 * This Test case will validate following:
 *		a) Validate that data is pre-populated in the textfield if user click on the computer name for edit
 * Test Data - 
 * 		a)TestDataReader is called to get the data specific to test-case
 * Reporting - 
 * 		a) Once the test-case is executed by Test-NG file, then report will generate in the reports folder.
 * 		b) screenshot functionality is not implemented
 */



package backbase.UpdateOperation;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import backbase.PageObject.EditScreen;
import backbase.ReadOperation.BaseClass;
import backbase.Utilties.ExtentTestManager;
import backbase.Utilties.TestDataReader;

public class TC01_Update_ValidateAutoPopulatedScreen extends BaseClass {
	
	@Test
	public void TC01_Update_ValidateAutoPopulatedScreen() throws InterruptedException, ParseException, IOException
	{
		//Reading the data
		TestDataReader td = new TestDataReader();
		String cc = new Object(){}.getClass().getEnclosingMethod().getName();
		String cName = td.returnTestData("TC01_Update_ValidateAutoPopulatedScreen", "Computer Name", null);
		
		HashMap<String, String> hasMap = new HashMap<>();
		EditScreen editScreen = new EditScreen(driver);
		
		//Initiating the browser and accessing the application
		WebDriverWait wait = new WebDriverWait(driver, 50);
		driver.get("http://computer-database.herokuapp.com/computers");
		
		
		//Entering the computer name for search
		try {
		editScreen.getSearchTextField().sendKeys(cName);
		ExtentTestManager.getTest().log(LogStatus.PASS, "%s is entered for searching".formatted(cName));
		}
		catch(Exception e)
		{
			e.printStackTrace();
			ExtentTestManager.getTest().log(LogStatus.FAIL, "%s is not entered for searching".formatted(cName));
		}
		
		//Clicking on the search button
		try {
		editScreen.getSearchButton().click(); 
		ExtentTestManager.getTest().log(LogStatus.PASS, "Search button is clicked");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Search button is not clicked");
		}
		
		//Validating the records
		int records = editScreen.getTableRecords();
		System.out.println("Number of records is" + records);
		int n = editScreen.numberOfColumns();
		System.out.println("Number of column is" + n);
		//List<String> present_records = new ArrayList<>();
		//Validating that the computer name is not null and also validate that searched computer name contains the searched string.
		for(int i = 0; i<records; i++)
		{
			
			
			if(((editScreen.getComputerNameForUpdate(i+1, 1).getText()).equals(cName)))
			{
				String a[] = {"Computer name", "introduced", "Distributed", "Company"};
				for (int j =1; j<=n; j++)
				{
					
					WebElement ee = editScreen.getAllRecordForUpdate(j);
					System.out.println("The Column value" + ee.getText());
					hasMap.put(a[j-1], ee.getText());
					
				}
				break;
				
			}
			else continue;	
		}
	
		
		//
		try {
		editScreen.getComputerNameForUpdate(1, 1).click();
		ExtentTestManager.getTest().log(LogStatus.PASS, "Computer name is clicked for edit ");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Computer name is not clicked for edit");
		}
		
		try {
		assertEquals(editScreen.getEditHeading().getText(), "Edit computer");
		ExtentTestManager.getTest().log(LogStatus.PASS, "Heading for edit page is displaying");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Heading for Edit page is not displaying");
		}
		//System.out.println(hasMap.get("Computer name"));
		
		
		try {
		assertEquals(hasMap.get("Computer name"), editScreen.getEditComputerName().getAttribute("value"));
		ExtentTestManager.getTest().log(LogStatus.PASS, "Computer name is displaying as prepopulated on the edit screen");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Computer name is not displaying as prepopulated on the edit screen");
		}
		
		
		try {
		assertEquals(hasMap.get("introduced").replace(" ", "-"), dateReturn(editScreen.getEditIntroducedDate().getAttribute("value")));
		ExtentTestManager.getTest().log(LogStatus.PASS, "Introduced date is prepopulated");	
		}
		catch(Exception e)
		{
			e.printStackTrace();
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Introduced date is not prepopulated");
		}
		
		try {
		assertEquals(hasMap.get("Distributed").replace(" ", "-"), dateReturn(editScreen.getEditDiscontinuedDate().getAttribute("value")));
		ExtentTestManager.getTest().log(LogStatus.PASS, "Distributed date is prepulated");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Distributed date is not populated");
		}
		
		try {
		String com = hasMap.get("Company");
		Select ss = new Select(editScreen.getEditCompany());
		ss.getFirstSelectedOption().getText();
		String company_name = (ss.getFirstSelectedOption()).getText();
		if(com.equals("-"))
		{
			assertEquals("-- Choose a company --", company_name);
		}
		else
			{assertEquals(com, company_name);}
		//assertEquals(com, company_name);
		ExtentTestManager.getTest().log(LogStatus.PASS, "Company name is prepopulated");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Company name is not prepopulated");
		}
		Thread.sleep(6000);
		
	}
	
	public String dateReturn(String ssDate)
	{
		String ss_date1 = ssDate.replace(" ", "-");
		LocalDate date = LocalDate.parse(ss_date1);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy", Locale.ENGLISH);
		date.format(formatter);
		String ss = date.format(formatter).toString();
		
		return ss;
	}

}
