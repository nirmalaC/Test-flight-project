@Release:rel0.1
@Sprint:sprint_14
@issue:FCPH-171
@issue:FCPH-172
@issue:FCPH-323
Feature: Retrieve Country information

  Scenario: There are countries
    Given there are active countries in the database
    When I call the get countries service
    Then there are countries returned

  Scenario: All countries are returned
    Given there are active countries in the database
    When I call the get countries service
    Then all active countries are returned

  Scenario: Inactive countries are not returned
    Given there are inactive countries in the database
    When I call the get countries service
    Then the inactive countries are not returned

  @Manual
  Scenario: The correct countries are returned
    Given there are active countries in the database
    When I call the get countries service
#    Then associated locales are displayed with each country