package testscript;

import org.testng.annotations.Test;

import generic.BaseTest;
import pom.AssetListPage;
import pom.CreateNewLeasePage;
import pom.CustomerListPage;
import pom.LeaseAccrualPage;
import pom.LeaseClassificationPage;
import pom.LeaseEntryHomePage;
import pom.LeaseIDCSetupPage;
import pom.LeaseInventoryInLeasePage;
import pom.LeaseInvestementPage;
import pom.LeaseMenuPage;
import pom.LeaseProfilePage;
import pom.LeaseStructurePage;
import pom.LeaseWaveHeader;

public class LeaseProfileTest extends BaseTest
{
	@Test
	public void LeaseProfileCreationTest() throws InterruptedException
	{
		LeaseWaveHeader lwh=new LeaseWaveHeader(driver);
		lwh.clickOnPortFolioManagement();
		LeaseMenuPage lm=new LeaseMenuPage(driver);
		lm.clickOnLeaseMenu();
		lm.clickOnNewLease();
		
		//Customer list screen
		CustomerListPage cl=new CustomerListPage(driver);
		cl.enterAccountNumber("am-10088");
		cl.clickOnsearchButton();
		cl.clickOnSelectButton();
		
		//create new Lease screen
		CreateNewLeasePage clp= new CreateNewLeasePage(driver);
		clp.enterLeaseSequenceNumber("auto-11");
		clp.clcikOnSaveButton();
		
		//LeaseInventoryInlease screen
		LeaseInventoryInLeasePage ilp=new LeaseInventoryInLeasePage(driver);
		String beforeWindow = driver.getWindowHandle();
		ilp.clickOnAddButon();
		//AssetList page
		AssetListPage asl=new AssetListPage(driver);
		asl.searchByUnitNumber("auto-12");
		asl.clickOnSearchButton();
		asl.selectCheckBox();
		Thread.sleep(2000);
		asl.clickOnSelectExportButton();
		driver.switchTo().window(beforeWindow);
		//LeaseInventoryInlease screen
		Thread.sleep(2000);
		ilp.selectAsset();
		ilp.selectPrimaryAsset();
		ilp.clickOnEditButton();
		ilp.enterOdometerReading("1200");
		ilp.enterDeliverydate();
		ilp.clickOnGridSaveButton();
		ilp.clickOnPageSaveButton();
		
		//Lease Profile screen
		LeaseProfilePage lp=new LeaseProfilePage(driver);
		lp.selectOtpARGLTemplate();
		lp.selectotpIncomeGLTemplate();
		lp.selectGLCompany();
		lp.selectGLDepartment();
		lp.selectInterimRentGLTemplate();
		lp.selectreceiptCashGLTemplate();
		lp.selectLeaseRentalBillingType();
		lp.selectProductChargeBillingType();
		lp.clickOnSaveButton();
		
		//leaseInvestment screen
		LeaseInvestementPage li=new LeaseInvestementPage(driver);
		li.clickOnSaveButton();
		
		//LeaseIDC setup screen
		LeaseIDCSetupPage lIDC=new LeaseIDCSetupPage(driver);
		lIDC.clickOnCloseButton();
		
		//Lease Structure screen
		LeaseStructurePage ls= new LeaseStructurePage(driver);
		ls.enterNumberofPayments("12");
		ls.enterCommencementDate("7/9/2017");
		ls.enterCommencementTotalPayment("1200");
		ls.enterGLPostDate();
		ls.clickOnSaveButton();
		
		//Lease Classification screen
		LeaseClassificationPage lc= new LeaseClassificationPage(driver);
		lc.selectBargainPurchaseOption();
		lc.selectLeaseAccountingTreatment();
		lc.selectLeaseBookingGLTemplate();
		lc.selectLtrToARGLTemplate();
		lc.selectClientLeaseType();
		lc.clickOnPerform90PercentTestButton();
		Thread.sleep(2000);
		lc.clickOnSaveButton();
		
		//LeaseAccrual screen
		LeaseAccrualPage la=new LeaseAccrualPage(driver);
		la.clickOnComputeYieldButton();
		la.clickOnSaveButton();
		la.handlePopup();
		
		//LeaseEntryHome screen
		LeaseEntryHomePage le=new LeaseEntryHomePage(driver);
		le.selectLeaseBookingStatus();
		le.clickOnSaveButton();
		le.handlePopup();
		le.handlePopup();
	}

}
