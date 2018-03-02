@Release:rel0.2
@Sprint:sprint_18
@issue:FCPH-380
@issue:FCPH-308
@issue:FCPH-2676
@P1
@TBR

Feature: Retrieve and Return Available Direct Flights with Deal found


  @wip
  Scenario: Deal found has at least one bundle with a discount tier associated
    Given I have a flight with the Active Deal
    When I call the find flights service for a valid flight
    Then I should see discounts for each passenger
    And I should see total discounts
    And I should see total passenger fare includes baseprice, discounts

#    Examples:
#      | channel   | X-Corporate-Id                  | X-Office-Id                | X-Application-Id | dealValue | POSTierValue | fareTypeCode    |
#      | ADAirport | 012811                          | Barclays                   | BILLTA           | 10 GBP    | 20           | STANDARD        |
#      | ADAirport | 012811                          | Barclays                   | BILLTA           | 10 GBP    | 0            | STANDARD, FLEXI |
#      | ADAirport | 012811                          | Barclays                   | BILLTA           | 10%       | 20           | STANDARD        |
#      | ADAirport | 012811                          | Barclays                   | BILLTA           | 10%       | 0            | STANDARD, FLEXI |
#      | ADAirport | 012811                          | Barclays                   | BILLTA           | 10 GBP    | 20           | FLEXI           |
#      | ADAirport | 012811                          | Barclays                   | BILLTA           | 10%       | 0            | FLEXI           |
#      | ADAirport | 1234(does not exists in system) | Barclays                   | BILLTA           | 10%       | 20           | FLEXI           |
#      | ADAirport | 1234(does not exists in system) | Barclays1(does not exists) | BILLTA           | 10%       | 0            | FLEXI           |
#      | ADAirport | BLANK                           | BLANK                      | BILLTA           | 10%       | 25           | FLEXI           |
#      | ADAirport | BLANK                           | Barclays                   | BILLTA           | 10 GBP    | 35           | STANDARD        |
#      | ADAirport | BLANK                           | Barclays                   | BILLTA           | 10%       | 45           | FLEXI           |
#      | ADAirport | 012811                          | Barclays                   | BILLTA           | 0         | 25           | STANDARD        |
#      | ADAirport | 012811                          | Barclays                   | BILLTA           | 0         | 0            | FLEXI           |
#      | ADAirport | BLANK                           | Barclays                   | BILLTA           | 0         | 0            | STANDARD        |
#      | ADAirport | BLANK                           | Barclays                   | BILLTA           | 0         | 25           | FLEXI           |


#    Dont setup  below data in Backoffice
  @wip
  Scenario: No Deal returned from Deal Search
    Given I have a flight with out Active Deal
    When I call the find flights service for a valid flight
    Then I should not see discounts for each passenger
    And I should not see total discounts
    And I should not see total passenger fare includes baseprice, discounts

  @wip
  Scenario: Example returns additional information if one of the header is missing.
    Given I have a flight with out Active Deal
    When I call the find flights service with missing one of the valid deals headers
    Then I should see "Please enter either System and Office OR System, Office and Corporate ID"

#    Examples:
#      | channel           | X-Corporate-Id | X-Office-Id | X-Application-Id | ErrorMessage                                                             |
#      | PublicApiB2B      |                |             |                  | Please enter either System and Office OR System, Office and Corporate ID |
#      | ADAirport         |                |             | BILLTA           | Please enter either System and Office OR System, Office and Corporate ID |
#      | ADAirport         |                | Barclays    | BILLTA           | Please enter either System and Office OR System, Office and Corporate ID |
#      | ADAirport         | 012811         | Barclays    | BILLTA           | Please enter either System and Office OR System, Office and Corporate ID |
#      | ADAirport         | 012811         |             | BILLTA           | Please enter either System and Office OR System, Office and Corporate ID |
#      | ADCustomerService |                |             | BILLTA           | Please enter either System and Office OR System, Office and Corporate ID |
#      | ADCustomerService |                | Barclays    | BILLTA           | Please enter either System and Office OR System, Office and Corporate ID |
#      | ADCustomerService | 012811         | Barclays    | BILLTA           | Please enter either System and Office OR System, Office and Corporate ID |
#      | ADCustomerService | 012811         |             | BILLTA           | Please enter either System and Office OR System, Office and Corporate ID |
#      | Digital           |                |             | BILLTA           | Please enter either System and Office OR System, Office and Corporate ID |
#      | Digital           |                | Barclays    | BILLTA           | Please enter either System and Office OR System, Office and Corporate ID |
#      | Digital           | 012811         | Barclays    | BILLTA           | Please enter either System and Office OR System, Office and Corporate ID |
#      | Digital           | 012811         |             | BILLTA           | Please enter either System and Office OR System, Office and Corporate ID |
#      | PublicApiB2B      |                |             | BILLTA           | Please enter either System and Office OR System, Office and Corporate ID |
#      | PublicApiB2B      |                | Barclays    | BILLTA           | Please enter either System and Office OR System, Office and Corporate ID |
#      | PublicApiB2B      | 012811         | Barclays    | BILLTA           | Please enter either System and Office OR System, Office and Corporate ID |
#      | PublicApiB2B      | 012811         |             | BILLTA           | Please enter either System and Office OR System, Office and Corporate ID |

  @wip
  Scenario: Example returns additional information if No Active deal for Office is entered.
    Given I have a flight with out Active Deal for Application id
    And No active deal for combination of Application, Office id
    When I call the find flights service
    Then I should see "No active deal for Office entered. Deal for Partner returned"

  @wip
  Scenario: Example returns additional information if No active deal for partner and Office entered
    Given I have a flight with out Active Deal for Application id, Office id
    And No active deal for Application id
    When I call the find flights service
    Then I should see "No active deal for Partner and Office entered"

  @wip
  Scenario: Example returns additional information if No active deal for partner and Office entered
    Given I have a flight with out Active Deal for Office id
    And No Active Deal exists for combination of System, Office, Corporate Id
    When I call the find flights service
    Then I should see "No active deal for Partner and Office entered"

  @wip
  Scenario: Example returns additional information if No active deal for partner and Office entered
    Given I have a flight with out Active Deal for Application id
    And No Active Deal exists for combination of  Office, Corporate Id
    When I call the find flights service
    Then I should see "No active deal for Partner and Office entered"

  @wip
  Scenario: Example returns additional information if No active deal for partner and Office entered
    Given I have a flight with out Application id
    And I have a flight with out Office id
    And No Active Deal exists for combination of  Office, Corporate Id, Application id
    When I call the find flights service
    Then I should see "No active deal for Partner and Office entered"
