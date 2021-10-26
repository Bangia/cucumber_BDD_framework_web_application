package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {

	public WebDriver ldriver;
	
	//Create constructor
	
	public Login_Page(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this );
	}
	
	//Create WebElement 
	
	@FindBy(id ="Email")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(name ="Password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(xpath="//button[@type='submit']")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(linkText="Logout")
	@CacheLookup
	WebElement lnkLogout;
	
	//Action Method
	
	public void setUserName(String uname) {
		txtEmail.clear();
		txtEmail.sendKeys(uname);
	}
	
    public void setPassword(String pwd) {
    	txtPassword.clear();
    	txtPassword.sendKeys(pwd);
	}
    
    public void sbtButton() {
    	btnLogin.click();
   	}
    
    public void lgtButton() {
    	lnkLogout.click();
   	}
}
