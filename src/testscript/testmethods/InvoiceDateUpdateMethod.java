package testscript.testmethods;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import generic.excel;
import pom.InvoiceDateUpdatePage;
import pom.UpdatesMenuPage;
import pom.jobListPage;

public class InvoiceDateUpdateMethod
{
	public void runInvoiceDateUpdate(WebDriver driver,int row) throws InterruptedException
	{
		String leaseSequenceNumber=excel.getCellValue("./TestData/Input.xlsx", "AssetProfile", row,0);
		//opening Lease Income recoginition screen
//		LeaseWaveHeader lw =new LeaseWaveHeader(driver);
//		lw.clickOnPortFolioManagement();
		UpdatesMenuPage um=new UpdatesMenuPage(driver);
		um.openInvoiceDateUpdatePage();
		
		//Selecting lease filter
		InvoiceDateUpdatePage le= new InvoiceDateUpdatePage(driver);
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
		
		Reporter.log("InvoiceDateUpdate method ran successfully", true);
	}
}
