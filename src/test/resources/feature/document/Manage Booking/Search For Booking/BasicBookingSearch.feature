@release:Rel0.3
@sprint:Sprint_17
@issue:FCPH-363
@issue:FCPH-366

  Feature: Basic booking search is returned
  #Perform New Booking Search when valid
  #Only email, title, firstName, lastName, postcode and travelFromDate included in this Story

    Background:
      Given there are valid bookings

    Scenario: Booking search results are returned
      When I search for a booking
      Then the bookings matching the search criteria are returned

    Scenario: Booking search results are returned when using travelFromDate
      When I search for a booking using the travelfrom dates
      Then the bookings matching the search criteria are returned

    Scenario Outline: Lastname and firstname cannot be used on its own as a search criteria
      When I search for the booking using "<field>" of customer
      Then an error is returned informing me that I cannot search by only "<field>"
      Examples:
      |field|
      |lastName|
      |firstName|

    Scenario Outline: Searching for an existing booking using valid parameter mix returns results
      Given there are valid bookings
      When I search for the booking using "<parameters>" of customer
      Then the bookings matching the search criteria are returned
      Examples:
        |parameters|
        |email     |
        |firstName, lastName|
        |firstName, title   |
        |title   |
        |title, lastName    |
        | title, firstName, lastName |
        |postcode                |
        |postcode, title         |
        |postcode, title, lastName|
        #|postcode, lastName       |
        |postcode, firstName     |
        #|email, lastName           |
        |email, postcode         |
        |travelFromDate                     |
        |travelFromDate, firstName          |
        #|travelFromDate, lastName           |
        |travelFromDate, email              |
        |travelFromDate, firstName, lastName|
        |travelFromDate, referenceNumber    |
        |travelFromDate, title              |
        |postcode                           |


    Scenario Outline: Booking search results are returned specific to channel
      When I search for the booking using "<parameters>" of customer via "<channel>"
      Then the bookings matching the search criteria are returned
      Examples:
        | parameters                          | channel           |
        | email                               | ADAirport         |
        | firstName, lastName                 | ADCustomerService |
        | firstName, title                    | Digital           |
        | title                               | PublicApiB2B      |
        | title, lastName                     | PublicApiMobile   |
        | title, firstName, lastName          | ADAirport         |
        | postcode                            | ADCustomerService |
        | postcode, title                     | Digital           |
        | postcode, title, lastName           | PublicApiB2B      |
        #| postcode, lastName                  | PublicApiMobile   |
        | postcode, firstName                 | ADAirport         |
        #| email, lastName                     | ADCustomerService |
        | email, postcode                     | Digital           |
        | travelFromDate                      | PublicApiB2B      |
        | travelFromDate, firstName           | PublicApiMobile   |
        #| travelFromDate, lastName            | ADAirport         |
        | travelFromDate, email               | ADCustomerService |
        | travelFromDate, firstName, lastName | ADCustomerService |
        | travelFromDate, referenceNumber     | Digital           |
        | travelFromDate, title               | PublicApiMobile   |
        | postcode                            | PublicApiMobile   |


    @manual
    Scenario: Booking search is returned in date/Time ascending order by default
      When I search for a booking
      Then the bookings are returned in date time order

      @manual
      Scenario Outline: Return bookings with expected status to respective channels
      Given a booking with status of "<status>"
        When I search for the booking via "<channel>"
        Then the booking "<shouldornot>" be returned
        Examples:
        |status|channel|shouldornot|
        |Complete|Digital|should  |
        |Complete|Public|should|
        |Complete|AD    |should|
        |Pending Cancellation|Digital|should not|
        |Pending Cancellation|Public|should not|
        |Past|Digital|should|
        |Customer Cancelled|Public|should|
        |Disruption Cancelled|Digital|should |
        |Disruption Cancelled|AD|should |
        |Cancelled by Revenue Protection|AD|should|
        |Cancelled by Revenue Protection||should|
        |Complete|AD    |should|
        |Pending Cancellation|AD|should|
        |Past|AD|should |
        |Chargeback - Policy Revenue Protection|AD|should|
        |Chargeback - Fraud Revenue Protection|AD|should|
        |Customer Cancelled|AD|should|
        |Chargeback - Policy Revenue Protection|Digital|should not|
        |Chargeback - Fraud Revenue Protection|Public|should not|

# AD allowed status - |Complete |Past|Customer Cancelled| Pending Cancellation|Cancelled by Revenue Protection|Chargeback - Policy Revenue Protection |Chargeback - Fraud Revenue Protection | Past|


    @manual
    Scenario Outline: Bookings within x period after last flight are returned to the requesting channel
      Given a booking with period of "<period>"
      When I search for the booking via "<user>"
      Then the booking "<shouldornot>" be returned
      Examples:
        |period|user|shouldornot|
        |24 months|AD-Airport|should  |
        |26 months|AD-CustomerAgent|should not|
        |24 months|AD-CustomerAgent|should|
        |6 months|Digital|should  |
        |6 months|Public|should  |
        |24 months|Public|should not|

     @manual
    Scenario Outline: Bookings less than 6 years and 2 months from travel date are returned to the agent desktop based on permissions.
      Given a booking with criteria "<criteria>"
      When I search for booking via <channel>
      Then the booking "<shouldornot>" be returned
      Examples:
        |criteria|channel|shouldornot|
        |less than 2Y6M travel date |AD-Airport|should not |
        |greator than 2Y6M travel date |AD-Airport|should not|
        |less than 2Y6M travel date |AD-CustomerAgent|should |
        |less than 2Y6M travel date |AD-HeadOffice|should|
        |less than 2Y6M travel date |AD-Airport|should not|
        |less than 2Y6M travel date |Public|should not|

#        |channel| permission|
#        | AD-Airport  |N|
#        | AD-CustomerAgent |Y|
#        | AD-HeadOffice| Y|
#        | Public  |N|

#    Scenario Outline: Booking search results are returned based on single search parameter
#      When I request the booking details with <criteria> <value>
#      Then All search result satisfying the criteria is returned with "success"
#      Examples:
#        |criteria| value|
#        |   email    | test@easyjet.com     |
#        |     travelDate  | 02/15/2018       |
#        |    postcode             |     SL14DX|
#
#
##      FCSH-364
#    Scenario Outline: Booking search results are returned based on single search parameter
#      When I enter only lastName <lastName> as search criteria
#      Then I should get error message below the field as
#    "Please enter either a title or First Name of the customer"
#      Examples:
#        |lastName|
#        |Francis|


