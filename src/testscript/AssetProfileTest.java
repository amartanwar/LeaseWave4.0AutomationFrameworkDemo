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
	public void AssetCreationSmokeTest() throws InterruptedException, IOException 
	{
		//Fetching data from xl
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

		//Opening Asset Profile screen
		LeaseWaveHeader lwh= new LeaseWaveHeader(driver);
		lwh.clickOnPortFolioManagement();
		AssetMenuPage asm= new AssetMenuPage(driver);
		asm.clickOnAssetMenu();
		asm.clickOnAssetProfile();
		AssetListPage  aslp= new AssetListPage(driver);
		aslp.clickOnaddButton();	
		
		//Entering UnitNumber
		AssetProfilePage app= new AssetProfilePage(driver);
		app.setUnitNumber(un);
		
		//Selecting Asset Type
		app.setAssetType(type);
		
		//Entering Acquired Date
		app.setAcquiredDate();
		
		//Selecting UsageCondition
		app.setUsageCondition(usageCondition);
		
		//Selecting Account Number
		app.setAccountNumber(accountNumber);	
		
		//Selecting Factor Category
		app.setFactorCategory(factorcategory);
		
		//Selecting Contract Number
		app.setContractNumber(contractNumber);
		
		//Selecting Location
		app.setLocationCode(locationCode);
		
		//Selecting DivisionNumber
		app.setDivision(divNumber);
		
		//Entering Location effective date
		app.setEffectiveDate();
		
		//Selecting SubDivision
		app.setSubdivision(subDivNumber);
		
		//Selection GLComapny
		app.setCompany(company);
		
		//Selecting GLDepartment
		app.setDepartment(department);
		
		//Click On save Button
		app.clickOnSave();
		
		//Validating vehicle details page
		app.verfyTittle("Vehicle Details","Asset Creation failed because of incorrect values entered");
		
		//clicking on saveButton(Vehicle details)
		app.clickOnVehicleDetailsSaveButton();
		
		//Clicking on global save
		app.clickOnAssetProfileGlobalClose();
		
		
		//Validating Asset creation test
		app.verfyTittle("Asset List","Asset Creation failed because of incorrect values entered");
		
		
	}

}
