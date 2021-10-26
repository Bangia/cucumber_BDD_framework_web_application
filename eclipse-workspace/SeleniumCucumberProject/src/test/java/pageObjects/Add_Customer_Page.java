package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Add_Customer_Page {

	public WebDriver ldriver;
	
    //Create constructor with PageFactory.initElements
	public Add_Customer_Page(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this );
	}
	
	//Create relevant web elements
	
	@FindBy(xpath="//a[@class='btn btn-primary']")
	@CacheLookup
	WebElement AddBtn;
	
	@FindBy(xpath="//a[@href='#']//p[contains(text(),'Customers')]")
	@CacheLookup
	WebElement lnkCustomers_menu;
	
	@FindBy(xpath="//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]")
	@CacheLookup
	WebElement lnkCustomers_menu_item;
	
	
	
	@FindBy(id="Email")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(id="Password")
	@CacheLookup
	WebElement txtpwd;
	
	@FindBy(id="FirstName")
	@CacheLookup
	WebElement txtName;
	
	@FindBy(id="LastName")
	@CacheLookup
	WebElement txtLastName;
	
	//Gender
	@FindBy(id="Gender_Male")
	@CacheLookup
	WebElement Gdmale;
	
	@FindBy(id="Gender_Female")
	@CacheLookup
	WebElement GdFemale;
	
	//DOB
	@FindBy(id="DateOfBirth")
	@CacheLookup
	WebElement dob;
	
	
	
	@FindBy(id="Company")
	@CacheLookup
	WebElement txtCompany;
	
	//Check box
	@FindBy(id="IsTaxExempt")
	@CacheLookup
	WebElement taxExmpt;
	
	
	//newsletter
	@FindBy(xpath="//div[@class='k-multiselect-wrap k-floatwrap']")
	@CacheLookup
	WebElement letter;
	
	//Roles
	
	
	//vendor
	@FindBy(id="VendorId")
	@CacheLookup
	WebElement vdID;
	
	
	@FindBy(name="AdminComment")
	@CacheLookup
	WebElement AdmComment;
	
	@FindBy(name="save")
	@CacheLookup
	WebElement sbtBtn;
	
	
	
	//Action methods
	
	public String getPageTitle() {
		return  ldriver.getTitle();
	}
	
	
	public void clickMenu() {
		lnkCustomers_menu.click();
	}
	
	public void clickMenuItem() {
		lnkCustomers_menu_item.click();
	}
	
	public void addNewButton() {
		AddBtn.click();
	}
	
	
	public void setName(String emails) {
		txtEmail.sendKeys(emails);
	}
	
	public void setPwd(String password) {
		txtpwd.sendKeys(password);
	}
	
	public void setFirstName(String fname) {
		txtName.sendKeys(fname);
	}
	
	public void setLastName(String lname) {
		txtLastName.sendKeys(lname);
	}
	
	
	//GENDER CODE
	public void setGender(String gender) {
		if(gender.equals("Male")) {
			Gdmale.click();
		}
		else if(gender.equals("Female")) {
			GdFemale.click();
		}
		else {
			Gdmale.click();
		}
		
	}
	
	//DOB
	
	public void setcompanyName(String company) {
		txtCompany.sendKeys(company);
	}
	
	//Is tax exempt
	public void taxClick() {
		taxExmpt.click();
	}
	
	
	//Newsletter
	public void setLetter() {
		Select selectLetter = new Select(letter);
		selectLetter.selectByIndex(1); //Your store name
		
	}
	//roles
	
	
	
	//vendor
	public void setVendor() {
		Select drop = new Select(vdID);
		drop.selectByIndex(1); //Vendor 1
		
	}
	
	public void addComment(String comments) {
		AdmComment.sendKeys(comments);
	}

	public void submitButton() {
		sbtBtn.click();
	}
}
