Feature: Login
  Scenario: Failed login with a wrong username
    Given I open browser
    And Open website saucedemo
    When I input wrong username
    And I input valid password
    And Click Login button
    Then I should see an error message "Epic sadface: Username and password do not match any user in this service"

  Scenario: Successful login
    Given I open browser
    And Open website saucedemo
    When I input valid username
    And I input valid password
    And Click Login button
    Then  I go to homepage
