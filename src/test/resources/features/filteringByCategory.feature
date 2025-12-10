Feature: Filter products by price
  Background:
    Given the user is on IKEA homepage
  Scenario: Verify Filtering by Category
    When the user searches for "Living room"
    And the user applies filter Price: Low to High
    Then the products should be sorted from lowest to highest price