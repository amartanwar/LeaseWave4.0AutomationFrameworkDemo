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
		
		String url=excel.getCellValue("./TestData/Input.xlsx", "credentials", 1, 0);
		String companyName=excel.getCellValue("./TestData/Input.xlsx", "credentials", 1, 1);
		String userName=excel.getCellValue("./TestData/Input.xlsx", "credentials", 1, 2);
		String password=excel.getCellValue("./TestData/Input.xlsx", "credentials", 1, 3);
		driver.get(url);
		LoginPage lp=new LoginPage(driver);
		lp.setCompanyName(companyName);
		lp.rideTheLeaseWave();

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
