package testscript;

import java.awt.AWTException;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.excel;
import pom.SalesTaxUpdatePage;
import pom.UpdatesMenuPage;
import pom.jobListPage;

public class SalesTaxUpdateTest extends BaseTest
{
	@Test
	public void salesTaxUpdateSmokeTest() throws InterruptedException, AWTException
	{
		String leaseSequenceNumber=excel.getCellValue("./TestData/Input.xlsx", "AssetProfile", 1,0);
		
		//opening Lease Income recoginition screen
//		LeaseWaveHeader lw =new LeaseWaveHeader(driver);
//		lw.clickOnPortFolioManagement();
		UpdatesMenuPage um=new UpdatesMenuPage(driver);
		um.openSalesTaxUpdatePage();
		
		//Selecting lease filter
		SalesTaxUpdatePage le= new SalesTaxUpdatePage(driver);
		le.clickOnLeaseFilter();
		
		//selecting lease Sequence Number radio button
		le.selectleaseSequenceNumber();
		
		//Entering Lease Sequence Number
		le.enterleaseSequenceNumber(leaseSequenceNumber);
		
		//Entering update Through Date
		le.enterupdateThroughDate("7/15/2018");
		
		//Selecting run immediately
		le.clickOnrunImmediatelyr();
		
		//Clicking on Run Update
		le.clickOnrunUpdate();
		
		//Clicking on JobId
		le.clickOnJobId();
		
		//Validation job status
		jobListPage jl= new jobListPage(driver);
		jl.validateJobStatus();
	}
}
