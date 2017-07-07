package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.BasePage;

public class LeaseMenuPage extends BasePage
{
	@FindBy(id="ctl00ctl04WebMenuControl_2")
	private WebElement leaseMenu;

	@FindBy(xpath=".//*[@id='ctl00ctl04WebMenuControl_2_1']/td/div")
	private WebElement newLease;

	public LeaseMenuPage(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}

}
