package testscript;

import org.testng.annotations.Test;

import generic.BaseTest;
import pom.UpdatesMenuPage;
import pom.jobListPage;
import pom.leaseIncomeRecognitionPage;

public class LeaseIncomeRecognitionTest extends BaseTest
{
	@Test
	public void LeaseIncomeUpdateSmokeTest() throws InterruptedException
	{
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
		le.enterleaseSequenceNumber("auto-85");
		
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
