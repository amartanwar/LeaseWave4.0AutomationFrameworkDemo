package testscript;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.excel;
import pom.AssetListPage;
import pom.AssetMenuPage;
import pom.AssetValueAndStatusChangePage;

public class AssetBulkCostAssignmentTest extends BaseTest
{
	@Test
	public void AssetBulkCostAssignment1() throws InterruptedException, IOException
	{
//		LeaseWaveHeader lwh=new LeaseWaveHeader(driver);
//		lwh.clickOnPortFolioManagement();
		AssetMenuPage asm= new AssetMenuPage(driver);
		asm.openAssetCostAssignmentPage();
		AssetValueAndStatusChangePage asvl= new  AssetValueAndStatusChangePage(driver);
		asvl.clickOnCloseButton();
		
		for(int i=1;i<=5;i++)
		{
			String unitNumber=excel.getCellValue("./TestData/Input.xlsx", "AssetProfile", i,0);
			String cost=excel.getNumericCellValue("./TestData/Input.xlsx", "AssetProfile", i,11);
			AssetListPage asl=new AssetListPage(driver);
			asl.searchByUnitNumber(unitNumber);
			asl.clickOnSearchButton(unitNumber);
			Thread.sleep(1000);
			asl.selectCheckBox();
			asl.clickONSelectButton();
			asvl.selectGridCheckBox();
			asvl.selectAssignmentOperator();
			asvl.enterCostOfAsset(cost);
			asvl.clickOnAddButton();
			asvl.clickOnAssignmentButton();
//			Thread.sleep(2000);
			asvl.selectGLTemplate();
			asvl.clickOnSaveButton();
			asvl.handlePopup();
			asvl.verfyTittle("Asset List", "failed");
			Reporter.log("Cost Assignment is done for "+unitNumber);
		}
		
	}
	
}
