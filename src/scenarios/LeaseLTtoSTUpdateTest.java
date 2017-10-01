package scenarios;

import java.awt.AWTException;
import java.io.IOException;
import org.testng.annotations.Test;
import generic.BaseTest;
import testscript.testmethods.AssetCreationMethod;
import testscript.testmethods.AssetStatusAndValueChangeMethod;
import testscript.testmethods.LeaseCreationMethod;
import testscript.testmethods.LeaseLTtoSTUpdateMethod;

public class LeaseLTtoSTUpdateTest extends BaseTest
{	
	@Test(priority=1)
	public void lTtoSTUpdateTest_TestDataCreation() throws IOException, InterruptedException, AWTException
	{
		AssetCreationMethod as = new AssetCreationMethod();
		as.createAsset(driver, 1);
		
		AssetStatusAndValueChangeMethod av= new AssetStatusAndValueChangeMethod();
		av.assetValueAssignement(driver, 1);
		
		LeaseCreationMethod lc= new LeaseCreationMethod();
		lc.createLease(driver, 1);
	}
	@Test(priority=2, dependsOnMethods={"lTtoSTUpdateTest_TestDataCreation"})
	public void lTtoSTUpdateTest() throws InterruptedException
	{
		LeaseLTtoSTUpdateMethod ls= new LeaseLTtoSTUpdateMethod();
		ls.runLeaseLTtoSTUpdate(driver, 1);
		
	}
}
