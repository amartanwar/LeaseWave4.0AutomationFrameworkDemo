package generic;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SwitchControlToNextWindow 
{
	public void switchControlToNextWindow1(WebDriver driver,String ExpectedWindowTitle) throws InterruptedException
	{
		outerloop:
		{
		for(int i=1;i<=10;i++)
		{
			Set<String> winhandle = driver.getWindowHandles();
			int wincount = winhandle.size();
			if(wincount==2)
			{
				for(String winhandel1: driver.getWindowHandles())
				{
					driver.switchTo().window(winhandel1);
				}
				
					
				System.out.println("Before"+driver.getTitle()+"winhandle: "+driver.getWindowHandle());
				
				if (driver.getTitle().contains(ExpectedWindowTitle))
					{
					System.out.println("between"+driver.getTitle()+"winhandle: "+driver.getWindowHandle());
						break outerloop;
			 	    }
				System.out.println("After"+driver.getTitle()+"winhandle: "+driver.getWindowHandle());
				
			}
			
			else
			{
				Thread.sleep(2000);
			}
		}
		}
		
	
	}
	
	public void waitForNumberOfWindowsToEqual(WebDriver driver,int numberOfWindows)
	{
		WebDriverWait wt=new WebDriverWait(driver,60);
		wt.until(new ExpectedCondition<Boolean>() {

			@Override
			public Boolean apply(WebDriver driver) {
				
				return (driver.getWindowHandles().size() == numberOfWindows);
			}
		});

	}
	
}
