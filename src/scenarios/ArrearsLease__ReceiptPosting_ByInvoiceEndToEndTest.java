package scenarios;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import generic.BaseTest;
import testscript.testmethods.AssetCreationMethod;
import testscript.testmethods.AssetStatusAndValueChangeMethod;
import testscript.testmethods.InvoiceDateUpdateMethod;
import testscript.testmethods.InvoiceGenerationMethod;
import testscript.testmethods.LeaseCreationMethod;
import testscript.testmethods.LeaseIncomeUpdateMethod;
import testscript.testmethods.LeaseLTtoSTUpdateMethod;
import testscript.testmethods.ReceiptPostingByInvoiceMethod;
import testscript.testmethods.SalesTaxUpdateMethod;

public class ArrearsLease__ReceiptPosting_ByInvoiceEndToEndTest extends BaseTest
{
	@Test()
	public void testingArrearsLeaseEndToEnd() throws IOException, InterruptedException, AWTException
	{
		AssetCreationMethod as = new AssetCreationMethod();
		as.createAsset(driver, 2);
		
		AssetStatusAndValueChangeMethod av= new AssetStatusAndValueChangeMethod();
		av.assetValueAssignement(driver, 2);
		
		LeaseCreationMethod lc= new LeaseCreationMethod();
		lc.createLease(driver, 2);
		
		LeaseLTtoSTUpdateMethod ls= new LeaseLTtoSTUpdateMethod();
		ls.runLeaseLTtoSTUpdate(driver, 2);
		
		LeaseIncomeUpdateMethod li= new LeaseIncomeUpdateMethod();
		li.runLeaseIncomeUpdate(driver, 2);
		
		InvoiceDateUpdateMethod id= new InvoiceDateUpdateMethod();
		id.runInvoiceDateUpdate(driver, 2);
		
		SalesTaxUpdateMethod su= new SalesTaxUpdateMethod();
		su.runSalesTaxUpdate(driver, 2);
		
		InvoiceGenerationMethod ig= new InvoiceGenerationMethod();
		ig.runInvoiceGeneration(driver, 2);
		
		ReceiptPostingByInvoiceMethod rp= new ReceiptPostingByInvoiceMethod();
		rp.ReceiptPostingByInvoice(driver, 2);
		
	}
}
