package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.BasePage;

public  class AssetListPage extends BasePage
{

	@FindBy(id="ctl00_Fr_PH_cmdAdd_cmdButtonControl")
	private WebElement adddButton;
	
	@FindBy(id="ctl00_ctl04_lnkSignOut")
	public WebElement pageTitle;
	
	@FindBy(id="ctl00_F_PH_schSearchControl_bshBasicSearch_OneStringctl00_F_PH_schSearchControlrRrrRrrRr0rRr0mUnitNumber")
	private WebElement unitnumber;

	@FindBy(id="ctl00_F_PH_schSearchControl_cmdSearch_cmdButtonControl")
	private WebElement searchButton;


	@FindBy(xpath="//input[@class='igtbl_checkBox']")
	private WebElement chkBox;
	
	@FindBy(id="ctl00_Fr_PH_cmdSelect_cmdButtonControl")
	private WebElement selectButton;
	
	
	public AssetListPage(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnaddButton()
	{
		adddButton.click();
		
	}
	
	public void searchByUnitNumber(String unitNumber)
	{
		unitnumber.sendKeys(unitNumber);
	}
	
	public void clickOnSearchButton()
	{
		searchButton.click();
		
	}
	
	public void selectCheckBox()
	{
		chkBox.click();
		
	}
	
	public void clickONSelectButton()
	{
		selectButton.click();
		
	}
	
	
	
	
}
