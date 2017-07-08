package testscript;

import org.testng.annotations.Test;

import generic.BaseTest;
import pom.AssetListPage;
import pom.CreateNewLeasePage;
import pom.CustomerListPage;
import pom.LeaseInventoryInLeasePage;
import pom.LeaseMenuPage;
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
		CustomerListPage cl=new CustomerListPage(driver);
		cl.enterAccountNumber("am-10088");
		cl.clickOnsearchButton();
		cl.clickOnSelectButton();
		CreateNewLeasePage clp= new CreateNewLeasePage(driver);
		clp.enterLeaseSequenceNumber("81");
		clp.clcikOnSaveButton();
		LeaseInventoryInLeasePage ilp=new LeaseInventoryInLeasePage(driver);
		ilp.clickOnAddButon();
		AssetListPage asl=new AssetListPage(driver);
		asl.searchByUnitNumber("81");
		asl.clickOnSearchButton();
		asl.selectCheckBox();
		Thread.sleep(2000);
		asl.clickONSelectButton();
		ilp.clickOnEditButton();
		ilp.enterOdometerReading("1200");
		ilp.enterDeliverydate();
		ilp.clickOnGridSaveButton();
		ilp.clickOnPageSaveButton();
	}

}
