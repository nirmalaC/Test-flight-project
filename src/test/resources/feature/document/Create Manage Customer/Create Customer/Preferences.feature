@sprint:Sprint_18
@issue:FCPH-2752
@TBA

Feature: Service returns available customer preferences

  Scenario: Request returns all applicable customer preference fields
    Given there are available customer preference fields
    When the request for preferences is called
    Then an empty preferences available is returned