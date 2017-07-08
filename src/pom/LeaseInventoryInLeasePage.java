package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import generic.BasePage;
import generic.SystemDate;

public class LeaseInventoryInLeasePage extends BasePage
{
	@FindBy(id="ctl00_F_PH_cmdImportAdd_cmdImportButton")
	private WebElement addButton;

	@FindBy(xpath=".//*[@id='ctl00xFxPHxgrdProfilexgrdList_rc_0_0']/nobr/input")
	private WebElement selectCheckBox;

	@FindBy(xpath=".//*[@id='ctl00xFxPHxgrdProfilexgrdList_rc_0_5']/nobr/input")
	private WebElement primaryAsset;

	@FindBy(id="ctl00_F_PH_cmdEdit_cmdButtonControl")
	private WebElement editButton;

	@FindBy(id="igtxtctl00_F_PH_txtOdometerReading")
	private WebElement deliveryOdometerReading;

	@FindBy(id="ctl00_F_PH_txtDeliveryDate_input")
	private WebElement deliveryDate;

	@FindBy( id="ctl00_F_PH_cmdGridSave_cmdButtonControl")
	private WebElement gridSaveButton;
	
	@FindBy(id="ctl00_Fr_PH_cmdSave1_cmdButtonControl")
	private WebElement PageSaveButton;

	public LeaseInventoryInLeasePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnAddButon()
	{
		addButton.click();
		for(String winHandle: driver.getWindowHandles())
		{
			driver.switchTo().window(winHandle);
		}
	}
	
	public void clickOnEditButton()
	{
		WebDriverWait wt= new WebDriverWait(driver, 20);
		wt.until(ExpectedConditions.visibilityOf(addButton));
		addButton.click();
	}
	
	public void enterOdometerReading(String odoMeterReading)
	{
		deliveryOdometerReading.sendKeys(odoMeterReading);
	}
	
	public void enterDeliverydate()
	{
		deliveryDate.sendKeys(SystemDate.currentDate());
	}
	
	public void enterDeliverydate(String date)
	{
		deliveryDate.sendKeys(date);
	}
	
	public void clickOnGridSaveButton()
	{
		gridSaveButton.click();
	}
	
	public void clickOnPageSaveButton() throws InterruptedException
	{
		Thread.sleep(2000);
		PageSaveButton.click();
	}

}
