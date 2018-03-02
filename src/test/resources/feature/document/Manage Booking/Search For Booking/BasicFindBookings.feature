@sprint:Sprint_17
@issue:FCPH-364
@issue:FCPH-369

  Feature: Basic searching for a booking works using valid criteria

#Search parameters are non case sensitive so no validation issue for upper or lower case - See BR_01791
#Validate First Name is not the only Search parameter provided See BR_02120
#Validate Last Name is provided with Title or at least 1 character from First Name. See BR_02130
#Generate a error message as per Booking Search Pod Error Validation when not valid
#Only email, title, firstname, lastname, postcode and travelfromdate included in this Story

    @defect @ignore
    @FCPH-7093
    Scenario Outline: Searching for an booking with search criteria in such way that there are no result
      When I search for a booking with unmatchable criteria using "<parameters>"
      Then an error is returned saying that no search results match the criteria
      Examples:
        |parameters|
        |firstName,title|
        |lastName,title|
        |postcode      |
        |travelToDate,travelFromDate     |
        |email    |

    @manual
    @untested
    Scenario Outline: Verify that booking withing the given traveldate are returned
      Given there are valid bookings
      When I search for a booking with travel date as "<parameters>"
      Then the bookings are returned as per the traveldate
      Examples:
        |parameters|
        |travelfromdate,traveltodate|
        |traveltodate|
        |travelfromdate|

    Scenario: Searching for an booking with missing channel
      When I search for the booking with a missing header "xposid"
      Then the error message is returned informing me that the header is required

    Scenario Outline: Search with empty query params
      Given there are valid bookings
      When I search for the booking but with empty "<fields>"
      Then the booking is returned
      Examples:
      |fields|
      |email |
      |email, referenceNumber|

    @manual
    Scenario: All query params are empty
      When I search for a booking with empty query params
      Then an error is returned informing me that no query paramaters were provided

   Scenario: Search is not performed when only firstname is provided
     Given there are valid bookings
     When I search for the booking using "firstName" of customer
     Then an error is returned informing me that I cannot search by only "firstName"

   Scenario: Search is not performed when only surname is provided
     Given there are valid bookings
     When I search for the booking using "lastName" of customer
     Then an error is returned informing me that I cannot search by only "lastName"

   @manual
    Scenario: Search with lastname requires title
     Given there are valid bookings
     When I search for the booking using "lastName,title" of customer
     Then the booking is returned

    Scenario: Search is not performed when invalid email is provided
      Given there are valid bookings
      When I search for the booking using invalid  "email" of customer
      Then an error is returned informing me that I cannot search by only "email"

    @manual
    Scenario Outline: Search with lastname requires at least one char in firstname
      Given there are valid bookings
      When I search for the booking using "lastName" and "<firstNamechars>" characters of the firstname
      Then the booking "<returns>" is returned
      Examples:
      |firstNamechars|returns|
      |0              |error  |
      |1              |result |
      |2              |result |

    @manual
    Scenario Outline: Search with different casing returns results
     Given there are valid bookings
     When I search for the booking using "<parameters>" in "<case>"
     Then the booking is returned
     Examples:
       |parameters|case|
       |email     |mixed|
       |firstName, lastName|camel|
       |firstName, title   |upper|
       |title, lastName    |mixed|
       |title, firstName, lastName|camel|
       |referencenumber                |upper|
       |referencenumber, title         |mixed|
       |referencenumber, title, lastName|lower|
       |referencenumber, lastName       |mixed|
       |referencenumber, firstName     |lower |
       |email, lastName           |camel      |
       |email, referencenumber         |upper |

