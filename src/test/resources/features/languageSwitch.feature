Feature: Language Switch
  Background:
    Given the user is on IKEA homepage
  Scenario: Verify Language Switch

    When the user locates the language selector
    And the user switches from English to Arabic
    Then the page content should be displayed in Arabic