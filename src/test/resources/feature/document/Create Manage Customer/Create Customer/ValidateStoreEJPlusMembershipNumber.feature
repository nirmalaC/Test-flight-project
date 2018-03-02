@issue:FCPH-XXXX
@TBA

Feature: Validate and store the EJ Plus number

  #this is a positive test?
  Scenario: easyJet plus membership passed in the request
    Given that an easyJet Plus membership has been passed in the request
    When I receive the request
    Then I will validate the easyJet plus membership

  Scenario: Number of characters passed for ej Plus validation
    Given that an easyJet Plus membership has been passed in the request
    But the number of characters passed is less than 8 characters
    When the request to create a customer is sent
    Then a warning about the length of the membership number is returned

  Scenario: Number of character for staff ej plus membership number BR_00420
    Given that a staff easyJet Plus membership has been passed in the request
    But the number of characters passed is less than 6 characters
    When the request to create a customer is sent
    Then a warning about the length of the staff membership number is returned

  Scenario: Number of character for staff ej plus membership number starts with S BR_00420
    Given that a staff easyJet Plus membership has been passed in the request
    But the easyJet Plus membership number starts with a character other than S
    When the request to create a customer is sent
    Then a warning about the format of the membership number is returned

  Scenario: Validate the expiry date of the ej plus membership BR_3000
    Given that an easyJet Plus membership has been passed in the request
    But the easyJet Plus membership date has expired
    When the request to create a customer is sent
    Then a warning about the expiry of the membership number is returned

  Scenario: Validate surname must match the membership surname BR_00410
    Given that an easyJet Plus membership has been passed in the request
    But the easyJet Plus surname does not match the registered surname
    When the request to create a customer is sent
    Then a warning about the surname of the membership number is returned

  Scenario: Store ej Plus membership number against the profile
    Given that an easyJet Plus membership has been passed in the request
    When the request to create a customer is sent
    Then the ej Plus membership number against the customer profile

  Scenario: Failed validation
    Given that an invalid easyJet Plus membership has been passed in the request
    When the request to create a customer is sent
    Then the customer will be created
    And warning messages are returned