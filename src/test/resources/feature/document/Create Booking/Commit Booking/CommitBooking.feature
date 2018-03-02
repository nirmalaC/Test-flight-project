@Sprint:sprint_17

Feature: Return the booking reference after creating a booking

  @issue:FCPH-407
  @issue:FCPH-314
  @issue:FCPH-293
  Scenario Outline: Booking reference is returned after commit booking
    Given I have committed a booking via "<channel>"
    Then a booking reference is returned
    Examples:
      | channel           |
      | ADAirport         |
      | ADCustomerService |
      | Digital           |
      #| PublicApiMobile   |
      #| PublicApiB2B      |

  @issue:FCPH-466
  Scenario Outline: Inventory is not allocated again without passenger mix during the commit booking process for Agent chanel
    Given I have a basket with a valid flight for "<channel>"
    And the seats are allocated
    When I do the commit booking
    Then Inventory is not allocated again
    Examples:
      | channel           |
      | ADAirport         |
      | ADCustomerService |

  @manual
  @issue:FCPH-466
  Scenario Outline: The inventory is not allocated again with passengermix for agent channel
    Given I have "<outboundflight>","<inboundflight>" flights with passenger mix for "<channel>"
    When I do the commit booking
    Then the inventory is not allocated again
    Examples:
      | channel           | outboundflight                               | inboundflight                                |
      | ADAirport         | 1 Adult, 1 Child, 1 Infant OL                | 1 Adult, 1 Child, 1 Infant OL                |
      | ADCustomerService | 2 Adults, 1 Child, 1 Infant OL, 1 Infant OOS | 2 Adults, 1 Child, 1 Infant OL, 1 Infant OOS |

  @issue:FCPH-466
  @issue:FCPH-467
  Scenario Outline: Order is created with the flight details during the commit booking process
    Given I have a basket with a valid flight for "<channel>"
    When I do the commit booking
    Then Order is created from Cart
    Examples:
      | channel           |
      | ADAirport         |
      | ADCustomerService |
      | Digital           |
      #| PublicApiMobile   |
      #| PublicApiB2B      |

  @issue:FCPH-466
  Scenario Outline: Passenger details are created during the commit booking process
    Given I have a basket with a valid flight for "<channel>"
    When I do the commit booking
    Then Passenger details are created with status as Booked
    Examples:
      | channel           |
      | ADAirport         |
      | ADCustomerService |
      | Digital           |
      #| PublicApiMobile   |
      #| PublicApiB2B      |

  @issue:FCPH-466
  Scenario Outline: Customer profile is linked during the commit booking process
    Given I have a basket with a valid flight for "<channel>"
    When I do the commit booking
    Then Customer profile is linked with the booking

    Examples:
      | channel           |
      | ADAirport         |
      | ADCustomerService |
      | Digital           |
      #| PublicApiMobile   |
      #| PublicApiB2B      |


  @manual
  @issue:FCPH-466
  Scenario Outline: Payment transaction are recorded during the commit booking process
    Given I have a basket with a valid flight for "<channel>"
    When I do the commit booking
    Then Payment transaction are recorded in the booking
    Examples:
      | channel           |
      | ADAirport         |
      | ADCustomerService |
      | Digital           |
      | PublicApiMobile   |
      | PublicApiB2B      |

  @issue:FCPH-466
  Scenario Outline: Date time is created during the commit booking process
    Given I have a basket with a valid flight for "<channel>"
    When I do the commit booking
    Then Created date time is stored

    Examples:
      | channel           |
      | ADAirport         |
      | ADCustomerService |
      | Digital           |
      #| PublicApiMobile   |
      #| PublicApiB2B      |

  @manual
  @issue:FCPH-466
  Scenario Outline: History of booking is created during the commit booking process
    Given I have a basket with a valid flight for "<channel>"
    When I do the commit booking
    Then Booking history is created

    Examples:
      | channel           |
      | ADAirport         |
      | ADCustomerService |
      | Digital           |
      #| PublicApiMobile   |
      #| PublicApiB2B      |