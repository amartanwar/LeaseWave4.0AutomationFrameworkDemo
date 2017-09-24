package testscript;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.BaseTest;
import pom.LeaseEntryHomePage;
import pom.LeaseListPage;
import pom.LeaseMenuPage;
import pom.LeaseRebookParametersPage;

public class LeaseRebookTest extends BaseTest
{
	@Test
	public void leaseRebookSmokeTest() throws InterruptedException, IOException
	{
		//Open Lease Rebook
		LeaseMenuPage lm= new LeaseMenuPage(driver);
		lm.openLeaseRebookPage();
		
		//select a lease
		LeaseListPage ll= new LeaseListPage(driver);
		
		//enter unitNumber
		ll.searchByUnitNumber("Auto-602");
		
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
