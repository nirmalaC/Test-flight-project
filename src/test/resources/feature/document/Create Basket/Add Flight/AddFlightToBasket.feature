@Release:rel0.2
@Sprint:sprint_15
@issue:FCPH-3642
@issue:FCPH-167

Feature: Add Flight to basket

  Scenario Outline: Adding a flight from Agent Desktop channel hard grabs the flights
    Given I have found a valid flight via the "<channel>" channel
    When I add the flight to my basket via the "<channel>" channel
    Then the inventory is allocated via the "<channel>" channel
    Examples:
      | channel           |
      | ADAirport         |
      | ADCustomerService |

  Scenario: Empty Basket
    Given my basket contains flight with passengerMix "1 Adult"
    When call empty basket service
    Then basket is empty

  Scenario Outline: Adding a flight from non-Agent Desktop channel does not hard grab the flights
    Given I have found a valid flight via the "<channel>" channel
    When I add the flight to my basket via the "<channel>" channel
    Then the inventory is not yet allocated
    Examples:
      | channel         |
      | PublicApiMobile |
      | Digital         |

  @defect @ignore
  @FCPH-7038
  Scenario Outline: Flight base price is the same when added to the basket
    Given I have found a valid flight via the "<channel>" channel
    When I add the flight to my basket via the "<channel>" channel
    Then the baseprice and associated taxes are the same in the basket
    Examples:
      | channel           |
      | ADAirport         |
      | Digital           |
      | ADCustomerService |
      | PublicApiB2B      |
      | PublicApiMobile   |


  @manual
  Scenario: A hard-grabbed flight that fills the plane capacity will not show in search results
    Given a flight that is nearly full
    And the remaining seats have been allocated
    When I search for the flight
    Then it is not returned in the list of available flights

  @manual
  Scenario: Concurrent allocation from multiple channels
    Given there is one seat unallocated on a flight
    When two Agent Desktop channels attempt to add the flight to a basket at the same time
    Then the one flight is allocated
    And the second returns an error

  @issue:FCPH-164
  Scenario Outline: Check AddFlight() request returns a response for an outbound flight
    Given I have found a valid flight via the "<channel>" channel
    When I add the flight to my basket via the "<channel>" channel
    Then the flight is added to the basket via the "<channel>"
    Examples:
      | channel           |
      | ADAirport         |
      | ADCustomerService |
      | Digital           |
      | PublicApiB2B      |
      | PublicApiMobile   |

@manual
  Scenario Outline: Check AddFlight() request returns a response for a return flight
    Given I have a outbound flight in my basket via the  "<channel>" channel
    When I add the inbound flight to my basket via the "<channel>" channel
    Then the flight is added to the basket

    Examples:
      | channel           |
      | Digital           |
      | ADAirport         |
      | ADCustomerService |
      | B2B               |
      | Digital           |
      | PublicApiB2B      |
      | PublicApiMobile   |
      | Airport           |