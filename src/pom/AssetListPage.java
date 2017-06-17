package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public  class AssetListPage extends BasePage
{

	@FindBy(id="ctl00_Fr_PH_cmdAdd_cmdButtonControl")
	private WebElement adddButton;
	
	public AssetListPage(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnaddButton()
	{
		adddButton.click();
	}

}
