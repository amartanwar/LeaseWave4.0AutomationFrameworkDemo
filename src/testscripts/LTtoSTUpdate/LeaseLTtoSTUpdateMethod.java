package testscripts.LTtoSTUpdate;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import generic.excel;
import pom.MovingLongTermtoShorTermUpdatePage;
import pom.UpdatesMenuPage;
import pom.jobListPage;

public class LeaseLTtoSTUpdateMethod 
{
	public void runLeaseLTtoSTUpdate(WebDriver driver,int row) throws InterruptedException
	{
		String leaseSequenceNumber=excel.getCellValue("./TestData/Input.xlsx", "AssetProfile", row,0);
		
		UpdatesMenuPage up=new UpdatesMenuPage(driver);
		up.openMovingLongTermToShortTerm();
		
		//selecting lease filter
		MovingLongTermtoShorTermUpdatePage ltr= new MovingLongTermtoShorTermUpdatePage(driver);
		ltr.clickOnLeaseFilter();
		
		//selecting Lease Sequence Number radio button
		ltr.selectleaseSequenceNumber();
	
		//Entering Lease Sequence Number
		ltr.enterleaseSequenceNumber(leaseSequenceNumber);
		
		//Entering update Through Date
		ltr.enterupdateThroughDate("7/15/2018");
		
		//Selecting Immediate run
		ltr.clickOnrunImmediatelyr();
		
		//Clicking on run update button
		ltr.clickOnrunUpdate();
		
		//selecting jobId
		ltr.clickOnJobId();
		
		//Validating job status
		jobListPage jl=new jobListPage(driver);
		jl.validateJobStatus();
		
		Reporter.log("LeaseLTtoSTUpdate method ran successfully", true);
	}
}
