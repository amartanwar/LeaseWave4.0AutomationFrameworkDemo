package pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import generic.BasePage;

public class LeaseEntryHomePage extends BasePage
{
	@FindBy(id="ctl00_F_PH_ComputeYield_cmdButtonControl")
	private WebElement leaseBookingStatus;
	
	@FindBy(id="ctl00_NB_PH_UCLeaseEntyLink_cmdInvestment")
	private WebElement investmentScreen;
	
	@FindBy(id="ctl00_NB_PH_UCLeaseEntyLink_cmdStructure")
	private WebElement structureScreen;

	@FindBy(id="ctl00_NB_PH_UCLeaseEntyLink_cmdSave_cmdButtonControl")
	private WebElement saveButton;

	public LeaseEntryHomePage(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void selectLeaseBookingStatus()
	{
		Select se=new Select(leaseBookingStatus);
		se.selectByIndex(1);
	}
	
	public void clickOnSaveButton()
	{
		saveButton.click();
	}
	
	public void handlePopup()
	{
		WebDriverWait wt=new WebDriverWait(driver, 100);
		wt.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
	}
	
	public void clickOnStructureScreen()
	{
		structureScreen.click();
	}
	
	public void clickOnInvestmentScreen()
	{
		investmentScreen.click();
	}
	

}
