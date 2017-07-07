package generic;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public  class ScreenShot {
	public WebDriver driver;
	public  ScreenShot(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public  void takeScreenshot() throws IOException, InterruptedException 
	{
		
		TakesScreenshot t= (TakesScreenshot)driver;
		File srcFile=t.getScreenshotAs(OutputType.FILE);
		File dstfile= new File("D:/login1.png");
		FileUtils.copyFile(srcFile, dstfile);
		
	}

}
