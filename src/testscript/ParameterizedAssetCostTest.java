package testscript;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pom.AssetMenuPage;
import pom.AssetValueAndStatusChangePage;

public class ParameterizedAssetCostTest extends ParameterizedAssetTest
{
	@Test(priority = 1)
	@Parameters({"sUnitNumber","sCost"})
	public void AssetCostAssignmentSmokeTest(String sUnitNumber, String sCost) throws InterruptedException, IOException
	{
		AssetMenuPage asm= new AssetMenuPage(driver);
		asm.openAssetCostAssignmentPage();
		AssetValueAndStatusChangePage asvl= new  AssetValueAndStatusChangePage(driver);
		asvl.selectGridCheckBox();
		asvl.selectAssignmentOperator();
		asvl.enterCostOfAsset(sCost);
		asvl.clickOnAddButton();
		asvl.clickOnAssignmentButton();
		asvl.selectGLTemplate();
		asvl.clickOnSaveButton();
		asvl.handlePopup();
		asvl.verfyTittle("Asset List", "failed");
	}
}
