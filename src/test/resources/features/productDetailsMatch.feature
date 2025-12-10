Feature: Verify Product Details Match

  Background:
    Given the user is on IKEA homepage

  Scenario: Verify Product Details Match in Category Page & Product Page
    When user navigates to category
    And user notes the title and price of the first product
    And user clicks on the same product to open details page
    Then the product title and price should match the listing page