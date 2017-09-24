package testscript;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.excel;
import pom.InvoiceSearchPage;
import pom.ReceiptApplicationPage;
import pom.ReceiptListPage;
import pom.ReceiptSetupPage;
import pom.ReceivablesAndReceiptsMenuPage;

public class ReceiptApplicationByInvoiceTest extends BaseTest
{
	@Test
	public void ReceiptSetupSmokeTest() throws InterruptedException, IOException
	{
		//Fetching data from xl
		String leaseSeqNumber=excel.getCellValue("./TestData/Input.xlsx", "AssetProfile", 1,0);
				
		//Opening the Receipt Setup page
		ReceivablesAndReceiptsMenuPage rr= new ReceivablesAndReceiptsMenuPage(driver);
		rr.openReceiptApplicationByInvoicePage();
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
		
		//Adding the receipt
		ReceiptListPage rl= new ReceiptListPage(driver);
		rl.clickOnAddButton();
		
		//Receipt details entry
		ReceiptSetupPage rs= new ReceiptSetupPage(driver);
		System.out.println(driver.getTitle());
		//Enter accountNumber
		rs.enterAccountNumber("005162");
		
		//Enter receipt amount
		rs.enterReceiptAmount("2000");
		
		//Select Gl template
		rs.selectReceiptGLTemplate();
		
		//Enter check number
		rs.enterCheckNumber("check- "+leaseSeqNumber);
	
		//Save the receipt
		rs.clickOnSaveAndSelect();
		
		//Validate the receipt setup test
		rs.verfyTittle("Invoice Search", "Failed to create Receipt");
		
		//select lease sequenceNumber
		InvoiceSearchPage is= new InvoiceSearchPage(driver);
		is.selectLeaseSequenceNumberRadioButton();
		
		//enter lease Sequence Number
		is.enterLeaseSequenceNumber(leaseSeqNumber);
		
		//click on SaveAndApply
		is.clickOnSaveAndApplyButton();
		
		//Validate the receipt posting ByInvoice
		rs.verfyTittle("RECEIPT APPLICATION - CASH", "Failed to open Receipt Application");
		
		//Select the invoice
		ReceiptApplicationPage ra= new ReceiptApplicationPage(driver);
		ra.selectInvoices();
		
		//click on distribute
		ra.clickOnDistribute();
		
		//post the receipt
		ra.clickOnPostButton();
		
		//validate receipt posting
		ra.verfyTittle("Receipt List - Cash", "Failed to apply the recipt");
		}
}
