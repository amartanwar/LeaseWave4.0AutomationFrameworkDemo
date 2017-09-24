package testscript;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.excel;
import pom.UpdatesMenuPage;
import pom.jobListPage;
import pom.leaseIncomeRecognitionPage;

public class RestructureLeaseIncomeUpdate extends BaseTest
{
	@Test
	public void LeaseIncomeUpdateTest() throws InterruptedException
	{
		String leaseSequenceNumber = excel.getCellValue("./TestData/Input.xlsx", "AssetProfile", 5,0);
		//opening Lease Income recoginition screen
//		LeaseWaveHeader lw =new LeaseWaveHeader(driver);
//		lw.clickOnPortFolioManagement();
		UpdatesMenuPage um=new UpdatesMenuPage(driver);
		um.openLeaseIncomeRecognition();
		
		//Selecting lease filter
		leaseIncomeRecognitionPage le=new leaseIncomeRecognitionPage(driver);
		le.clickOnLeaseFilter();
		
		//selecting lease Sequence Number radio button
		le.selectleaseSequenceNumber();
		
		//Entering Lease Sequence Number
		le.enterleaseSequenceNumber(leaseSequenceNumber);
		
		//Entering update Through Date
		le.enterupdateThroughDate("11/30/2020");
		
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
