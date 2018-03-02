@Release:rel0.1
@Sprint:sprint_16
@issue:FCPH-265
@issue-FCPH-266
@issue:FCPH-360
@issue:FCPH-359
@issue:FCPH-171
@issue:FCPH-172
Feature: Basic Passenger Details are returned - passenger titles

  Scenario: Basic request for all titles
    Given there are active passenger titles available
    When I request passenger title reference data
    Then all applicable passenger titles are returned

  Scenario: All passenger titles returned have applicable localisation
    Given there are active passenger titles available with localisations
    When I request passenger title reference data
    Then all localisation data is present

  Scenario: Changing the language returns only the specified localisation language
    Given there are active passenger titles available with localisations
    When I request passenger title reference data for a language
    Then only language specific reference data is returned