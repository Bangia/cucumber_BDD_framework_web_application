Feature: Login

@smoke
Scenario: Successful Login with Valid Credentials.
	Given Launch your Chrome Browser
	When Open URL  as "https://admin-demo.nopcommerce.com/"
	And Enter email id as "admin@yourstore.com" and password as "admin"
	And Click on Login button.
	Then Page title should be "Dashboard / nopCommerce administration"
	When clicks on Logout link
	Then Page title should be "Your store. Login"
	And close your browser.
	 
@sanity
Scenario Outline:  Login Mutiple login id as Data Driven Approach
	Given Launch your Chrome Browser
	When Open URL  as "https://admin-demo.nopcommerce.com/"
	And Enter email id as "<email>" and password as "<password>"
	And Click on Login button.
	Then Page title should be "Dashboard / nopCommerce administration"
	When clicks on Logout link
	Then Page title should be "Your store. Login"
	And close your browser.
	
	Examples:
			| email | password |
			| admin@yourstore.com | admin |
			| admin1@yourstore.com | admin123 |