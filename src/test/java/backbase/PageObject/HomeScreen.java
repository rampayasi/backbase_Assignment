package backbase.PageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class HomeScreen {

WebDriver ldriver;

public HomeScreen(WebDriver rdriver)
{
	ldriver = rdriver;
	PageFactory.initElements(rdriver, this);
}

// Column name
@FindBy(xpath = "//a[contains(text(),'Play sample application — Computer database')]")
WebElement HomescreenLabel;

@FindBy(xpath = "//a[contains(text(),'Computer name')]")
WebElement firstColumnOfTable;

@FindBy(xpath = "//a[contains(text(),'Introduced')]")
WebElement secondColumnOfTable;

@FindBy(xpath = "//a[contains(text(),'Discontinued')]")
WebElement thrirdColumnOfTable;

@FindBy(xpath = "//a[contains(text(),'Company')]")
WebElement fourthColumnOfTable;

// Below are the webElement for search field and button to search

@FindBy(xpath = "//input[@id='searchbox']")
WebElement searchTextField;

@FindBy(xpath = "//input[@id='searchsubmit']")
WebElement searchButton;


//Below is the Webelement for Add a new button
@FindBy(xpath = "//a[@id='add']")
WebElement newComputerButton;

//Below are the WebElement for count of records
@FindBy(xpath = "//section[@id='main']/h1")
WebElement recordsCountInTitle;

@FindBy(xpath = "//div[@class='pagination']/ul/li[2]/a")
WebElement recordonPagination;


// Below are the webelement to validate the search table data

@FindBys(@FindBy(xpath = "//table[@class='computers zebra-striped']/tbody/tr/td[1]") )
List<WebElement> tableRecords;





// Below are the functions for getting the element
public WebElement getHomeSceenLabel()
{
	return HomescreenLabel;
}

public WebElement getFirstColumnNameofSearchTable()
{
	return firstColumnOfTable;
	}

public WebElement getSecondColumnNameofSearchTable()
{
	return secondColumnOfTable;
	}

public WebElement getThirdColumnNameofSearchTable()
{
	return thrirdColumnOfTable;
	}

public WebElement getFourthColumnNameofSearchTable()
{
	return fourthColumnOfTable;
	}

public WebElement getSearchTextField()
{
	return searchTextField; }


public WebElement getSearchButton()
{
	return searchButton;
	}

public WebElement getNewComputerButton()
{
	return newComputerButton;
	}

public WebElement getRecordCountOnTitle()
{
	return recordsCountInTitle;
	}

public WebElement getRecordOnPagination()
{
	return recordonPagination;
	}


public List<WebElement> getTableRecords()
{
	return tableRecords;
	}


}
