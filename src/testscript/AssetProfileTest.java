package testscript;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.excel;
import pom.AssetListPage;
import pom.AssetMenuPage;
import pom.AssetProfilePage;
import pom.LeaseWaveHeader;


public class AssetProfileTest extends BaseTest 
{
	@Test
	public void AssetCreationTest() throws InterruptedException, IOException 
	{
		String un=excel.getCellValue("./TestData/Input.xlsx", "AssetProfile", 1,0);
		String type=excel.getCellValue("./TestData/Input.xlsx", "AssetProfile", 1,1);
		String usageCondition=excel.getCellValue("./TestData/Input.xlsx", "AssetProfile", 1,2);
		String accountNumber=excel.getCellValue("./TestData/Input.xlsx", "AssetProfile", 1,3);
		String factorcategory=excel.getCellValue("./TestData/Input.xlsx", "AssetProfile", 1,4);
		String contractNumber=excel.getCellValue("./TestData/Input.xlsx", "AssetProfile", 1,5);
		String divNumber=excel.getCellValue("./TestData/Input.xlsx", "AssetProfile", 1,6);
		String subDivNumber=excel.getCellValue("./TestData/Input.xlsx", "AssetProfile", 1,7);
		String locationCode=excel.getCellValue("./TestData/Input.xlsx", "AssetProfile", 1,8);
		String company=excel.getCellValue("./TestData/Input.xlsx", "AssetProfile", 1,9);
		String department=excel.getCellValue("./TestData/Input.xlsx", "AssetProfile", 1,10);


		LeaseWaveHeader lwh= new LeaseWaveHeader(driver);
		lwh.clickOnPortFolioManagement();
		AssetMenuPage asm= new AssetMenuPage(driver);
		asm.clickOnAssetMenu();
		asm.clickOnAssetProfile();
		AssetListPage  aslp= new AssetListPage(driver);
		aslp.clickOnaddButton();	
		AssetProfilePage app= new AssetProfilePage(driver);
		app.setUnitNumber(un);
		app.setAssetType(type);
		app.setAcquiredDate();
		app.setUsageCondition(usageCondition);
		app.setAccountNumber(accountNumber);	
		app.setFactorCategory(factorcategory);
		app.setContractNumber(contractNumber);
		app.setLocationCode(locationCode);
		app.setDivision(divNumber);
		Thread.sleep(2000);
		app.setEffectiveDate();
		app.setSubdivision(subDivNumber);
		app.setCompany(company);
		app.setDepartment(department);
		app.clickOnSave();
		app.verfyTittle("Vehicle Details","Asset Creation failed because of incorrect values entered");
		app.clickOnVehicleDetailsSaveButton();
		app.clickOnAssetProfileGlobalClose();
		Thread.sleep(3000);
		app.verfyTittle("Asset List","Asset Creation failed because of incorrect values entered");
		
		
	}

}
