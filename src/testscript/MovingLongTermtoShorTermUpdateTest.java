package testscript;

import org.testng.annotations.Test;

import generic.BaseTest;
import pom.LeaseWaveHeader;
import pom.MovingLongTermtoShorTermUpdatePage;
import pom.UpdatesMenuPage;
import pom.jobListPage;

public class MovingLongTermtoShorTermUpdateTest extends BaseTest
{
	@Test
	public void testLtrToArUpdate() throws InterruptedException
	{
		//opening MovingLongTermtoShorTermUpdatePage
		LeaseWaveHeader lw= new LeaseWaveHeader(driver);
		lw.clickOnPortFolioManagement();
		UpdatesMenuPage up=new UpdatesMenuPage(driver);
		up.openMovingLongTermToShortTerm();
		
		//slecting lease filter
		MovingLongTermtoShorTermUpdatePage ltr= new MovingLongTermtoShorTermUpdatePage(driver);
		ltr.clickOnLeaseFilter();
		
		//selecting Lease Sequence Number radio button
		ltr.selectleaseSequenceNumber();
		
		//Entering Lease Sequence Number
		ltr.enterleaseSequenceNumber("auto-64");
		
		//Entering update Through Date
		ltr.enterupdateThroughDate("7/15/2018");
		
		//Selecting Immediate run
		ltr.clickOnrunImmediatelyr();
		
		//Clicking on runupdate button
		ltr.clickOnrunUpdate();
		
		//selecting jobId
		ltr.clickOnJobId();
		
		//Validating job status
		jobListPage jl=new jobListPage(driver);
		jl.validateJobStatus();
	}

}
