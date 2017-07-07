package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.BasePage;

public  class LeaseWaveHeader extends BasePage
{
	@FindBy(xpath=".//*[@id='lnkMenuLA']/a")
	private WebElement portFoliomanagement;
	
	@FindBy(xpath=".//*[@id='lnkMenuWF']/a")
	private WebElement originationAndInstallation;
	
	@FindBy(xpath=".//*[@id='lnkMenuGL']/a")
	private WebElement generalLedger;
	
	@FindBy(xpath=".//*[@id='lnkMenuFM']/a")
	private WebElement fleetManagment;
	
	@FindBy(xpath=".//*[@id='lnkMenuCS']/a")
	private WebElement setup;
	
	
	public LeaseWaveHeader(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnPortFolioManagement()
	{
		portFoliomanagement.click();
	}
	
	public void clickOnoriginationAndInstallation()
	{
		originationAndInstallation.click();
	}
	
	public void clickOngeneralLedger()
	{
		generalLedger.click();
	}
	
	public void clickOnsetup()
	{
		setup.click();
	}
	
	

}
