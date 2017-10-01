package scenarios;

import java.awt.AWTException;
import java.io.IOException;
import org.testng.annotations.Test;
import generic.BaseTest;
import testscript.testmethods.AssetCreationMethod;
import testscript.testmethods.AssetStatusAndValueChangeMethod;
import testscript.testmethods.LeaseCreationMethod;
import testscript.testmethods.LeaseRebookMethod;

public class LeaseRebookTest extends BaseTest
{
		@Test()
		public void LeaseRebookSmokeTest() throws IOException, InterruptedException, AWTException
		{
			AssetCreationMethod as = new AssetCreationMethod();
			as.createAsset(driver, 3);
			
			AssetStatusAndValueChangeMethod av= new AssetStatusAndValueChangeMethod();
			av.assetValueAssignement(driver, 3);
			
			LeaseCreationMethod lm= new LeaseCreationMethod();
			lm.createLease(driver, 3);
					
			LeaseRebookMethod lr= new LeaseRebookMethod();
			lr.leaseRebook(driver, 3);
			
		}
}
