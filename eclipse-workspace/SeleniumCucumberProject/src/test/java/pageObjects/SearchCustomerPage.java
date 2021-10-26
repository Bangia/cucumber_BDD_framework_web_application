package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.WaitHelper;

public class SearchCustomerPage {

	public WebDriver ldriver;
	WaitHelper waithelper;
	
	//Create Constructor
	public SearchCustomerPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this );
		waithelper = new WaitHelper(ldriver);
	}
	
	//WebElement creation
	
	@FindBy(id ="SearchEmail")
	@CacheLookup
	WebElement searchByEmailId;
	
	@FindBy(id="search-customers")
	@CacheLookup
	WebElement searchBtn;
	
	
	//Search By First Name
	@FindBy(id="SearchFirstName")
	@CacheLookup
	WebElement txtFirstName;
	
	//Search By Last Name
	@FindBy(id="SearchLastName")
	@CacheLookup
	WebElement txtLastName;
	
	//Table search results
	
	@FindBy(xpath="//table[@role='grid']")
	@CacheLookup
	WebElement tblSearchResults;
	
	//Table
	@FindBy(xpath="//table[@id='customers-grid']")
	WebElement table;
	
	//Number of Rows
	@FindBy(xpath="//table[@id='customers-grid']//tbody/tr")
	List<WebElement> tableRows;
	
	//Number of Columns
	@FindBy(xpath="//table[@id='customers-grid']//tbody/tr/td")
	List<WebElement> tableColumns;
	
	//Action Methods

	public void setEmail(String email) {
		waithelper.WaitForElement(searchByEmailId, 30);
		searchByEmailId.clear();
		searchByEmailId.sendKeys(email);
	}
	
	public void clkSearch() {
		
		searchBtn.click();
	}
	
	//Number of rows
	public int getNoOfRows() {
		return (tableRows.size());
	}
	
	//Number of columns
	public int getNoOfColumns() {
		return (tableColumns.size());
	}
	
	
	
	//to verify by email
	public boolean searchCustomerByEmail(String email) {
		boolean flag = false; //means email id not found
		
		for(int i=1;i<= getNoOfRows();i++) {
			String emailid = table.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr["+i+"]/td[2]")).getText();
			System.out.println(emailid);
			if(emailid.equals(email)){
				flag = true;
			}
			
		}
		
		
		return flag;
		
	}
	
	//search by customer first name  last name action method code
	
   public void SearchFirstName(String fname) {
	   waithelper.WaitForElement(txtFirstName, 30);
	   txtFirstName.clear();
	   txtFirstName.sendKeys(fname);
		
	}
   
   public void SearchLastName(String lname) {
	   waithelper.WaitForElement(txtFirstName, 30);
	   txtLastName.clear();
	   txtLastName.sendKeys(lname);
	   
   }
	
 //to verify by email
 	public boolean searchCustomerByName(String flname) {
 		boolean flag = false; //means email id not found
 		
 		for(int i=1;i<= getNoOfRows();i++) {
 			String name = table.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr["+i+"]/td[3]")).getText();
 			String names[] = name.split(" "); //separating first name and last name
 			System.out.println(names);
 			if(names[0].equals("Victoria") && names[1].equals("Terces")) {
 				flag=true;
 			}
 			
 		}
 		
 		
 		return flag;
 		
 	}
   
	
}
