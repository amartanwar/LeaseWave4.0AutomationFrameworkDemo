package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.BasePage;

public class LeaseEntryHomePage extends BasePage
{
	@FindBy(id="ctl00_F_PH_ComputeYield_cmdButtonControl")
	private WebElement leaseBookingStatus;

	@FindBy(id="ctl00_NB_PH_UCLeaseEntyLink_cmdSave_cmdButtonControl")
	private WebElement saveButton;

	public LeaseEntryHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

}
