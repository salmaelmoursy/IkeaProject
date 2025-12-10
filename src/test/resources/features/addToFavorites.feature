Feature: Add product to Favorites
    Background:
    Given the user is on IKEA homepage

  Scenario: Verify Add to Favorite Functionality

    When the user adds a random product to favorites
    And the user clicks View to open Favorites page
    Then the product should be displayed in the Favorites list
    When the user removes the product from favorites
    Then the Favorites list should be empty