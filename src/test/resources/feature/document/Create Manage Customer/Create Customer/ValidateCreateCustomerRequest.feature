@sprint:Sprint_18
@issue:FCPH-2769

Feature: Validate and create customer profile creation request

  Scenario: Create customer profile
    Given a valid request to create a customer profile
    When I request creation of a customer profile
    Then the customer profile is created

  Scenario Outline: Validate that request by channel validate the fields exist in the request
    Given I have provided valid mandatory fields for "<channel>" with the missing field "<field>"
    When I request creation of a customer profile
    Then I will get a customer creation error for the missing field "<field>"
    Examples:
      | channel           | field             | notes     |
      | Digital           | title             | Mandatory |
      | Digital           | firstName         | Mandatory |
      | Digital           | lastName          | Mandatory |
      | Digital           | email             | Mandatory |
      | Digital           | addressLine1      | Mandatory |
      #| Digital           | town            | Mandatory |
      | Digital           | city              | Mandatory |
      | Digital           | postalCode        | Mandatory |
      | Digital           | optedOutMarketing | Mandatory |
      | Digital           | phoneNumber       | Mandatory |
      | Digital           | password          | Mandatory |
      | ADAirport         | title             | Mandatory |
      | ADAirport         | firstName         | Mandatory |
      | ADAirport         | lastName          | Mandatory |
      | ADAirport         | email             | Mandatory |
      | ADAirport         | addressLine1      | Mandatory |
      #| ADAirport         | town            | Mandatory |
      | ADAirport         | city              | Mandatory |
      | ADAirport         | postalCode        | Mandatory |
      | ADAirport         | optedOutMarketing | Mandatory |
      | ADAirport         | phoneNumber       | Mandatory |
      | ADCustomerService | title             | Mandatory |
      | ADCustomerService | firstName         | Mandatory |
      | ADCustomerService | lastName          | Mandatory |
      | ADCustomerService | email             | Mandatory |
      | ADCustomerService | addressLine1      | Mandatory |
      #| ADCustomerService | town            | Mandatory |
      | ADCustomerService | city              | Mandatory |
      | ADCustomerService | postalCode        | Mandatory |
      | ADCustomerService | optedOutMarketing | Mandatory |
      | ADCustomerService | phoneNumber       | Mandatory |

  Scenario Outline: Non Mandatory fields for a channel can be missing
    Given a valid request to create a customer profile
    And the optional field "<field>" is missing
    When I request creation of a customer profile
    Then the customer profile is created
    Examples:
      | channel | field          | notes    |
      | Digital | NIF            | Optional |
      | Digital | EJ Plus        | Optional |
      | Digital | Altername Tele | Optional |
      | Digital | Travel Pref    | Optional |
      | Digital | Age            | Optional |

  Scenario: Email address is already registered
    Given an existing customer profile with known e-mail address
    When I request creation of a new customer profile with the same e-mail address
    Then an email registered validation error is returned

  @manual
  @untested
  Scenario: Email address is available for recycle
    Given a valid request to create a customer profile
    And the email address is availabel for recycling
    When I request creation of a customer profile
    Then the customer profile is created

  Scenario Outline: Format of the Customer Name
    Given a valid request to create a customer profile
    But the "<field>" is not valid because it contains "<invalidChars>"
    When I request creation of a customer profile
    Then I will get a Invalid character error for "<field>"
    Examples:
      | field     | invalidChars |
      | firstName | "            |
      | firstName | \            |
      | firstName | %            |
      | firstName | +            |
      | firstName | /            |
      | firstName | \|           |
      | firstName | 0            |
      | firstName | 1            |
      | firstName | 2            |
      | firstName | 3            |
      | firstName | 4            |
      | firstName | 5            |
      | firstName | 6            |
      | firstName | 7            |
      | firstName | 8            |
      | firstName | 9            |
      | firstName | +            |
      | firstName | ;            |
      | firstName | :            |
      | firstName | !            |
      | firstName | ?            |
      | firstName | <            |
      | firstName | >            |
      | firstName | (            |
      | firstName | )            |
      | firstName | .            |
      | firstName | ,            |
      | firstName | @            |
      | firstName | #            |
      | firstName | $            |
      | firstName | £            |
      | firstName | ^            |
      | firstName | &            |
      | firstName | *            |
      | lastName  | \|           |
      | lastName  | 0            |
      | lastName  | 1            |
      | lastName  | 2            |
      | lastName  | 3            |
      | lastName  | 4            |
      | lastName  | 5            |
      | lastName  | 6            |
      | lastName  | 7            |
      | lastName  | 8            |
      | lastName  | 9            |
      | lastName  | +            |
      | lastName  | ;            |
      | lastName  | :            |
      | lastName  | \            |
      | lastName  | "            |
      | lastName  | !            |
      | lastName  | ?            |
      | lastName  | <            |
      | lastName  | >            |
      | lastName  | (            |
      | lastName  | )            |
      | lastName  | .            |
      | lastName  | ,            |
      | lastName  | /            |
      | lastName  | @            |
      | lastName  | #            |
      | lastName  | $            |
      | lastName  | £            |
      | lastName  | %            |
      | lastName  | ^            |
      | lastName  | &            |
      | lastName  | *            |

  Scenario Outline: Length of the field is less than minimum allowed or more than maximum allowed
    Given a valid request to create a customer profile
    But the "<field>" length is "<length>"
    When I request creation of a customer profile
    Then I will get a customer creation error for field length "<field>"
    Examples:
      | field        | length |
      | firstName    | 1      |
      | firstName    | 31     |
      | lastName     | 1      |
      | lastName     | 51     |
      | phoneNumber  | 5      |
      | phoneNumber  | 19     |
      | addressLine1 | 3      |
      | addressLine1 | 51     |
      | addressLine2 | 3      |
      | addressLine2 | 51     |
      | city         | 3      |
      | city         | 51     |
      | postalCode   | 1      |
      | postalCode   | 16     |

  Scenario Outline: Email address format
    Given a valid request to create a customer profile
    But the email field is in an invalid format "<invalidEmailFormat>"
    When I request creation of a customer profile
    Then an Invalid Email Format validation error is returned
    Examples:
      | invalidEmailFormat |
      | bob19@.com         |
      | ted77ww.com        |
      | aa                 |
      | t72has@fghj        |

  @manual
  Scenario Outline: Validate Passenger Age and passenger type
    Given a valid request to create a customer profile for "<passengerType>"
    But the "<passengerType>" age is not valid
    When I request creation of a customer profile
    Then an age validation error is returned
    Examples:
      | passengerType |
      | Adult         |
      | Child         |
      | Infant        |
