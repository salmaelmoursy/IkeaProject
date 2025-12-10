Feature: Verify product details page
  Background:
    Given the user is on IKEA homepage
  Scenario: Verify that clicking a product opens the product details page
    When the user clicks a random product on the home page
    Then the product details page should be opened
    And the product details should match the home page details

