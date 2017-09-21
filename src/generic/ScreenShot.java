package generic;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public  class ScreenShot 
{
	
	public static  void takeScreenshot(WebDriver driver,String folder) 
	{
		TakesScreenshot t= (TakesScreenshot)driver;
		Date d=new Date();
		String date=d.toString().replace(":", "-");
		File srcFile=t.getScreenshotAs(OutputType.FILE);
		File dstfile= new File(folder+date+".png");
		try
		{
			FileUtils.copyFile(srcFile, dstfile);
			String filePath = dstfile.toString();
			String path = "<img src=\"file://" + filePath + "\" alt=\"\"/>";
			Reporter.log(path,true);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	}
}
