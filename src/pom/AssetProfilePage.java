package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AssetProfilePage extends BasePage
{
	@FindBy(id="ctl00_F_PH_txtUnitNumber")
	private WebElement unitNumber;
	
	@FindBy(id="ctl00_F_PH_txtUnitNumber")
	private WebElement acquiredDate;
	
	@FindBy(id="ctl00_F_PH_cboInventoryTypeID_cboComboBoxControl")
	private WebElement type;
	
	@FindBy(id="ctl00_F_PH_cboUsageConditionID_cboComboBoxControl")
	private WebElement usageCondition;
	
	@FindBy(id="ctl00_F_PH_txtAccountNumber")
	private WebElement accountNumber;
	
	@FindBy(id="ctl00_F_PH_txtFactorCategoryID")
	private WebElement factorCategory;
	
	@FindBy(id="ctl00_F_PH_cboContract_cboComboBoxControl")
	private WebElement contractNumber;
	
	@FindBy(id="ctl00_F_PH_cboDivision_cboComboBoxControl")
	private WebElement divisionNumber;
	
	@FindBy(id="ctl00_F_PH_cboSubDivision_cboComboBoxControl")
	private WebElement subDivisionNumber;
	
	@FindBy(id="igtxtctl00_F_PH_txtLocation")
	private WebElement locationCode;
	
	@FindBy(id="ctl00_F_PH_txtLocationEffectiveFromDate_input")
	private WebElement effectiveDate;
	
	@FindBy(id="ctl00_F_PH_GLSegmentAssignment_grdGLSegmentAssignment_ci_0_3_0_cboSegmentValue")
	private WebElement company;
	
	@FindBy(id="")
	private WebElement deparment;
	
	@FindBy(id="")
	private WebElement saveButton;
	
	@FindBy(id="")
	private WebElement closeButton;

	public AssetProfilePage(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}

	
	
	
}
