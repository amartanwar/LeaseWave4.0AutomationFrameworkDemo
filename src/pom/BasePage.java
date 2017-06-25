package pom;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public abstract class BasePage {
	public WebDriver driver;
	
	public BasePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void verfyTittle(String eTitle,String msg)
	{
		WebDriverWait wait= new WebDriverWait(driver,5);
		
		try
		{
			wait.until(ExpectedConditions.titleIs(eTitle));
			Reporter.log("Pass:Title is Matching",true);
		}
		catch(Exception e)
		{
//			try
//			{
//				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_ctl04_lnkSignOut")));
//				Reporter.log("Pass:Home Page Title is Matching",true);
//			}
//			catch(Exception b)
//			{
//				Reporter.log("FAIL:Title is not matching",true);
//				Assert.fail();
//			}
			Reporter.log(msg,true);
			Assert.fail();
		
		}
	}
	
	

}
