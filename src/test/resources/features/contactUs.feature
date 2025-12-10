Feature: IKEA Website Functional Tests

  Background:
    Given the user is on IKEA homepage

  Scenario: Verify Contact Us Page
    When the user scrolls to the footer
    And the user clicks on Contact Us
    Then the Contact Us page should load and contact options should be displayed