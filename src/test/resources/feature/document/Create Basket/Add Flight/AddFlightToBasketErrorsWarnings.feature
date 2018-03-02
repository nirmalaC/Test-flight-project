@release:Rel_0.1
@sprint:Sprint_16
@sprint:Sprint_17
@issue:FCPH-165
@issue:FCPH-166
@issue:FCPH-170

Feature: Validation Errors for Add Direct Flight

  #curently set to 9999 as BR requires it to be unlimited
  @manual
  Scenario: Maximum flight configuration cannot be breached
    Given the maximum number of flights maximum is 6
    And I have added 6 flights to my basket
    When I add the flight to my basket
    Then error "maximum number of flights exceeded" is returned

  @defect @ignore
  @FCPH-6690
  Scenario: Cannot add flight when number of infants on their own seats is exceeding the flight's limit.
    Given I have a valid flight that exceeds the infant on own seat limit
    When I try to add the flight to my basket
    Then the "number of infants exceeded" error should be returned
    And the flight is not added to the basket

  #@defect @ignore
  #@FCPH-6898
  Scenario: Cannot add multiple infants on lap to single adult
    Given a valid flight exists with "1 Adult, 2 Infants OOS" seats available
    When I try to add the flight to my basket with the pasenger mix "1 Adult, 2 Infants OL"
    Then the infants are not associated to one adult
    And the total number of passengers is 3

  @manual
  Scenario: Cannot add a cancelled flight to the basket
    Given I have a cancelled flight
    When I try to add the flight to my basket
    Then the "cancelled flight" error should be returned
    And the flight is not added to the basket

  @manual
  Scenario: Cannot add a flight to the basket if departing within x hours.
    Given I have a flight departing within the valid booking hours
    When I try to add the flight to my basket
    Then the "flight leaving" error should be returned
    And the flight is not added to the basket

  @issue:FCPH-167
  Scenario: Verify that the example ACP sends the notification and provide a flag to the channel for price change.
    Given I have a flight fare that has different price now to what it was when first received
    When I try to add the flight to my basket
    Then the "flight fare" warning should be returned
    And the flight is added to the basket

  @issue:FCPH-165
  Scenario Outline: Validate the request body of addFlight() service.
    Given I have a flight request with missing "<FieldKey>"
    When I attempt to add the flight to my basket
    Then the "<FieldKey>" error should be returned
    And the flight is not added to the basket
    Examples:
      | FieldKey    |
      | fareType    |
      | flightKey   |
      | journeyType |
      | price       |
      | passengers  |

  #Technical_Errors_SVC_100012_100
  Scenario Outline: Validate the request body field values of addFlight() service.
    Given I have a flight request with invalid "<FieldKey>"
    When I attempt to add the flight to my basket
    Then the "<FieldKey>" invalid field error should be returned
    And the flight is not added to the basket
    Examples:
      | FieldKey           |
      | journeyTypeInvalid |

    #Business_Errors_SVC_100012_30
  @manual
  Scenario Outline: Validate the response for addFlight() service due to business errors.
    Given I have flights available
    When I request addFlight with no X-Test header
    Then I should receive the error "<Code>" and "<Message>"
    And the flight is not added to the basket
    Examples:
      | Code            | Message                                                                     |
      | SVC_100012_3011 | Error as the inventory returned back has no data or inventory not allocated |