package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import generic.BasePage;

public class ContractGeneralDetails extends BasePage
{
	@FindBy(id="ctl00_F_PH_txtContractID")
	private WebElement conNumber;
	
	@FindBy(id="ctl00_F_PH_txtContractName")
	private WebElement conName;
	
	@FindBy(id="ctl00_F_PH_txtInvoiceGroup")
	private WebElement invGroup;
	
	@FindBy(id="ctl00_F_PH_cboProductChargeBillingType_cboComboBoxControl")
	private WebElement productChargeBillingType;
	
	@FindBy(id="ctl00_F_PH_cboLeaseRentalBillingType_cboComboBoxControl")
	private WebElement leaseRentalBillingType;
	
	@FindBy(id="ctl00_F_PH_cboAmortizationType_cboComboBoxControl")
	private WebElement amortizationType;
	
	@FindBy(id="ctl00_F_PH_cboContractStatus_cboComboBoxControl")
	private WebElement contractStatus;
	
	@FindBy(id="ctl00_F_PH_ContactPersonAssignmentUC_cmdAddContact_cmdButtonControl")
	private WebElement addContact;
	
	@FindBy(id="ctl00_F_PH_ContactPersonAssignmentUC_txtFirstName")
	private WebElement firstName;
	
	@FindBy(id="ctl00_F_PH_ContactPersonAssignmentUC_pGL1_txtFilterText")
	private WebElement lastName;
	
	@FindBy(xpath=".//*[@id='ctl00xFxPHxContactPersonAssignmentUCxgrdContactTypes_rc_0_0']/nobr/input")
	private WebElement contactTypeBilling;
	
	@FindBy(xpath=".//*[@id='ctl00xFxPHxContactPersonAssignmentUCxgrdContactTypes_rc_10_0']/nobr/input")
	private WebElement contactTypeContract;
	
	@FindBy(id="ctl00_F_PH_ContactPersonAssignmentUC_ContactAddressUC1_cmdAddAddress_cmdButtonControl")
	private WebElement addAddress;
	
	@FindBy(id="ctl00_F_PH_ContactPersonAssignmentUC_ContactAddressUC1_pGL2_txtFilterText")
	private WebElement addressId;
	
	@FindBy(id="ctl00_F_PH_ContactPersonAssignmentUC_ContactAddressUC1_txtAddress")
	private WebElement address1;
	
	@FindBy(id="ctl00_F_PH_ContactPersonAssignmentUC_ContactAddressUC1_txtCity")
	private WebElement cty;
	
	@FindBy(id="igtxtctl00_F_PH_ContactPersonAssignmentUC_ContactAddressUC1_txtZIP")
	private WebElement pinCode;
	
	@FindBy(id="ctl00_F_PH_ContactPersonAssignmentUC_cmdSaveContacts_cmdButtonControl")
	private WebElement addressSaveButton;
	
	@FindBy(id="ctl00_Fr_PH_cmdSave_cmdButtonControl")
	private WebElement saveButton;

	public ContractGeneralDetails(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void enterContractNumber(String ContractNumber)
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.titleContains("Contract General Details"));
		conNumber.sendKeys(ContractNumber);
	}
	
	public void enterContractName(String ContractName)
	{
		conNumber.sendKeys(ContractName);
	}
	
	public void enterInvoiceGroup(String invoiceGroup)
	{
		conNumber.sendKeys(invoiceGroup);
	}
	
	public void selectProductChargeBillingType()
	{
		Select sc=new Select(productChargeBillingType);
		sc.selectByIndex(1);
	}
	
	public void selectLeaseRentalBillingType()
	{
		Select sc=new Select(leaseRentalBillingType);
		sc.selectByIndex(1);
	}
	
	public void selectAmortizationType()
	{
		Select sc=new Select(amortizationType);
		sc.selectByIndex(1);
	}
	
	public void clickOnAddContactDetails()
	{
		addContact.click();
	}
	
	public void enterFirstName(String frstName)
	{
		WebDriverWait wt=new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(firstName));
		firstName.sendKeys(frstName);
	}

	public void enterLastName(String frstName)
	{
		lastName.sendKeys(frstName);
	}
	
	public void addAddressDetails()
	{
		addAddress.click();
	}
	
	public void enterAddressid(String addId)
	{
		WebDriverWait wt=new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(addressId));
		addressId.sendKeys(addId);
	}
	
	public void enterAddress1(String add1)
	{
		address1.sendKeys(add1);
	}
	
	public void enterCity(String city)
	{
		cty.sendKeys(city);
	}
	
	public void enterZipCode(String zipCode)
	{
		pinCode.sendKeys(zipCode);
	}
	
	public void clickonSaveButton()
	{
		saveButton.click();
	}
}
