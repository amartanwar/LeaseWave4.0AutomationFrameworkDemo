package generic;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import generic.ScreenShot;

public abstract class BasePage {
	public WebDriver driver;
	
	public BasePage(WebDriver driver)
	{	
		
		this.driver=driver;
	}
	
	public void verfyTittle(String eTitle,String msg) throws IOException, InterruptedException
	{
		WebDriverWait wait= new WebDriverWait(driver,5);
		
		try
		{
			wait.until(ExpectedConditions.titleIs(eTitle));
			Reporter.log("Pass:Title is Matching",true);
		}
		catch(Exception e)
		{
			ScreenShot s=new ScreenShot(driver);
			s.takeScreenshot();
			Reporter.log(msg,true);
			Assert.fail();
		
		}
	}
	
	

}
