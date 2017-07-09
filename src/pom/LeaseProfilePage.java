package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import generic.BasePage;

public class LeaseProfilePage extends BasePage
{
	@FindBy(id="ctl00_F_PH_cboOverTermPaymentARGLTemplateID_cboGLTransaction")
	private WebElement  otpARGLTemplate;

	@FindBy(id="ctl00_F_PH_cboOverTermPaymentIncomeGLTemplateID_cboGLTransaction")
	private WebElement otpIncomeGLTemplate;

	@FindBy(id="cctl00_F_PH_GLSegmentAssignment_grdGLSegmentAssignment_ci_0_3_0_cboSegmentValue")
	private WebElement glCompany;

	@FindBy(id="ctl00_F_PH_GLSegmentAssignment_grdGLSegmentAssignment_ci_0_3_1_cboSegmentValue")
	private WebElement glDepartment;

	@FindBy(id="ctl00_F_PH_cboReceiptCashGLTemplateID_cboGLTransaction")
	private WebElement receiptCashGLTemplate;

	@FindBy(id="ctl00_F_PH_cboInterimRentalGLTemplate_cboGLTransaction")
	private WebElement interimRentGLTemplate;

	@FindBy(id="ctl00_F_PH_cboProductChargeBillingType_cboComboBoxControl")
	private WebElement productChargeBillingType;

	@FindBy(id="ctl00_F_PH_cboLeaseRentalBillingType_cboComboBoxControl")
	private WebElement leaseRentalBillingType;

	@FindBy(id="ctl00_Fr_PH_cmdSave_cmdButtonControl")
	private WebElement saveButton;

	public LeaseProfilePage(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void selectOtpARGLTemplate()
	{
		Select se= new Select(otpARGLTemplate);
		se.selectByIndex(1);
	}
	
	public void selectotpIncomeGLTemplate()
	{
		Select se= new Select(otpIncomeGLTemplate);
		se.selectByIndex(1);
	}
	
	public void selectGLCompany()
	{
		Select se= new Select(glCompany);
		se.selectByIndex(1);
	}
	
	public void selectGLDepartment()
	{
		Select se= new Select(glDepartment);
		se.selectByIndex(1);
	}
	
	public void selectreceiptCashGLTemplate()
	{
		Select se= new Select(receiptCashGLTemplate);
		se.selectByIndex(1);
	}
	
	public void selectInterimRentGLTemplate()
	{
		Select se= new Select(interimRentGLTemplate);
		se.selectByIndex(1);
	}
	
	public void selectProductChargeBillingType()
	{
		Select se= new Select(productChargeBillingType);
		se.selectByIndex(1);
	}
	
	public void selectLeaseRentalBillingType()
	{
		Select se= new Select(leaseRentalBillingType);
		se.selectByIndex(1);
	}
	
	public void clickOnSaveButton()
	{
		saveButton.click();
	}

}
