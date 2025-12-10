Feature: Verify Multiple Filter Combination

  Scenario: Verify that applying multiple filters shows correct products
    Given the user is on IKEA homepage
    When the user navigates to the "Beds" category
    And the user applies the following filters:
    Then all displayed products should match the filters:
