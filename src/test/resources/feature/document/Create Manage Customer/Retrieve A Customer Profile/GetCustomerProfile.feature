@sprint:Sprint_16
@issue:FCPH-342
@issue:FCPH-341

Feature: Retrieve a customer's profile

  #20-Dec Failing due to db changes that are to be pushed to sys test soon
  Scenario: Profile exists and is returned
    Given a customer profile exists
    When I search for the profile
    Then a profile is returned

  Scenario: Profile does not exist
    Given a customer profile does not exist
    When I search for the profile
    Then a profile error is returned