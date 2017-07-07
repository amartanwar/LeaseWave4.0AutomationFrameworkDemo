package generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pom.LoginPage;

public abstract class BaseTest implements AutoConst 
{
	public WebDriver driver;
	
	
	
	@BeforeClass
	public void openApplication() throws InterruptedException
	{
//		System.setProperty(CHROME_KEY,CHROME_VALUE);
//		driver=new ChromeDriver();
		
		System.setProperty(IE_KEY,IE_VALUE);
		driver=new InternetExplorerDriver();
		driver.manage().window().maximize();
		Thread.sleep(2000);
		String url=excel.getCellValue("./TestData/Input.xlsx", "credentials", 1, 0);
		String companyName=excel.getCellValue("./TestData/Input.xlsx", "credentials", 1, 1);
		String userName=excel.getCellValue("./TestData/Input.xlsx", "credentials", 1, 2);
		String password=excel.getCellValue("./TestData/Input.xlsx", "credentials", 1, 3);
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		LoginPage lp=new LoginPage(driver);
		lp.setCompanyName(companyName);
		lp.rideTheLeaseWave();
		Thread.sleep(2000);
		for(String winHandle: driver.getWindowHandles())
		{
			driver.switchTo().window(winHandle);
		}
		
		WebDriverWait wait= new WebDriverWait(driver, 56);
		wait.until(ExpectedConditions.visibilityOf(lp.userName));
		
		
		
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
