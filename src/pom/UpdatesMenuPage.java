package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import generic.BasePage;

public class UpdatesMenuPage extends BasePage
{
	@FindBy(id="ctl00ctl04WebMenuControl_5")
	private WebElement updateMenu;
	
	@FindBy(xpath=".//*[@id='ctl00ctl04WebMenuControl_5_4']/td/div")
	private WebElement lease;
	
	@FindBy(xpath=".//*[@id='ctl00ctl04WebMenuControl_5_4_1']/td/div")
	private WebElement interimRent;
	
	@FindBy(xpath=".//*[@id='ctl00ctl04WebMenuControl_5_4_3']/td/div")
	private WebElement movingLongTermToShortTerm;
	
	public UpdatesMenuPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void openMovingLongTermToShortTerm()
	{
		WebDriverWait wt1= new WebDriverWait(driver, 60);
	    wt1.until(ExpectedConditions.visibilityOf(updateMenu));
	    Actions action= new Actions(driver);
		action.moveToElement(updateMenu).perform();
		
		WebDriverWait wt2= new WebDriverWait(driver, 60);
	    wt2.until(ExpectedConditions.visibilityOf(lease));
		action.moveToElement(lease).perform();
		
		WebDriverWait wt3= new WebDriverWait(driver, 60);
	    wt3.until(ExpectedConditions.visibilityOf(interimRent));
		action.moveToElement(interimRent).perform();
		
		WebDriverWait wt4= new WebDriverWait(driver, 60);
	    wt4.until(ExpectedConditions.visibilityOf(movingLongTermToShortTerm));
		action.moveToElement(movingLongTermToShortTerm).click().perform();
	
	}
	
	

	
	
}
