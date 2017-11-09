package testscripts.Lease;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import generic.excel;
import pom.LeaseEntryHomePage;
import pom.LeaseListPage;
import pom.LeaseMenuPage;
import pom.LeaseRebookParametersPage;

public class LeaseRebookMethod
{
	public void leaseRebook(WebDriver driver,int row) throws InterruptedException, IOException
	{
		String leaseSequenceNumber = excel.getCellValue("./TestData/Input.xlsx", "AssetProfile", row,0);
		
        //Open Lease Rebook
		LeaseMenuPage lm1= new LeaseMenuPage(driver);
		lm1.openLeaseRebookPage();
		
		//select a lease
		Thread.sleep(2000);
		LeaseListPage ll1= new LeaseListPage(driver);
		
		//enter unitNumber
		ll1.searchByUnitNumber2(leaseSequenceNumber);
		
		//Click on search
		ll1.clickOnSearchButton();
		
		//select the lease
		ll1.clickONSelectButton();
		
		//enter rebook date
		LeaseRebookParametersPage lp=new LeaseRebookParametersPage(driver);
		lp.enterRebookDate();
		
		//click on save
		lp.clickOnSaveButton();
		
		//select the lease booking status
		LeaseEntryHomePage le=new LeaseEntryHomePage(driver);
		le.selectLeaseBookingStatus();
		
		Reporter.log("LeaseRebook method ran successfully", true);
		
		//click on save Button
		le.clickOnSaveButton();
		
		//Handle popup
		le.handlePopup1();
		
		//Validate lease rebook
		le.verfyTittle("Lease List", "Lease rebook failed");
		       
	}
}
