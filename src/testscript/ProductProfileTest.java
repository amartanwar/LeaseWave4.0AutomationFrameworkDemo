package testscript;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.excel;
import pom.LeaseWaveHeader;
import pom.ProductListPage;
import pom.ProductProfilePage;
import pom.TemplatesMenuPage;

public class ProductProfileTest extends BaseTest
{
	@Test
	public void ProductProfileSmokeTest() throws InterruptedException, IOException
	{
		//Fetching data from xl
		String productCode = excel.getCellValue("./TestData/Input.xlsx", "ProductProfile", 1, 0);
		String productName = excel.getCellValue("./TestData/Input.xlsx", "ProductProfile", 1, 0);
		
		//Opening Product profile
		LeaseWaveHeader lw=new LeaseWaveHeader(driver);
		lw.clickOnFleetManagement();
		TemplatesMenuPage tp=new TemplatesMenuPage(driver);
		tp.openProductProfile();
		ProductListPage pl=new ProductListPage(driver);
		pl.clickOnAddButton();
		
		//Entering product Code
		ProductProfilePage ppp=new ProductProfilePage(driver);
		ppp.enterProductCode(productCode);
		
		//Entering Product name
		ppp.enterProductName(productName);
		
		//Selecting Product Category
		ppp.selectProductCategory(1);
		
		//Selecting product Frequency
		ppp.selectProductFrequency(1);
		
		//Selecting GLTemplate
		ppp.selectGLTemplate(1);
		
		//Selecting Sundry Code
		ppp.selectSundryCode(1);
		
		//Clicking on save button
		ppp.clickOnSaveButton();
		
		//Validate product profile test
		ppp.verfyTittle("Product List", "Product Profile smoke test pass");
		
	}
}
