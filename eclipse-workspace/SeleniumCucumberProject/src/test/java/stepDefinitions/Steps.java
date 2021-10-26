package stepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import pageObjects.Add_Customer_Page;
import pageObjects.Login_Page;
import pageObjects.SearchCustomerPage;

public class Steps extends BaseClass {
	
	@Before //Hooks in Cucumber
	public void setup() throws IOException {
		
		//reading properties file
		configProp = new Properties();
		FileInputStream configPropFile = new FileInputStream("config.properties");
		configProp.load(configPropFile);
		
		logger = Logger.getLogger("Cucumber BDD Framework !!!"); //added logger
		PropertyConfigurator.configure("log4j.properties"); //added logger
		
		String br = configProp.getProperty("browser");
		
		if(br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", configProp.getProperty("chromepath"));
			driver = new ChromeDriver();
			logger.info("********** Launching Chrome Browser **********");
		}
		else if(br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", configProp.getProperty("firefoxpath"));
			driver = new FirefoxDriver();
			logger.info("********** Launching Firefox Browser **********");
		}
		else if(br.equals("ie")) {
			System.setProperty("webdriver.ie.driver", configProp.getProperty("iepath"));
			driver = new FirefoxDriver();
			logger.info("********** Launching Internet Explorer Browser **********");
		}
		
		
		logger.info("********** Launching URL **********");
	}
	

	@Given("Launch your Chrome Browser")
	public void launch_your_chrome_browser() {
		
		lp = new Login_Page(driver); //Object creation
	}

	@When("Open URL  as {string}")
	public void open_url_as(String url) {
		logger.info("********** Opening URL **********");
		driver.get(url);
		driver.manage().window().maximize();
	    
	}

	@When("Enter email id as {string} and password as {string}")
	public void enter_email_id_as_and_password_as(String email, String password) {
		logger.info("********** Providing login details **********");
		lp.setUserName(email);
		lp.setPassword(password);
	}

	@When("Click on Login button.")
	public void click_on_login_button() {
		logger.info("********** click login Button **********");
		lp.sbtButton();
	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String title) {
	   
		if(driver.getPageSource().contains("Login was unsuccessful")) {
			driver.close();
			logger.info("********** Login Passed !!! **********");
			Assert.assertTrue(false);
		}
		else {
			logger.info("********** Login Failed !!! **********");
			Assert.assertEquals(title, driver.getTitle());
		}
	   
	}

	@When("clicks on Logout link")
	public void clicks_on_logout_link() throws InterruptedException {
		logger.info("********** Clicking logout link  **********");
		lp.lgtButton();
	    Thread.sleep(3000);
	}

	@Then("close your browser.")
	public void close_your_browser() {
		logger.info("********** Test case finished closing browser **********");
		driver.quit();
	}
	
	//**************************** Add New Customers Features *************************************************
	
	@Then("User can view dashboard screen.")
	public void user_can_view_dashboard_screen() {
		addCust = new Add_Customer_Page(driver); //initialise constructor
		
		
		Assert.assertEquals("Dashboard / nopCommerce administration", addCust.getPageTitle());
	}

	@When("User click on customer menu")
	public void user_click_on_customer_menu() throws InterruptedException {
		Thread.sleep(3000);
		addCust.clickMenu();
	}

	@When("Click on customer menu item")
	public void click_on_customer_menu_item() throws InterruptedException {
		Thread.sleep(2000);
		addCust.clickMenuItem();
	    
	}

	@When("Click on add new button")
	public void click_on_add_new_button() throws InterruptedException {
		addCust.addNewButton();
		Thread.sleep(2000);
	}

	@Then("User can view add new customer page")
	public void user_can_view_add_new_customer_page() {
	    Assert.assertEquals("Add a new customer / nopCommerce administration",addCust.getPageTitle());
	}

	@When("User enters customer info")
	public void user_enters_customer_info() {
	   logger.info("********** Starting Adding new Customer **********");
	   String email = customerName()+"@gmil.com";
	   addCust.setName(email);
	   
	   
	}

	@When("Click on save button")
	public void click_on_save_button() throws InterruptedException {
		logger.info("********** Saving Customer data **********");
		addCust.submitButton();
		Thread.sleep(2000);
	
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String Successmessage) {
	   Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("The new customer has been added successfully."));
		
	}
	
	//**************** SEARCH CUSTOMER BY EMAIL ID ***************************
	

	@When("Enter customer email id")
	public void enter_customer_email_id() {
		logger.info("********** Searching a Customer by email id **********");
		searchCust = new SearchCustomerPage(driver);
		searchCust.setEmail(dummyEmail);
	   
	}
	
	@When("Click on search button")
	public void click_on_search_button() throws InterruptedException {
		searchCust.clkSearch();
		Thread.sleep(3000);
	}
	
	@Then("user should found email id in search table.")
	public void user_should_found_email_id_in_search_table() {
		boolean status = searchCust.searchCustomerByEmail(dummyEmail);
		Assert.assertEquals(true, status);
		
		//searchCust.getNoOfRows();
		//searchCust.getNoOfColumns();
	}

	//************ SEARCH CUSTOMER BY FIRST NAME & LAST NAME **********************
	
	@When("Enter customer FirstName")
	public void enter_customer_first_name() {
		logger.info("********** searching customer by name **********");
		searchCust = new SearchCustomerPage(driver);
		searchCust.SearchFirstName(dummyFname);
	}
	
	@When("Enter customer LastName")
	public void enter_customer_last_name() {
		searchCust.SearchLastName(dummyLname);
	}
	
	@Then("user should found Name in search table.")
	public void user_should_found_name_in_search_table() {
		boolean result = searchCust.searchCustomerByName(dummyFname+dummyLname);
		Assert.assertEquals(true, result);
	}

}
