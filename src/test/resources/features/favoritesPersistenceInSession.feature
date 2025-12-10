Feature: Verify Favorites Persistence in Session
Background:
Given the user is on IKEA homepage
  Scenario: Verify that favorites persist during the session

    When the user selects a random product and add to fav
    And  user navigates to the "Kitchen" category
    And the user goes to the favorites page
    Then the previously added product should be displayed in the favorites list
    When user removes the product from favorites
    Then the product should no longer appear in the favorites list