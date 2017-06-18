package testscript;

import org.testng.annotations.Test;

import generic.BaseTest;
import pom.AssetListPage;
import pom.AssetMenuPage;
import pom.LeaseWaveHeader;


public class AssetProfileTest extends BaseTest
{
	@Test
	public void assetCreation() throws InterruptedException
	{

		LeaseWaveHeader lwh= new LeaseWaveHeader(driver);
		lwh.clickOnPortFolioManagement();
		AssetMenuPage asm= new AssetMenuPage(driver);
		asm.clickOnAssetMenu();
		asm.clickOnAssetProfile();
		AssetListPage  aslp= new AssetListPage(driver);
		aslp.clickOnaddButton();
		Thread.sleep(2000);
		
	}

}
