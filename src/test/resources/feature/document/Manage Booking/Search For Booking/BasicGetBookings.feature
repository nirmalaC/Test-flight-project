@sprint:Sprint_17
@issue:FCPH-2716
@issue:FCPH-2614

Feature: Retrieve full booking details


  Background:
    Given I have an existing booking

  Scenario: Receive the booking details for given booking reference number
    When I search for a booking with reference number
    Then Booking details with matching reference number are returned

  @manual
  Scenario Outline: Verify that Booking has correct status to make changes based on channel
    Given I have booking with "<status>"
    When I request the booking details for "<channel>"
    Then I get respective allowed functions "<function>" in response based on booking status and permission
    Examples:
      | channel | status                                 | function      |
      | AD      | Complete                               | CHANGE_FLIGHT |
      | AD      | Customer Cancelled                     |               |
      | AD      | Past                                   |               |
      | AD      | Chargeback - Policy Revenue Protection |               |
      | AD      | Chargeback - Fraud Revenue Protection  |               |
      | Digital | Complete                               | CHANGE_FLIGHT |
      | Digital | Customer Cancelled                     |               |
      | Digital | Past                                   |               |
      | Digital | Chargeback - Policy Revenue Protection |               |
      | Public  | Past                                   |               |


  @manual
  Scenario Outline:  Booking changes can be made based on time before departure and Agent permission
    Given I have booking which are departing at "<depart_diff>"
    When I request the booking details for "<agent>"
    Then I get the allowed functions "<functions>" in the booking details response based on departure time and user
    Examples:
      | depart_diff | agent                | functions     |
      | +2          | ADAirport            | CHANGE_FLIGHT |
      | -2          | ADAirport            | CHANGE_FLIGHT |
      | +2          | HeadOffice Agent     | CHANGE_FLIGHT |
      | -2          | HeadOffice Agent     | CHANGE_FLIGHT |
      | -1          | Contact Center Agent | CHANGE_FLIGHT |
      | +1          | Contact Center Agent |               |
      | -2          | Contact Center Agent |               |


  Scenario: Verify Bookings details with Invalid booking reference
    When I search for a booking with invalid reference number
    Then I get error in response informing me that there are no bookings


