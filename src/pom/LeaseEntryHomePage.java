package pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import generic.BasePage;

public class LeaseEntryHomePage extends BasePage
{
	@FindBy(id="ctl00_F_PH_ComputeYield_cmdButtonControl")
	private WebElement leaseBookingStatus;

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
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
	}
	

}
