package stepDefinitions;

import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import pageObjects.Add_Customer_Page;
import pageObjects.Login_Page;
import pageObjects.SearchCustomerPage;

public class BaseClass {

	public WebDriver driver;
	
	public Login_Page lp;
	
	public Add_Customer_Page addCust;
	public SearchCustomerPage searchCust;
	public static Logger logger;
	public Properties configProp;
	
	
	public static String dummyEmail = "victoria_victoria@nopCommerce.com";
	public static String dummyFname = "Victoria";
	public static String dummyLname = "Terces";

	//Generating Random string for email id and name
	public static String customerName() {
		String generateName = RandomStringUtils.randomAlphabetic(5);
		return generateName;
	}
	
	
	

}
