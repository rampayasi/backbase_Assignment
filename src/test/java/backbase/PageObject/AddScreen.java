package backbase.PageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class AddScreen {

WebDriver ldriver;

public AddScreen(WebDriver rdriver)
{
	ldriver = rdriver;
	PageFactory.initElements(rdriver, this);
	}

//Add button from home screen
@FindBy(xpath = "//a[@id='add']")
WebElement newComputerButton;

@FindBy(xpath = "//section[@id='main']/h1")
WebElement addScreenHeading;

@FindBys(@FindBy(tagName = "label"))
List<WebElement> fieldLabel;

@FindBy(xpath = "//div[@class='input']/input[@id='name']")
WebElement computerNameFieldInput;

@FindBy(xpath= "//div[@class='input']/input[@id='introduced']")
WebElement introducedDate;

@FindBy(xpath = "//div[@class='input']/input[@id='discontinued']")
WebElement discontinuedDate;

@FindBy(xpath ="//select[@id='company']")
WebElement selectCompany;

@FindBy(xpath ="//input[@type='submit']")
WebElement createThisComputer;

@FindBy(xpath = "//a[@class='btn']")
WebElement cancelButton;

@FindBy(xpath = "//span[@class='help-inline']")
WebElement helpingLabel;

@FindBy(xpath = "//a[contains(text(),'Play sample application — Computer database')]")
WebElement HomescreenLabel;

@FindBy(xpath = "//section[@id='main']/div[1]")
WebElement alertMessage;

@FindBy(xpath = "//div[@class='clearfix error']")
WebElement madatoryFieldError;


//getter methods

public WebElement getAddNewComputerButton() {
	return newComputerButton;
}

public WebElement getAddScreenHeading()
{
	return addScreenHeading;
	}

public List<WebElement> getFieldLabel() {
	return fieldLabel;
}

public WebElement getComputerNameFieldInput() {
	
	return computerNameFieldInput;
}

public WebElement getIntroducedDate() {
	
	return introducedDate;
}

public WebElement getDiscontinuedDate()
{
	return discontinuedDate;
	}

public WebElement getSelectCompany() {
	return selectCompany;
}

public WebElement getCreateThisComputer()
{return createThisComputer;
	}

public WebElement getCancelButton()
{ return cancelButton;
	}

public WebElement getHelpingLabel()
{return helpingLabel;
	}

public WebElement getHomeSceenLabel()
{
	return HomescreenLabel;
}

public WebElement getAlertMessage()
{
	return alertMessage;
}

public WebElement getMandatoryError()
{
	return madatoryFieldError;
	}



}


