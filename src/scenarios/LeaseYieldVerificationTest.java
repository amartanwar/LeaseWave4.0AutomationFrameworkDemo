package scenarios;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import generic.BaseTest;
import testscript.testmethods.AssetCreationMethod;
import testscript.testmethods.AssetStatusAndValueChangeMethod;
import testscript.testmethods.LeaseYieldVerificationMethod;

public class LeaseYieldVerificationTest extends BaseTest
{
	@Test()
	public void testingLeaseYield() throws IOException, InterruptedException, AWTException
	{
		AssetCreationMethod as = new AssetCreationMethod();
		as.createAsset(driver, 5);
		
		AssetStatusAndValueChangeMethod av= new AssetStatusAndValueChangeMethod();
		av.assetValueAssignement(driver, 5);
		
		LeaseYieldVerificationMethod lv= new LeaseYieldVerificationMethod();
		lv.LeaseYieldVerification(driver, 5);
		
	}
}
