package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.BasePage;

public class AssetValueAndStatusChangePage extends BasePage
{
	@FindBy(xpath="//input[@class='igtbl_checkBox']")
	private WebElement gridCheckBox;

	@FindBy(id="ctl00_F_PH_grdList_AssignmentListControl_fields")
	private WebElement assignmentDropDown;

	@FindBy(id="igtxtctl00_F_PH_grdList_txtCurrency_ALBrRrrRrrRr0rRr10")
	private WebElement costAssignmentTextbox;

	@FindBy(xpath=".//*[@id='ctl00_F_PH_grdList_AssignmentListControl_entryButtons']/button")
	private WebElement addButton;

	@FindBy(id="ctl00_F_PH_grdList_cmdAssign_cmdButtonControl")
	private WebElement assignmentButton;

	@FindBy(id="ctl00_F_PH_cboGLTemplate_cboGLTransaction")
	private WebElement glTemplate;

	@FindBy(id="ctl00_Fr_PH_cmdSave_cmdButtonControl")
	private WebElement saveButton;
	
	public AssetValueAndStatusChangePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

}