@sprint:Sprint_15,
@sprint:Sprint_16
@sprint:Sprint_17
@issue:FCPH-2672
@issue:FCPH-386
@issue:FCPH-487

Feature: Apportion Admin Fee for Add Flight - same bundle

  Background:
    Given I know the admin fee

  Scenario Outline: Verify Admin fee is apportioned per passenger per sector
    Given my basket contains "<noOfFlights>" flights for "<noOfPassengers>" passengers added via the "<channel>" channel
    Then the admin fee should be apportioned per passenger per sector and wrapped up in the flight fare of the first flight Only
    Examples:
      | channel          | noOfFlights  | noOfPassengers | Notes                                |
      | Digital          | 3                 | 9                   | ADMIN FEE / (PASSENGERS * SECTORS)   |
      | Digital          | 4                 | 3                   | ADMIN FEE / (PASSENGERS * SECTORS)   |
      #| PublicApiMobile | 39               | 4                   | ADMIN FEE / (PASSENGERS * SECTORS)   - this will be added as soon as there is a switch functionality implemented for OFT / Non OFT prices|
      #| PublicApiB2B    | 10               | 4                   | ADMIN FEE / (PASSENGERS * SECTORS)   - same as above|
      # possibly test rounding later

  @defect @ignore
  @FCPH-7094
  Scenario Outline: Verify Admin fee is apportioned per passenger for first two sectors only if it is a return pair
    Given my basket contains return flight for "<noOfPassengers>" passengers added via the "<channel>" channel
    When I add another "<noOfFlightsToAdd>" flight with "<noOfPassengersToAdd>" passengers to the basket via the "<channel>" channel
    Then the admin fee should be apportioned per passenger and rounded to the nearest pence for the first two sectors only
    Examples:
      | channel           | noOfPassengers | noOfFlightsToAdd | noOfPassengersToAdd |
      | Digital           | 4              | 2                | 4                   |
      | Digital           | 4              | 3                | 5                   |
      | Digital           | 3              | 1                | 2                   |
      | Digital           | 5              | 2                | 4                   |
    #May fail on scenario two as it will have an empty parameter for last two data sets. Let me know if you want me to furthe rinvestigate with Test/BA

  @manual
  Scenario Outline: Verify fees and taxes are apportioned per passenger
    Given I have found a valid flight for multiple passengers for channel "<channel>" and bundle "<bundleType>"
    When I add the flight to my basket
    Then the admin fee should be apportioned per passenger and rounded to the nearest pence for the first 2 sectors
    And Flight tax is apportioned per passenger
    And credit card fee is added at order level based on language set

    Examples:
      | channel           | bundleType |
      | PublicApiMobile   | Standard   |
      | ADAirport         | Flexi      |
      | ADCustomerService | Standard   |

    # still debating how to apportion taxes and fees

  Scenario Outline: Verify that admin fee is stored at the booking level
    When I add the "<NumberOfFlights>" flights with "<NumberOfPassengers>" passengers to my basket via "<channel>"
    Then the credit card fee for each passenger is correct for the "<channel>"
    And the administration tax is at booking level
   #ADMIN FEE / (PASSENGERS * SECTORS)  ##question regarding PublicApiB2B  regarding distribution of Admin Fees it is not the same as AD
    And the total fare with credit card is at booking level
   #(BASE PRICE + ADMIN FEE) * CREDIT CARD PERCENTAGE
    Examples:
      | channel           | NumberOfFlights    | NumberOfPassengers |
      | ADCustomerService | 2                  | 4                  |
      | ADAirport         | 3                  | 5                  |
      #| PublicApiB2B      | 4                  | 2                  |
      #| PublicApiMobile   | 1                  | 1                  |
