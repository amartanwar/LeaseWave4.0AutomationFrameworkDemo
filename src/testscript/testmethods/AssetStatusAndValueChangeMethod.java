package testscript.testmethods;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import generic.excel;
import pom.AssetMenuPage;
import pom.AssetValueAndStatusChangePage;

public class AssetStatusAndValueChangeMethod  
{

	public void assetValueAssignement(WebDriver driver,int row) throws InterruptedException, IOException
	{
		String cost=excel.getNumericCellValue("./TestData/Input.xlsx", "AssetProfile", row,11);

		AssetMenuPage asm= new AssetMenuPage(driver);
		asm.openAssetCostAssignmentPage();
		AssetValueAndStatusChangePage asvl= new  AssetValueAndStatusChangePage(driver);
		asvl.selectGridCheckBox();
		asvl.selectAssignmentOperator();
		asvl.enterCostOfAsset(cost);
		asvl.clickOnAddButton();
		asvl.clickOnAssignmentButton();
		asvl.selectGLTemplate();
		asvl.clickOnSaveButton();
		asvl.handlePopup();
		asvl.verfyTittle("Asset List", "failed");
	}
}
