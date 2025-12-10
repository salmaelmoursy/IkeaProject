Feature: Product Search
Background:
    Given the user is on IKEA homepage
  Scenario: Verify that the search bar returns relevant product results
    When   Enter a product keyword in the search bar
    And Click the search icon
    Then Ensure the products displayed related to the keyword