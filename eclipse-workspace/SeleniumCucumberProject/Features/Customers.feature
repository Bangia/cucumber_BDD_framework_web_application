Feature: customer

  Background: Below are common steps for each scenarios
    Given Launch your Chrome Browser
    When Open URL  as "https://admin-demo.nopcommerce.com/"
    And Enter email id as "admin@yourstore.com" and password as "admin"
    And Click on Login button.
    Then User can view dashboard screen.

@sanity
  Scenario: Adding a new customer
    When User click on customer menu
    And Click on customer menu item
    And Click on add new button
    Then User can view add new customer page
    When User enters customer info
    And Click on save button
    Then User can view confirmation message "The new customer has been added successfully."
    And close your browser.

@regression
  Scenario: Search Customer by Email Id
    When User click on customer menu
    And Click on customer menu item
    And Enter customer email id
    When Click on search button
    Then user should found email id in search table.
    And close your browser.

@regression
  Scenario: Search Customer by Name
    When User click on customer menu
    And Click on customer menu item
    And Enter customer FirstName
    And Enter customer LastName
    When Click on search button
    Then user should found Name in search table.
    And close your browser.
