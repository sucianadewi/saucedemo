# new feature
# Tags: optional

Feature: Buy Product

  Background:
    Given I open the browser
    And I log in

  Scenario: Valid user can buy product from the Homepage
    Given I already Login to the website
    When I click add to cart button
    And I click Cart icon on the top right side website
    And I clik Checkout button
    And I fill in customer information
    And I click Finish button
    Then I successfully order product

  Scenario: Valid user can buy product from the Homepage without fill in customer information
    Given I already Login to the website
    When I click add to cart button
    And I click Cart icon on the top right side website
    And I clik Checkout button
    But I does not fill in customer information
    Then System should display error message "Error: First Name is required"