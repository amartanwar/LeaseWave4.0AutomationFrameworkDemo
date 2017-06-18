package testscript;

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
	public void assetCreation() throws InterruptedException
	{
		String un=excel.getCellValue("./TestData/Input.xlsx", "AssetProfile", 1,0);
		String type=excel.getCellValue("./TestData/Input.xlsx", "AssetProfile", 1,1);
		String usageCondition=excel.getCellValue("./TestData/Input.xlsx", "AssetProfile", 1,2);
		System.out.println(usageCondition);
		String accountNumber=excel.getCellValue("./TestData/Input.xlsx", "AssetProfile", 1,3);
		System.out.println(accountNumber);
		String factorcategory=excel.getCellValue("./TestData/Input.xlsx", "AssetProfile", 1,4);
		System.out.println(factorcategory);
		String contractNumber=excel.getCellValue("./TestData/Input.xlsx", "AssetProfile", 1,5);
		System.out.println(contractNumber);
		String divNumber=excel.getCellValue("./TestData/Input.xlsx", "AssetProfile", 1,6);
		System.out.println(divNumber);
		String subDivNumber=excel.getCellValue("./TestData/Input.xlsx", "AssetProfile", 1,7);
		System.out.println(subDivNumber);
		String locationCode=excel.getCellValue("./TestData/Input.xlsx", "AssetProfile", 1,8);
		System.out.println(locationCode);
		String company=excel.getCellValue("./TestData/Input.xlsx", "AssetProfile", 1,9);
		System.out.println(company);
		String department=excel.getCellValue("./TestData/Input.xlsx", "AssetProfile", 1,10);
		System.out.println(department);

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
		Thread.sleep(2000);
		app.setUsageCondition(usageCondition);
		app.setAcquiredDate();
		app.setAccountNumber(accountNumber);
		app.setFactorCategory(factorcategory);
//		app.setContractNumber(contractNumber);
//		app.setDivision(divNumber);
//		app.setDivision(subDivNumber);
//		app.setLocationCode(locationCode);
//		app.setEffectiveDate();
//		app.setCompany(company);
//		app.setDepartment(department);
//		app.clickOnSave();
//		app.clickOnVehicleDetailsSaveButton();
Thread.sleep(5000);
	}

}
