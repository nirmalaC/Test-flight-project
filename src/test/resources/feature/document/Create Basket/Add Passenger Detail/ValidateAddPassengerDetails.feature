@Release:rel0.1
@Sprint:sprint_16
@issue:FCPH-267
@issue:FCPH-268
@issue:FCPH-269

Feature: Validate Add Passenger Details Basic Request
  I want to be able to add traveller details in the basket
  So that I can see traveller information on the basket

  Scenario Outline: Verify that ACP responds with the correct error code and message when the request lack one of the mandatory fields
    Given my basket contains "1 Adult"
    When I fail to provide the traveller field "<field>"
    Then I should see the "<field>" error message
    Examples:
      | field         |
      | passengertype |
      | title         |
      | firstname     |
      | lastname      |
      | age           |

  @defect @ignore
  @FCPH-6856
  Scenario Outline: Verify that ACP respond with the correct error code and message when the request contains unmatching passenger type and title
    Given my basket contains "1 Adult"
    When I set the traveller type as "<type>" and the title as "<title>"
    Then I should see the "passenger type and title mismatch" error message
    Examples:
      | type   | title  |
      | adult  | Infant |
      | child  | Mrs    |
      | child  | Ms     |
      | child  | Infant |
      | infant | Mr     |
      | infant | Mrs    |
      | infant | Miss   |
      | infant | Ms     |


  #This is now invalid, as it will update the type to the age
  #Scenario Outline: Verify that ACP respond with the correct error code and message when the request contains unmatching passenger type and age
  #  Given I have set values for Adult, Child and Infant
  #  Given my basket contains "1 Adult"
  #  When I set the traveller type as "<type>" and the age as "<age>"
  #  Then I should see the "passenger age" error message
  #  Examples:
  #    | type   | age    |
  #    | Adult  | Child  |
  #    | Child  | Adult  |
  #    | Child  | Infant |
  #    | Infant | Child  |
  #    | Infant | Adult  |

  Scenario Outline: Verify that ACP respond with the correct error code and message when the request contains "first name" not in the right format
    Given my basket contains "1 Adult"
    When I update traveller details with "firstname" as "<firstname>"
    Then I should see the "firstname format" error message
    Examples:
      | firstname                                          |
      | x                                                  |
      | Pneumono Ultra Microscopic Silico Volcano Coniosis |
      | 123256                                             |
      | *^(&£                                              |

  Scenario Outline: Verify that ACP respond with the correct error code and message when the request contains "last name" not in the right format
    Given my basket contains "1 Adult"
    When I update traveller details with "lastname" as "<lastname>"
    Then I should see the "lastname format" error message
    Examples:
      | lastname                                                     |
      | a                                                            |
      | Pneumono Ultra Microscopic Silico Volcano Coniosis Last Name |
      | 97845                                                        |
      | @-+/=                                                        |

  Scenario Outline: Verify that ACP respond with the correct error code and message when the request contains e-mail address not in the right format
    Given my basket contains "1 Adult"
    When I update traveller details with "email" as "<email>"
    Then I should see the "email" error message
    Examples:
      | email         |
      | john.smith    |
      | john@         |
      | johnyahoo.com |
      | john@yahoo    |

  Scenario Outline: Verify that ACP respond with the correct error code and message when the request contains telephone number not in the right format
    Given my basket contains "1 Adult"
    When I update traveller details with "phoneNumber" as "<number>"
    Then I should see the "telephone format" error message
    Examples:
      | number              |
      | +440754123652854512 |
      | ghsjakgfjk          |
      | *^(&£ @-+/=         |

  #@pending
  #Scenario Outline: Verify that ACP validates the title when passenger type changes on the fly because of age
  #  Given I have set values for Adult, Child and Infant
  #  Given my basket contains "<passenger_mix>"
  #  When I set the traveller age as "<age>" and the title as "<title>"
  #  Then I should see the "passenger type and title mismatch" error message

  #  Examples:
  #    | passenger_mix | age   | title    |
  #    | 1 Adult       | child  | infant  |
  #    | 1 Adult       | infant  | adult  |
  #    | 1 child       | adult  | Infant |
  #    | 1 child       | Infant | Child  |