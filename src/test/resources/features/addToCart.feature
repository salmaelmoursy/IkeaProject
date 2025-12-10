Feature: Add product to shopping cart
Background:
    Given the user is on IKEA homepage
  Scenario: Verify that a product can be added twice to the shopping cart

    When the user opens the lighting category
    And the user navigates to Lamps section
    And the user adds a random product to the bag
    And the user opens the same product and adds it again
    Then the cart should show quantity as two