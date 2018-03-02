@Release:rel0.1
@Sprint:sprint_14
@Sprint:sprint_17
@issue:FCPH-320
@issue:FCPH-321
@issue:FCPH-435

Feature: findFlights for a set of search criteria

  Scenario: There are flights returned
    Given a flight exists
    When I call the find flights service for a valid flight
    Then flight is returned

  Scenario Outline: Find flight via channel
    Given a flight exists
    When I call the find flights service for a valid flight via "<channel>"
    Then flight is returned
    Examples:
      | channel         |
      | Digital         |
      | PublicApiMobile |
      | ADAirport       |

  Scenario:
    Given a flight exists
    When I call the find flights service for a valid flight
    Then the flight has a flight key

  Scenario Outline: Check that for maximum passengers currently 40
    Given a flight exists
    Given the maximum number of passengers is 40
    When I search for flight with "<passengerMix>" exceeding maximum
    Then "maximum passengers" error is returned
    Examples:
      | passengerMix      |
      | 40 Adult, 1 Child |
      | 1 Adult, 40 Child |
      | 39 Adult, 2 Child |

  Scenario: Error is returned if Outbound Date is before today
    When I search for flight with "outbound date is before today"
    Then "Outbound Date is before today" error is returned

  Scenario: Error is returned if Inbound Date is before Outbound Date
    When I search for flight with "inbound date is before outbound date"
    Then "Inbound Date is before Outbound Date" error is returned

  Scenario: Error is returned if Outbound Date is supplied in a wrong format
    When I search for flight with "outbound date in a wrong format"
    Then "Outbound Date in a wrong format" error is returned

  Scenario: Error is returned if Inbound Date is supplied in a wrong format
    When I search for flight with "inbound date in a wrong format"
    Then "Inbound Date in a wrong format" error is returned

  Scenario: Error is returned if no origin airport is provided
    When I search for flight with "no origin airport"
    Then "No origin airport" error is returned

  Scenario: Error is returned if no destination airport is provided
    When I search for flight with "no destination airport"
    Then "No destination airport" error is returned

  Scenario: Error is returned if incorrect destination airport is provided
    When I search for flight with "wrong destination airport"
    Then "incorrect destination airport" error is returned

  Scenario: Error is returned if incorrect origin airport is provided
    When I search for flight with "wrong origin airport"
    Then "incorrect origin airport" error is returned

  Scenario: Error is returned if incorrect route is provided
    When I search for flight with "wrong route"
    Then "route not flown" error is returned

  Scenario: Check for multiple errors returned when multiple incorrect parameters supplied for a search
    When I search for flight with "multiple incorrect search criteria"
    Then multiple error messages returned