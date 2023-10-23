Feature: Login
  Scenario: Failed login with a wrong username
    Given I open browser
    And Open website saucedemo
    And Located on saucedemo website
    When I input wrong username
    And I input valid password
    Then I should see and error message "Epic sadface: Username and password do not match any user in this service"