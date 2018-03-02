@TBA
@Sprint:sprint_18
@Sprint:sprint_19
@issue:FCPH-207
@issue:FCPH-3677

Feature: Save and retrive a search to a profile

# Note1: Definition of a unique search : Having the same departure airport, arrival airport and passenger mix.
# Note2: configured for maximum saves allowed for a profile.
# Note3: We never modifies an existing search.

  Background:
    Given customer is logged in

  Scenario: Validate successful save to a profile
    When I made a new search for flights
    Then search should be saved

  Scenario: Verify multiple saves to a profile
    And customer has "one search" saved to the profile
    When I made a new search for flights
    Then search should be saved

  Scenario: Duplicate search shouldn't be saved twice
    Given customer has "one search" saved to the profile
    When I made a duplicate search
    Then search should not be saved

  Scenario: Validate latest search over writes the oldest search
    Given customer has "maximum searches" saved to the profile
    When I made a new search for flights
    Then I should see latest search over writes the oldest one

  Scenario: Verify the search saved if the request is through a different session
    Given I made a new search for flights
    When I made a new search for flights from a different session
    Then I should see two search should be saved

  Scenario: Verify no search results retrived
    Given customer has "no search" saved to the profile
    When I retrieve the recent searches
    Then I should see no search results

  Scenario: Past date results can't be retrived
    Given customer has "one search" saved to the profile with the past date
    When I retrieve the recent searches
    Then I should see no search results