package scenarios;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import generic.BaseTest;
import testscript.testmethods.AssetCreationMethod;
import testscript.testmethods.AssetStatusAndValueChangeMethod;
import testscript.testmethods.LeaseCreationMethod;
import testscript.testmethods.LeaseIncomeUpdateMethod;
import testscript.testmethods.LeaseLTtoSTUpdateMethod;
import testscript.testmethods.LeaseRestructureMethod;

public class LeaseRestructureTest extends BaseTest
{
	@Test()
	public void LeaseRestructureSmokeTest() throws IOException, InterruptedException, AWTException
	{
		AssetCreationMethod as = new AssetCreationMethod();
		as.createAsset(driver, 4);
		
		AssetStatusAndValueChangeMethod av= new AssetStatusAndValueChangeMethod();
		av.assetValueAssignement(driver, 4);
		
		LeaseCreationMethod lc= new LeaseCreationMethod();
		lc.createLease(driver, 4);
		
		LeaseLTtoSTUpdateMethod ltr= new LeaseLTtoSTUpdateMethod();
		ltr.runLeaseLTtoSTUpdate(driver, 4);
		
		LeaseIncomeUpdateMethod li=new LeaseIncomeUpdateMethod();
		li.runLeaseIncomeUpdate(driver, 4);
		
		LeaseRestructureMethod lr= new LeaseRestructureMethod();
		lr.LeaseRestructure(driver, 4);
	}
}
