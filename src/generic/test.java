package generic;

import java.io.File;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class test {

	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.google.com");
		File f= new File("./TestData/Input.xlsx");
		Workbook wb= new WorkbookFactory().create(f);
		String ws=wb.getSheet("Sheet1").getRow(0).getCell(0).getStringCellValue();
		System.out.println(ws);
		driver.findElement(By.id("lst-ib")).sendKeys(ws);
		Thread.sleep(5000);
		driver.quit();
		
		
		
		

	}

}
