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
		String comanyName=excel.getCellValue("./TestData/Input.xlsx", "credentials", 0, 0);
		String userName=excel.getCellValue("./TestData/Input.xlsx", "credentials", 0, 1);
		String password=excel.getCellValue("./TestData/Input.xlsx", "credentials", 0, 2);
		LoginPage lp=new LoginPage(driver);
		lp.setCompanyName(comanyName);
		lp.RideTheLeaseWave();

		for(String winHandle: driver.getWindowHandles())
		{
			driver.switchTo().window(winHandle);
		}
		
		
			lp.setuserName(userName);
			lp.setPassword(password);
			lp.clickOnLogin();
	}
	

	
	@AfterClass
	public void closeApplication()
	{
		driver.quit();
	}
	

}
