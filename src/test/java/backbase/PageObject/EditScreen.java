package backbase.PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class EditScreen {

	WebDriver ldriver;
	
	public EditScreen(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);	
	}
	// search text field on home screen
	@FindBy(xpath = "//input[@id='searchbox']")
	WebElement searchTextField;

	@FindBy(xpath = "//input[@id='searchsubmit']")
	WebElement searchButton;
	
	
	@FindBy(xpath = "//section[@id='main']/h1")
	WebElement editComuterHeading;
	
	@FindBy(xpath ="//input[@id='name']")
	WebElement editComputerName;
	
	@FindBy(xpath ="//input[@id='introduced']")
	WebElement editIntroducedDate;
	
	@FindBy(xpath = "//input[@id='discontinued']")
	WebElement editDiscontinuedDate;
	
	@FindBy(xpath ="//select[@id='company']")
	WebElement selectCompany;
	
	@FindBys(@FindBy (xpath = "//table[@class='computers zebra-striped']/thead/tr[1]//th"))
	List<WebElement> columnHeader;
	
	@FindBy(xpath = "//input[@class='btn primary']")
	WebElement updateComputerName;
	
	// Below are the webelement to validate the search table data

	@FindBys(@FindBy(xpath = "//table[@class='computers zebra-striped']/tbody/tr") )
	List<WebElement> tableRecords;
	
	@FindBy(xpath = "//div[@class='alert-message warning']")
	WebElement updateAlertMessage;
	
	
	
	
	
	public WebElement getUpdateAlertMessage()
	{
		return updateAlertMessage;
	}
	
	
	public WebElement getEditComputerName()
	{
		return editComputerName;
	}
	
	public WebElement getEditIntroducedDate()
	{
		return editIntroducedDate;
	}
	
	
	public WebElement getEditDiscontinuedDate()
	{
		return editDiscontinuedDate;
	}
	
	public WebElement getEditCompany()
	{
		return selectCompany;
	}
	
	public WebElement getSearchTextField()
	{
		return searchTextField; }


	public WebElement getSearchButton()
	{
		return searchButton;
		}
	
	public int getTableRecords()
	{
		return tableRecords.size();
		}
	
	public WebElement getEditHeading()
	{
		return editComuterHeading;
	}
	
	public WebElement getAllRecordForUpdate(int i)
	{
		String xpath = "//table[@class='computers zebra-striped']/tbody/tr/td[%s]".formatted(i);
		WebElement ee = ldriver.findElement(By.xpath(xpath));
		return ee;
		
	}
	
	
	public WebElement getComputerNameForUpdate(int j, int k)
	{
		String row_xpath = "//table[@class='computers zebra-striped']/tbody/tr[%s]/td[%s]/a".formatted(j,k);
		WebElement ef = ldriver.findElement(By.xpath(row_xpath));
		return ef;
		
	}
	
	
	public int numberOfColumns()
	{
		int n = columnHeader.size();
		return n;
	}
	
	public WebElement getUpdateoComputerNameButton()
	{
		return updateComputerName;
		
	}
	
	
}
