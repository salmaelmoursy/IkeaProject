Feature: Adding multiple favorites

  Background:
    Given the user is on IKEA homepage
  Scenario: Verify Adding Multiple Favorites in Session
  When the user adds three random products to favorites
  And the user navigates to the Favorites page
  Then all three products should be listed
  When the user removes one product from favorites
  Then the remaining two products should still be listed