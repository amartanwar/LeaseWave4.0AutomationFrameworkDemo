package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	
	public void clickOnNonZero()
	{
		nonZero.click();
	}
}
