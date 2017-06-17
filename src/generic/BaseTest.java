package generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pom.LoginPage;

public abstract class BaseTest implements AutoConst 
{
	public WebDriver driver;
	
	
	@BeforeClass
	public void openApplication()
	{
		System.setProperty(CHROME_KEY,CHROME_VALUE);
		driver=new ChromeDriver();
		driver.get("http://otbapsrv:206");
		LoginPage lp=new LoginPage(driver);
		lp.setCompanyName("Merchants-TVQA");
		lp.RideTheLeaseWave();

		for(String winHandle: driver.getWindowHandles())
		{
			driver.switchTo().window(winHandle);
		}
		
		
			lp.setuserName("OdessaUser");
			lp.setPassword("Samsung-1234");
			lp.clickOnLogin();
	}
	

	
	@AfterClass
	public void closeApplication()
	{
		driver.quit();
	}
	

}
