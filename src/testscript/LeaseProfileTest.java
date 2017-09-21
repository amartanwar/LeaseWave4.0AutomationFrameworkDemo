package testscript;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.excel;
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
import pom.LeasePaymentSchedulePage;
import pom.LeaseProfilePage;
import pom.LeaseStructurePage;

public class LeaseProfileTest extends BaseTest
{
	@Test
	public void LeaseProfileCreationSmokeTest() throws InterruptedException, AWTException, IOException
	{
		//Fetching values from xl
		String un=excel.getCellValue("./TestData/Input.xlsx", "AssetProfile", 1,0);
		
		//Opening the lease lease creation page
//		LeaseWaveHeader lwh=new LeaseWaveHeader(driver);
//		lwh.clickOnPortFolioManagement();
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
		clp.enterLeaseSequenceNumber(un);
		clp.clcikOnSaveButton();
		
		//LeaseInventoryInlease screen
		LeaseInventoryInLeasePage ilp=new LeaseInventoryInLeasePage(driver);
		String beforeWindow = driver.getWindowHandle();
		ilp.clickOnAddButon();
		//AssetList page
		AssetListPage asl=new AssetListPage(driver);
		asl.searchByUnitNumber(un);
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
		lp.selectProductChargeBillingType();
		lp.selectLeaseRentalBillingType();
		lp.clickOnSaveButton();
	
		
		//leaseInvestment screen
		LeaseEntryHomePage le=new LeaseEntryHomePage(driver);
		le.clickOnInvestmentScreen();
		LeaseInvestementPage li=new LeaseInvestementPage(driver);
		li.clickOnSaveButton();
		
		//LeaseIDC setup screen
		LeaseIDCSetupPage lIDC=new LeaseIDCSetupPage(driver);
		lIDC.clickOnCloseButton();
		
		//Lease Structure screen
		le.clickOnStructureScreen();
		LeaseStructurePage ls= new LeaseStructurePage(driver);
		ls.enterNumberofPayments("12");
		ls.enterCommencementDate("7/1/2017");
		Thread.sleep(2000);
		ls.enterRegularTotalPayment("1200");
		ls.enterRegularAdminFee("1000");
		ls.enterGLPostDate();
		ls.clickOnSaveButton();
		
		LeasePaymentSchedulePage lps=new LeasePaymentSchedulePage(driver);
		lps.clickOnCloseButton();
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
		le.selectLeaseBookingStatus();
		le.clickOnSaveButton();
		le.handlePopup1();
//		le.handlePopup2();
		
		//validating Result
		le.verfyTittle("Lease List", "Lease creation test pass");
	}

}
