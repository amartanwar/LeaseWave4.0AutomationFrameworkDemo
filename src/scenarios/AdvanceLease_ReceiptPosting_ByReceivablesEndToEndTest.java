package scenarios;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import generic.BaseTest;
import testscripts.Asset.AssetCreationMethod;
import testscripts.AssetCostAndValueAssignment.AssetStatusAndValueChangeMethod;
import testscripts.InvoiceDateUpdate.InvoiceDateUpdateMethod;
import testscripts.InvoiceGeneration.InvoiceGenerationMethod;
import testscripts.LTtoSTUpdate.LeaseLTtoSTUpdateMethod;
import testscripts.Lease.LeaseCreationMethod;
import testscripts.LeaseIncomeUpdate.LeaseIncomeUpdateMethod;
import testscripts.ReceiptPosting.ReceiptPostingByReceivablesMethod;
import testscripts.SalesTaxUpdate.SalesTaxUpdateMethod;

public class AdvanceLease_ReceiptPosting_ByReceivablesEndToEndTest extends BaseTest
{
	@Test(groups="E2E Test")
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
