package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {

	//This class is used to wait for element
	public WebDriver driver;
	
	//Create constructor
	public WaitHelper(WebDriver driver) {
		this.driver = driver;
		
	}
	
	//Method for wait web element
	//User defined method explicit wait
	public void WaitForElement(WebElement element, long timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver,timeOutInSeconds );
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	
}
