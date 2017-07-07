package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.BasePage;

public class LeasePaymentSchedulePage extends BasePage
{
	@FindBy(id="ctl00_Fr_PH_cmdClose_cmdButtonControl")
	private WebElement closeButton;

	public LeasePaymentSchedulePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

}
