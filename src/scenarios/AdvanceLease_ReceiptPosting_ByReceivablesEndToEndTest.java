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
import testscript.testmethods.ReceiptPostingByReceivablesMethod;
import testscript.testmethods.SalesTaxUpdateMethod;

public class AdvanceLease_ReceiptPosting_ByReceivablesEndToEndTest extends BaseTest
{
	@Test()
	public void testingAdvanceLeaseEndToEnd() throws IOException, InterruptedException, AWTException
	{
		AssetCreationMethod as = new AssetCreationMethod();
		as.createAsset(driver, 1);
		
		AssetStatusAndValueChangeMethod av= new AssetStatusAndValueChangeMethod();
		av.assetValueAssignement(driver, 1);
		
		LeaseCreationMethod lc= new LeaseCreationMethod();
		lc.createLease(driver, 1);
		
		LeaseLTtoSTUpdateMethod ls= new LeaseLTtoSTUpdateMethod();
		ls.runLeaseLTtoSTUpdate(driver, 1);
		
		LeaseIncomeUpdateMethod li= new LeaseIncomeUpdateMethod();
		li.runLeaseIncomeUpdate(driver, 1);
		
		InvoiceDateUpdateMethod id= new InvoiceDateUpdateMethod();
		id.runInvoiceDateUpdate(driver, 1);
		
		SalesTaxUpdateMethod su= new SalesTaxUpdateMethod();
		su.runSalesTaxUpdate(driver, 1);
		
		InvoiceGenerationMethod ig= new InvoiceGenerationMethod();
		ig.runInvoiceGeneration(driver, 1);
		
		ReceiptPostingByReceivablesMethod rp=new ReceiptPostingByReceivablesMethod();
		rp.ReceiptPostingByReceivables(driver, 1);
		
	}
}
