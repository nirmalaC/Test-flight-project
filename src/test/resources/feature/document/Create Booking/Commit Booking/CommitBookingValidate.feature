@issue:FCPH-400
@issue:FCPH-401
@issue:FCPH-402
@Sprint:sprint_17

Feature: Check errors for non-valid request


  @defect @ignore
  @FCPH-6694
  Scenario Outline: Check all validation error response
    When I do the commit booking for "<Parameter>"
    Then an error message is returned for each "<Parameter>"

    Examples:
      | Parameter              |
      | MissingPaymentMethods  |
      | MissingPaymentMethod   |
      | MissingPaymentCode     |
      | MissingPaymentAmount   |
      | MissingPaymentCurrency |
      | MissingPaymentToken    |
      | InvalidBasket          |
      | InvalidPaymentAmount   |
      | InvalidPaymentMethod   |
      | InvalidPaymentCode     |
      | InvalidBookingType     |
      | InvalidBookingReason   |
      | PaymentMismatched      |


  @manual
  @untested
  @defect @ignore
  @FCPH-6821
  Scenario: Error is returned if duplicate booking found
    Given I have a valid booking
    And I have a basket with duplicate booking
    When I do the commit booking
    Then an error message is returned for duplicate booking