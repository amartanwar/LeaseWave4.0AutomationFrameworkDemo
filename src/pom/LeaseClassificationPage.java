package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.BasePage;

public class LeaseClassificationPage extends BasePage
{
	@FindBy(id="ctl00_F_PH_chkTransferofOwnership")
	private WebElement transferofOwnership;

	@FindBy(id="ctl00_F_PH_chkBargainPurchaseOption")
	private WebElement bargainPurchaseOption;

	@FindBy(id="ctl00_F_PH_cboLeaseTypeID_cboComboBoxControl")
	private WebElement leaseAccountingTreatment;

	@FindBy(id="ctl00_F_PH_cboGLTemplateID_cboGLTransaction")
	private WebElement leaseBookingGLTemplate;

	@FindBy(id="ctl00_F_PH_cboLTRToARGLTemplateID_cboGLTransaction")
	private WebElement ltrToARGLTemplate;

	@FindBy(id="ctl00_F_PH_cboClientLeaseType_cboComboBoxControl")
	private WebElement clientLeaseType;

	@FindBy(id="ctl00_Fr_PH_cmdnintyPercent_cmdButtonControl")
	private WebElement perform90PercentTestButton;

	@FindBy( id="ctl00_Fr_PH_cmdSave_cmdButtonControl")
	private WebElement saveButton;
	
	public LeaseClassificationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

}
