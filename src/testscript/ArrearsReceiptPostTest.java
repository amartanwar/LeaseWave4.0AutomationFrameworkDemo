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

public class ArrearsReceiptPostTest extends BaseTest 
{
	@Test
	public void ReceiptPostTest() throws InterruptedException, IOException
	{
		//Fetching data from xl
		String leaseSeqNumber=excel.getCellValue("./TestData/Input.xlsx", "AssetProfile", 1,0);
				
		//Opening the Receipt Setup page
		ReceivablesAndReceiptsMenuPage rr= new ReceivablesAndReceiptsMenuPage(driver);
		rr.openReceiptApplicationByInvoicePage();
		Thread.sleep(2000);
		
		//Adding the receipt
		ReceiptListPage rl= new ReceiptListPage(driver);
		rl.clickOnAddButton();
		
		//Receipt details entry
		ReceiptSetupPage rs= new ReceiptSetupPage(driver);
		
		//Enter accountNumber
		rs.enterAccountNumber("005162");
		
		//Enter receipt amount
		rs.enterReceiptAmount("5000");
		
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
		
		//enter lease Sequence Number
		is.selectLeaseSequenceNumberRadioButton();
		is.enterLeaseSequenceNumber(leaseSeqNumber);
		
		//click on ApplyReceipt
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
