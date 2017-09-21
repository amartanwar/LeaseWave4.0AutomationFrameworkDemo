package testscript;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import generic.BaseTest;
import pom.ContractBillingMethodPage;
import pom.ContractDivisionListPage;
import pom.ContractGeneralDetails;
import pom.ContractListPage;
import pom.ContractSetupHomePage;
import pom.CustomerListPage;
import pom.CustomerMenuPage;
import pom.LeaseWaveHeader;

public class ContractSetupTest extends BaseTest
{
	@Test
	public void contractprofileSmokeTesting() throws AWTException, IOException, InterruptedException
	{
		//Opening Contract Setup
		LeaseWaveHeader lw=new LeaseWaveHeader(driver);
		lw.clickOnPortFolioManagement();
		CustomerMenuPage cm=new CustomerMenuPage(driver);
		cm.openContractSetup();
		
		//selecting customer
		CustomerListPage cl= new CustomerListPage(driver);
		cl.enterAccountNumber("am-10088");
		cl.clickOnsearchButton();
		cl.clickOnSelectButton();
		
		//Adding Contract
		ContractListPage col=new ContractListPage(driver);
		col.clickOnAddButton();
		
		//Entering Contract Number
		ContractGeneralDetails cg=new ContractGeneralDetails(driver);
		cg.enterContractNumber("autoCont-15");
		
		//Entering COntract Name
		cg.enterContractName("autocon-15");
		
		//Entering Invoice group
		cg.enterInvoiceGroup("As");
		
		//selecting ProductChargeBilling Type
		cg.selectProductChargeBillingType();
		
		//Selecting leaseRentalBillingType
		cg.selectLeaseRentalBillingType();
		
		//Selecting Amortization type
		cg.selectAmortizationType();
		
		//selecting Contract Status
		cg.selectContractStatus(1);
		
		//Adding contact details
		cg.clickOnAddContactDetails();
		cg.enterFirstName("auto-14");
		cg.enterLastName("auto-14");
		cg.selectContactTypeBilling();
		cg.selectContactTypeContract();
		cg.selectContactTypeDivision();
		cg.selectContactTypeSubDivision();
		
		//Adding Address details
		cg.clickOnAddAddressDetails();
		cg.enterAddressid("auto-14");
		cg.enterAddress1("auto-14");
		cg.enterCity("auto-1");
		cg.selectStateId();
		cg.enterZipCode("14345");
		cg.clickOnsaveContactDetails();
		
		//Saving contract
		cg.clickonSaveButton();
		
		//
		ContractDivisionListPage cd=new ContractDivisionListPage(driver);
		cd.clickOnCloseButton();
		
		//***********************Adding Billing Details******************************//
		
		//Opening Billing Setup screen
		ContractSetupHomePage ch=new ContractSetupHomePage(driver);
		ch.clickOnBillingMethod();
		
		//Clicking on Add button
		ContractBillingMethodPage cb= new ContractBillingMethodPage(driver);
		cb.clickOnAddButton();
		
		//Selecting Parameter Type
		cb.selectparameterType();
		cb.selectDefaultcheckBox();
		
		//selecting Frequency
		cb.selectFrequency();
		
		//selecting day of month
		cb.selectDayOfMoth();
		
		//Entering DaysAfterInvoiceGeneration
		cb.enterDaysAfterInvoiceGeneration();
		
		//Local SaveBillingDetails
		cb.clickOnlocalsaveBillingDetails();
		
		//Global SaveBillingDetails
		cb.clickOnglobalsaveBillingDetails();
		
		//global save contract setup
		ch.clickOnCloseButton();
		
		//Validation contract setup
		ch.verfyTittle("Contract List", "Contract setup smoke test pass");
		
	}
}

