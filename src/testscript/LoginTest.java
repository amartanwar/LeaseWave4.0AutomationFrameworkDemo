package testscript;

import org.testng.annotations.Test;
import generic.BaseTest;
import pom.LoginPage;

public class LoginTest extends BaseTest  
{
	@Test
	public void testLogin() throws InterruptedException
	{
		LoginPage l=new LoginPage(driver);
		l.verfyTittle("LeaseWave");
		l.setCompanyName("Merchants-TVQA");
		l.rideTheLeaseWave();

		for(String winHandle: driver.getWindowHandles())
		{
			driver.switchTo().window(winHandle);
		}
		
		Thread.sleep(2000);
		try
		{
			l.verfyTittle("LeaseWave LogOn");
		}
		catch(Exception e)
		{
			
		}
	
		finally
		{
			l.setuserName("OdessaUser");
			l.setPassword("Samsung-1234");
			l.clickOnLogin();
			Thread.sleep(2000);
			l.verfyTittle("dssd");
		}
		
		
		
		
		
	}
	
	
	
	
}
