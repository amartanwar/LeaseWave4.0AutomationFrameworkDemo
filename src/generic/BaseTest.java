package generic;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pom.LoginPage;

public abstract class BaseTest implements AutoConst 
{
	public WebDriver driver;
	@BeforeMethod
	public void openApplication() throws InterruptedException
	{
		//Open the browser
		System.setProperty(IE_KEY,IE_VALUE);
		driver=new InternetExplorerDriver();
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		//Fetching the data from xlsx
		String url=excel.getCellValue("./TestData/Input.xlsx", "credentials", 1, 0);
		String companyName=excel.getCellValue("./TestData/Input.xlsx", "credentials", 1, 1);
		String userName=excel.getCellValue("./TestData/Input.xlsx", "credentials", 1, 2);
		String password=excel.getCellValue("./TestData/Input.xlsx", "credentials", 1, 3);
		
		//Opening the application
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
	
	@AfterMethod
	public void closeApplication(ITestResult result) throws IOException, InterruptedException
	{
		//Taking the screenshot if testcase fails
		String testName=result.getName();
		int status=result.getStatus();
		System.out.println(testName);
		Thread.sleep(2000);
		if(status==ITestResult.FAILURE)
		{
			ScreenShot.takeScreenshot(driver,SNAP_PATH+testName);
		}
		//closing the browser
		driver.quit();
	}
	

}
