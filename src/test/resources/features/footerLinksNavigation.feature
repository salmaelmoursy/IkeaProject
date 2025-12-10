Feature: Footer Navigation
  Background:
    Given the user is on IKEA homepage
  Scenario: Verify Terms and Conditions Page Navigation

    When the user scrolls to the footer section
    And the user clicks on the Terms and conditions link
    Then the page title should contain Terms and conditions