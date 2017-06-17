package generic;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class BaseTest implements AutoConst
{
	public WebDriver driver;
	
	@BeforeClass
	public void openApplication()
	{
		System.setProperty(CHROME_KEY,CHROME_VALUE);
		driver.get("https://otbapsrv:206");
	}
	
	@AfterClass
	public void closeApplication()
	{
		driver.quit();
	}
	

}
