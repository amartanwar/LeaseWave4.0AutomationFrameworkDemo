package testscript;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.excel;
import pom.LeaseEntryHomePage;
import pom.LeaseListPage;
import pom.LeaseMenuPage;
import pom.LeaseRebookParametersPage;

public class RebookLeaseTest extends BaseTest
{
	@Test
	public void leaseRebookSmokeTest() throws InterruptedException, IOException
	{
		String un=excel.getCellValue("./TestData/Input.xlsx", "AssetProfile", 4,0);
		
		//Open Lease Rebook
		LeaseMenuPage lm= new LeaseMenuPage(driver);
		lm.openLeaseRebookPage();
		
		//select a lease
		LeaseListPage ll= new LeaseListPage(driver);
		
		//enter unitNumber
		ll.searchByUnitNumber(un);
		
		//Click on search
		ll.clickOnSearchButton();
		
		//select the lease
		ll.clickONSelectButton();
		
		//enter rebook date
		LeaseRebookParametersPage lp=new LeaseRebookParametersPage(driver);
		lp.enterRebookDate();
		
		//click on save
		lp.clickOnSaveButton();
		
		//select the lease booking status
		LeaseEntryHomePage le=new LeaseEntryHomePage(driver);
		le.selectLeaseBookingStatus();
		
		//click on save Button
		le.clickOnSaveButton();
		
		//Handle popup
		le.handlePopup1();
		
		//Validate lease rebook
		le.verfyTittle("Lease List", "Lease rebook failed");
		
		
	}
}
