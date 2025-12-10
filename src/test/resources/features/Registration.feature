Feature: User Registration
Background:
  Given the user is on IKEA homepage
  Scenario: Register new user
    When the user navigates to create account page
    And the user enters valid registration data
    And the user clicks register
    Then the account should be created successfully
