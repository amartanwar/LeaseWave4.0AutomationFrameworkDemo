package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.BasePage;

public class LeaseProfilePage extends BasePage
{
	@FindBy(id="ctl00_F_PH_cmdImportAdd_cmdImportButton")
	private WebElement  otpARGLTemplate;

	@FindBy(id="ctl00_F_PH_cmdImportAdd_cmdImportButton")
	private WebElement otpIncomeGLTemplate;

	@FindBy(id="ctl00_F_PH_cmdImportAdd_cmdImportButton")
	private WebElement glCompany;

	@FindBy(id="ctl00_F_PH_cmdImportAdd_cmdImportButton")
	private WebElement glDepartment;

	@FindBy(id="ctl00_F_PH_cmdImportAdd_cmdImportButton")
	private WebElement receiptCashGLTemplate;

	@FindBy(id="ctl00_F_PH_cmdImportAdd_cmdImportButton")
	private WebElement interimRentGLTemplate;

	@FindBy(id="ctl00_FPH_cmdImportAdd_cmdImportButton")
	private WebElement productChargeBillingType;

	@FindBy(id="ctl00_F_PH_cmdImportAdd_cmdImportButton")
	private WebElement leaseRentalBillingType;

	@FindBy(id="ctl00_Fr_PH_cmdSave_cmdButtonControl")
	private WebElement saveButton;

	public LeaseProfilePage(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}

}
