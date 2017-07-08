package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.BasePage;

public class LeaseAccrualPage extends BasePage
{
	@FindBy(id="ctl00_F_PH_ComputeYield_cmdButtonControl")
	private WebElement computeYieldButton;

	@FindBy(id="ctl00_Fr_PH_cmdSave_cmdButtonControl")
	private WebElement saveButton;
	
	public LeaseAccrualPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnComputeYieldButton()
	{
		computeYieldButton.click();
	}
	
	public void clickOnSaveButton()
	{
		saveButton.click();
	}

}
