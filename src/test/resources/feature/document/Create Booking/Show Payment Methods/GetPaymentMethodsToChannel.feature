@TBA
@P1
@issue:FCPH-316
@issue:FCPH-439
@issue:FCPH-313
@issue:FCPH-322
@Sprint:sprint_17

Feature: Return the list of applicable payment methods

  Scenario Outline: Validation error message returned for the missing mandatory field
    Given I have a valid basket with passengers and associated customer
    When I call the getPaymentMethods service with missing <Parameter>
    Then the <Parameter> validation error is returned
    Examples:
      | Parameter  |
      | CustomerId |
      | BasketId   |

  @issue:FCPH-7087
  Scenario Outline: Return the list of applicable payment methods by channel
    Given I have a valid basket with passengers and associated customer created via "<Channel>"
    When I call the service to retrieve payment methods for "<Channel>"
    Then the applicable payment methods are returned for "<Channel>"
    Examples:
      | Channel           |
      | ADAirport         |
      | ADCustomerService |
      | Digital           |
      | PublicApiMobile   |
      | PublicApiB2B      |