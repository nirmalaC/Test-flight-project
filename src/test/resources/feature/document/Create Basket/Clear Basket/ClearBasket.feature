@sprint:Sprint_16
@sprint:Sprint_17
@issue:FCPH-422
@issue:FCPH-438
Feature: Basket is cleared on request

  Scenario: Basket is cleared when requested
    Given I have a basket with a valid flight
    When I clear the basket
    Then the basket is emptied

  Scenario: Basket with multiple flights is cleared when requested
    Given I have a basket with valid multiple flights
    When I clear the basket
    Then the basket is emptied

  @defect @ignore
  @FCPH-6999
  Scenario Outline: Flights are deallocated when a basket is cleared
    Given I have a basket with a valid flight added via "<channel>"
    When I clear the basket via "<channel>"
    Then the flights are deallocated
    Examples:
      | channel           |
      | ADAirport         |
      | ADCustomerService |

  @defect @ignore
  @FCPH-6999
  Scenario Outline: Flights are deallocated when a basket with multiple flights is cleared
    Given I have a basket with valid multiple flights added via "<channel>"
    When I clear the basket via "<channel>"
    Then all the flights are deallocated
    Examples:
      | channel           |
      | ADAirport         |
      | ADCustomerService |


  Scenario Outline: Flights are not deallocated via some channels
    Given I have a basket with a valid flight added via "<channel>"
    When I clear the basket via "<channel>"
    Then the flights are not further deallocated
    Examples:
      | channel         |
      #| PublicApiMobile |
      #| Digital         |
      | PublicApiB2B    |