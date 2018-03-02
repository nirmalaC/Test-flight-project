@issue:FCPH-273

Feature: Adding basic passenger details to a basket

  Background:
    Given I have set values for Adult, Child and Infant

  Scenario Outline: Add basic passenger details to a basket for passengers
    Given my basket contains "<passengerMix>"
    When I provide basic passenger details
    Then the basket is updated with the details
    Examples:
      | passengerMix      |
      | 1 Adult           |
      | 1 Adult, 1 Child  |
      | 2 Adults, 1 Child |