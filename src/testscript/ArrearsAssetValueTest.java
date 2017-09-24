package testscript;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.excel;
import pom.AssetListPage;
import pom.AssetMenuPage;
import pom.AssetValueAndStatusChangePage;

public class ArrearsAssetValueTest extends BaseTest
{
	@Test
	public void AssetCostAssignmentSmokeTest() throws InterruptedException, IOException
	{
		int row=2;
		String unitNumber=excel.getCellValue("./TestData/Input.xlsx", "AssetProfile", row,0);
		String cost=excel.getNumericCellValue("./TestData/Input.xlsx", "AssetProfile", row,11);
//		LeaseWaveHeader lwh=new LeaseWaveHeader(driver);
//		lwh.clickOnPortFolioManagement();
		AssetMenuPage asm= new AssetMenuPage(driver);
		asm.openAssetCostAssignmentPage();
		AssetValueAndStatusChangePage asvl= new  AssetValueAndStatusChangePage(driver);
		asvl.clickOnCloseButton();
		AssetListPage asl=new AssetListPage(driver);
		asl.searchByUnitNumber(unitNumber);
		asl.clickOnSearchButton(unitNumber);
		asl.selectCheckBox();
		asl.clickONSelectButton();
		asvl.selectGridCheckBox();
		asvl.selectAssignmentOperator();
		asvl.enterCostOfAsset(cost);
		asvl.clickOnAddButton();
		asvl.clickOnAssignmentButton();
//		Thread.sleep(2000);
		asvl.selectGLTemplate();
		asvl.clickOnSaveButton();
		asvl.handlePopup();
		asvl.verfyTittle("Asset List", "failed");
	}
}
