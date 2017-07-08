package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import generic.BasePage;

public class AssetMenuPage extends BasePage
{

	@FindBy(id="ctl00ctl04WebMenuControl_3")
	private WebElement assetLink;
	
	@FindBy(xpath=".//*[@id='ctl00ctl04WebMenuControl_3_2']/td/div")
	private WebElement assetProfile;
	
	@FindBy(xpath=".//*[@id='ctl00ctl04WebMenuControl_3_11']/td/div")
	private WebElement valueAndStatusChange;
	
	@FindBy(xpath=".//*[@id='ctl00ctl04WebMenuControl_3_11_1']/td/div")
	private WebElement Zero;
	
	@FindBy(xpath=".//*[@id='ctl00ctl04WebMenuControl_3_11_2']/td/div")
	private WebElement nonZero;
	
	
	@FindBy(xpath=".//*[@id='ctl00ctl04WebMenuControl_3_1']/td/div")
	private WebElement locationSetup;
	

	public AssetMenuPage(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnAssetMenu()
	{
		assetLink.click();
	}
	
	public void clickOnAssetProfile()
	{
		assetProfile.click();
	}
	public void clickOnvalueAndStatusChanges()
	{
		valueAndStatusChange.click();
	}
	
	public void openAssetCostAssignmentPage() throws InterruptedException
	{
			Actions action=new Actions(driver);
			action.moveToElement(assetLink).perform();
			Thread.sleep(2000);
			action.moveToElement(valueAndStatusChange).perform();
			Thread.sleep(2000);
			action.moveToElement(Zero);
			Thread.sleep(2000);
			action.moveToElement(nonZero).click().perform();
	}
}
