Feature: Verify Checkout Flow Requires Payment Details


  Background:
    Given the user is on IKEA homepage

  Scenario: Payment details must be provided before confirming order
    When the user searches for a random product and adds it to the bag
    And the user navigates to the shopping bag page
    And the user clicks on Checkout
    And the user fills in the billing address with valid data
    And the user selects a delivery date and time if available
    And the user chooses a payment method
    And the user stops before confirming the payment
    Then the system should require payment details in the final step