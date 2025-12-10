Feature: IKEA Website Functional Tests

  Background:
    Given the user is on IKEA homepage

Scenario: Verify Adding and Updating Quantity in Cart
When the user searches for  "Chair"
And the user adds one product to the cart
And the user navigates to the cart
And the user updates the quantity from 1 to 3
Then the subtotal should be equal to unit price multiplied by 3