Feature: User Login
  Background:
    Given the user is on IKEA homepage
  Scenario: Verify that an existing user can log in.
    When  Click on the login button
    And Enter valid email and password(use the same fake email used in register)
    Then The user log in successfully