package scenarios;

import java.awt.AWTException;
import java.io.IOException;
import org.testng.annotations.Test;
import generic.BaseTest;
import testscript.testmethods.AssetCreationMethod;
import testscript.testmethods.AssetStatusAndValueChangeMethod;
import testscript.testmethods.LeaseCreationMethod;

public class LeaseCreationTest extends BaseTest 
{
	@Test(priority=1)
	public void leaseTest_TestDataCreation() throws IOException, InterruptedException
	{
		AssetCreationMethod as = new AssetCreationMethod();
		as.createAsset(driver, 2);
		
		AssetStatusAndValueChangeMethod av= new AssetStatusAndValueChangeMethod();
		av.assetValueAssignement(driver, 2);
	}
	
	@Test(priority=2, dependsOnMethods={"leaseTest_TestDataCreation"})
	public void leaseTest() throws AWTException, InterruptedException, IOException
	{
		LeaseCreationMethod ls= new LeaseCreationMethod();
		ls.createLease(driver, 2);
	}

}
