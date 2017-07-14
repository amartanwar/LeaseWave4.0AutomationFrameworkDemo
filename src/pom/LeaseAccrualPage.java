package pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
		WebDriverWait wt=new WebDriverWait(driver, 100);
		wt.until(ExpectedConditions.visibilityOf(computeYieldButton));
		System.out.println(driver.getTitle());
		computeYieldButton.click();
	}
	
	public void clickOnSaveButton() throws InterruptedException
	{
		WebDriverWait wt=new WebDriverWait(driver, 100);
		wt.until(ExpectedConditions.elementToBeClickable(computeYieldButton));
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

}
