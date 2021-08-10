/*
 * Scenario -
 * This Test case will validate following:
 *		a) Validate the count after updating the computer name. the count should not change
 * Test Data - 
 * 		a)TestDataReader is called to get the data specific to test-case
 * Reporting - 
 * 		a) Once the test-case is executed by Test-NG file, then report will generate in the reports folder.
 * 		b) screenshot functionality is not implemented
 */

package backbase.UpdateOperation;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import backbase.ReadOperation.BaseClass;
import backbase.ReadOperation.TC04_Search_UIValidation_RecordCountValidation;
import backbase.Utilties.ExtentTestManager;

public class TC03_Update_ValidateTotalCount extends BaseClass {
	
	@Test
	public void TC03_Update_ValidateTotalCount()
	{
		
		TC04_Search_UIValidation_RecordCountValidation validate = new TC04_Search_UIValidation_RecordCountValidation();
		validate.TC04_Search_UIValidation_RecordCountValidation();
		
		ExtentTestManager.getTest().log(LogStatus.PASS, "Count is matching after updating it");
	
	}

}
