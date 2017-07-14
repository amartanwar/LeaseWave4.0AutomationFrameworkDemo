package testscript;

import org.testng.annotations.Test;

import generic.BaseTest;
import pom.LeaseWaveHeader;
import pom.MovingLongTermtoShorTermUpdatePage;
import pom.UpdatesMenuPage;

public class LtrToArUpdatetest extends BaseTest
{
	@Test
	
	public void testLtrToArUpdate()
	{
		LeaseWaveHeader lw= new LeaseWaveHeader(driver);
		lw.clickOnPortFolioManagement();
		UpdatesMenuPage up=new UpdatesMenuPage(driver);
		up.openMovingLongTermToShortTerm();
		
		MovingLongTermtoShorTermUpdatePage ltr= new MovingLongTermtoShorTermUpdatePage(driver);
		ltr.clickOnLeaseFilter();
		ltr.selectleaseSequenceNumber();
		ltr.enterleaseSequenceNumber("auto-57");
		ltr.enterupdateThroughDate("7/15/2018");
		ltr.clickOnrunImmediatelyr();
		ltr.clickOnrunUpdate();
	}

}
