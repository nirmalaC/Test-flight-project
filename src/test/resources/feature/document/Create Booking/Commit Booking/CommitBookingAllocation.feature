@issue:FCPH-403
@issue:FCPH-404
@Sprint:sprint_17

Feature: Seats are allocated following booking for non-AD

  @defect @ignore
  @FCPH-7019
  Scenario Outline: Inventory is allocated without passenger mix for non-agent channel
    Given I have a basket with a valid flight for "<channel>"
    When I do the commit booking
    Then the inventory is allocated
    Examples:
      | channel         |
      | Digital         |
      | PublicApiMobile |
      | PublicApiB2B    |

  @manual
  Scenario Outline: The inventory is allocated with passengermix for non-agent channel
    Given I have "<outboundflight>","<inboundflight>" flights with passenger mix for non-agent "<channel>"
    When I do the commit booking
    Then the inventory is allocated

    Examples:
      | channel | outboundflight                                   | inboundflight                                    |
      | Digital | 1 Adult, 1 Child, 1 InfantOnLap                  | 1 Adult, 1 Child, 1 InfantOnLap                  |
      | P       | 2 Adults, 1 Child, 1 InfantOnLap, 1 InfantOnSeat | 2 Adults, 1 Child, 1 InfantOnLap, 1 InfantOnSeat |

  @manual
  Scenario: Deallocate the inventory if flight is cancelled for ADAirport
    Given I have a basket with a valid flight for "ADAirport"
    And the flight operational status is changed to "Cancelled"
    When I do the commit booking
    Then the inventory is deallocated once the flight is cancelled
    And an error message is returned for the cancelled flight

  @manual
  Scenario: Not deallocate the inventory if flight is cancelled for Digital
    Given I have a basket with a valid flight for "Digital"
    And the flight operational status is changed to "Cancelled"
    When I do the commit booking
    Then the inventory is not deallocated once the flight is cancelled
    And an error message is returned for the cancelled flight



