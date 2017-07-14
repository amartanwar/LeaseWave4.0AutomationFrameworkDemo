package generic;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public  class ScreenShot 
{
	
	public static  void takeScreenshot(WebDriver driver,String folder) throws IOException, InterruptedException 
	{
		TakesScreenshot t= (TakesScreenshot)driver;
		Date d=new Date();
		String date=d.toString().replace(":", "-");
		File srcFile=t.getScreenshotAs(OutputType.FILE);
		File dstfile= new File(folder+date+".png");
		FileUtils.copyFile(srcFile, dstfile);
//		String filePath = dstfile.toString();
//		String path = "<img src="\"file://"" alt="\"\"/" />";
//		Reporter.log(path);
	}
}
