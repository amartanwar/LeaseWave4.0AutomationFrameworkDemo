package generic;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScrollOptions 
{
	public static void  scrollingToBottomofAPage(WebDriver driver)
	{
		JavascriptExecutor jse= (JavascriptExecutor) driver;
//		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		jse.executeScript("window.scrollTo(0,Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight));");
	}
	
	public static void  scrollingToElementofAPage(WebDriver driver,WebElement element)
	{
		JavascriptExecutor jse= (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public static void  scrollingByCoordinatesofAPage(WebDriver driver,WebElement element)
	{
		JavascriptExecutor jse= (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,500)");
	}
	
	public static void  scrollingEndofAPage() throws AWTException
	{
		Robot rb= new Robot();
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_CONTROL);
	
	}

	public static void  scrollingEndofAPage2(int Count) throws AWTException
	{
		Robot rb= new Robot();
		rb.keyPress(KeyEvent.VK_TAB);
		rb.keyRelease(KeyEvent.VK_TAB);
		for(int i=1;i<=Count;i++)
		{
			rb.keyPress(KeyEvent.VK_DOWN);
		}
		rb.keyRelease(KeyEvent.VK_DOWN);
	
	
	}
}
