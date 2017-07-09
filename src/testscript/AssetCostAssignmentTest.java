package testscript;


import java.io.IOException;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.excel;
import pom.AssetListPage;
import pom.AssetMenuPage;
import pom.AssetValueAndStatusChangePage;
import pom.LeaseWaveHeader;

public class AssetCostAssignmentTest extends BaseTest
{
	@Test
	public void costAssignmentTest() throws InterruptedException, IOException
	{
		String unitNumber=excel.getCellValue("./TestData/Input.xlsx", "AssetProfile", 1,0);
		LeaseWaveHeader lwh=new LeaseWaveHeader(driver);
		lwh.clickOnPortFolioManagement();
		AssetMenuPage asm= new AssetMenuPage(driver);
		asm.openAssetCostAssignmentPage();
		AssetValueAndStatusChangePage asvl= new  AssetValueAndStatusChangePage(driver);
		asvl.clickOnCloseButton();
		AssetListPage asl=new AssetListPage(driver);
		asl.searchByUnitNumber(unitNumber);
		asl.clickOnSearchButton();
		asl.selectCheckBox();
		asl.clickONSelectButton();
		asvl.selectGridCheckBox();
		asvl.selectAssignmentOperator();
		asvl.enterCostOfAsset("1200");
		asvl.clickOnAddButton();
		asvl.clickOnAssignmentButton();
//		Thread.sleep(2000);
		asvl.selectGLTemplate();
		asvl.clickOnSaveButton();
		asvl.handlePopup();
		asvl.verfyTittle("Asset List", "failed");
		
				
		
	}
	
	
	

}
