package backbase.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteScreen {

	WebDriver ldriver;
	
	public DeleteScreen(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	
	// search text field on home screen
		@FindBy(xpath = "//input[@id='searchbox']")
		WebElement searchTextField;

		@FindBy(xpath = "//input[@id='searchsubmit']")
		WebElement searchButton;
		
		@FindBy(xpath = "//input[@class='btn danger']")
		WebElement deleteButton;
		
		
		public WebElement getDeleteButton()
		{
			return deleteButton;
		}
		
	
		public WebElement getSearchTextField()
		{
			return searchTextField;
		}
	
		public WebElement getSearchButton()
		{
			return searchButton;
		}
		
		
		public WebElement getComputerNameForUpdate(int j, int k)
		{
			String row_xpath = "//table[@class='computers zebra-striped']/tbody/tr[%s]/td[%s]/a".formatted(j,k);
			WebElement ef = ldriver.findElement(By.xpath(row_xpath));
			return ef;
			
		}
		
	
}
