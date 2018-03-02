@sprint:Sprint_17
@issue:FCPH-270
@issue:FCPH-271

Feature: Update Basket Pricing for Age validation

  Background:
    Given I have set values for Adult, Child and Infant


  @defect @ignore
  @FCPH-6515
  @FCPH-7102
  Scenario Outline: Age validation with same base price
    Given my basket contains "<passengerMix>" added via "<channel>"
    And all base prices are the same
    When I change the passenger age of "<original>" to "<new>" via "<channel>"
    Then the basket is updated and fees calculated
    Examples:
      | passengerMix          | original | new   | channel   |
      | 1 Adult, 1 Infant OOS | Infant   | Adult | ADAirport |
      | 1 Adult, 1 Child      | Child    | Adult | ADAirport |
      | 1 Adult, 1 Child      | Adult    | Child | ADAirport |
      | 1 Adult, 1 Infant OOS | Infant   | Child | ADAirport |
      | 1 Adult, 1 Child      | Child    | Adult | Digital   |
      | 1 Adult, 1 Child      | Adult    | Child | Digital   |
      | 1 Adult, 1 Infant OOS | Infant   | Adult | Digital   |
      | 1 Adult, 1 Infant OOS | Infant   | Child | Digital   |

  @manual
  @defect @ignore
  @FCPH-6515
  Scenario Outline: Age validation for Agent Desktop when base prices differ
    Given my basket contains "<passengerMix>"
    And all base prices are different
    When I change the passenger age of "<original>" to "<new>" via "<channel>"
    Then the basket is updated and fees calculated
    And a price change event is raised
    Examples:
      | passengerMix          | original | new   | channel   |
      | 1 Adult, 1 Child      | Child    | Adult | ADAirport |
      | 1 Adult, 1 Child      | Adult    | Child | ADAirport |
      | 1 Adult, 1 Infant OOS | Infant   | Adult | ADAirport |
      | 1 Adult, 1 Infant OOS | Infant   | Child | ADAirport |
      | 1 Adult, 1 Child      | Child    | Adult | Digital   |
      | 1 Adult, 1 Child      | Adult    | Child | Digital   |
      | 1 Adult, 1 Infant OOS | Infant   | Adult | Digital   |
      | 1 Adult, 1 Infant OOS | Infant   | Child | Digital   |


  @defect @ignore
  @FCPH-6515
  @FCPH-7006
  Scenario Outline: Age validation for changing age to infant age bracket from other when base price is the same
    Given my basket contains "<passengerMix>"
    And all base prices are the same
    When I change the passenger age of "<original>" to "<new>" via "<channel>"
    Then the basket is updated and fees calculated
    And the infant is now on lap of the first adult
    Examples:
      | passengerMix     | original | new    | channel   |
      | 1 Adult, 1 Child | Child    | Infant | ADAirport |
      | 2 Adults         | Adult    | Infant | ADAirport |
      | 1 Adult, 1 Child | Child    | Infant | Digital   |
      | 2 Adults         | Adult    | Infant | Digital   |

  @defect @ignore
  @FCPH-6515
  @FCPH-7006
  Scenario Outline: Age validation for changing age to infant age bracket from other when base price is different
    Given my basket contains "<passengerMix>"
    And all base prices are different
    When I change the passenger age of "<original>" to "<new>" via "<channel>"
    Then the basket is updated and fees calculated
    And the infant is now on lap of the first adult
    Examples:
      | passengerMix     | original | new    | channel   |
      | 1 Adult, 1 Child | Child    | Infant | ADAirport |
      | 2 Adults         | Adult    | Infant | ADAirport |
      | 1 Adult, 1 Child | Child    | Infant | Digital   |
      | 2 Adults         | Adult    | Infant | Digital   |


  @defect @ignore
  @FCPH-7006
  Scenario: Converting passenger to infant when first adult already has one infant on lap
    Given my basket contains "2 Adults, 1 Child, 1 Infant OL"
    When I change the passenger age of "Child" to "Infant"
    Then the Child seat is removed
    And the infant is assigned to the second adult on their lap

  @defect @ignore
  @FCPH-6997
  Scenario: Converting passenger to infant when all adults already have infant on lap
    Given my basket contains "2 Adults, 1 Child, 2 Infants OL"
    When I change the passenger age of "Child" to "Infant"
    Then the basket is marked as invalid


  @defect @ignore
  @FCPH-6515
  @FCPH-7006
  Scenario Outline: Changing from infant to adult or child recalculates basket where base fare is the same
    Given my basket contains "<passengerMix>"
    And all base prices are the same
    When I change the passenger age of "<original>" to "<new>" via "<channel>"
    Then the basket is updated and fees calculated
    And the "<new>" is now in their own seat
    Examples:
      | passengerMix          | original | new   | channel   |
      | 1 Adult, 1 Infant OL  | Infant   | Adult | ADAirport |
      | 2 Adults, 1 Infant OL | Infant   | Child | ADAirport |
      | 1 Adult, 1 Infant OL  | Infant   | Adult | Digital   |
      | 2 Adults, 1 Infant OL | Infant   | Child | Digital   |

  @manual
  @defect @ignore
  @FCPH-6515
  @FCPH-7006
  Scenario Outline: Changing from infant to adult or child recalculates basket where base fare is different
    Given my basket contains "<passengerMix>"
    And all base prices are different
    When I change the passenger age of "<original>" to "<new>" via "<channel>"
    Then the basket is updated and fees calculated
    And a price change event is raised
    And the "<new>" is now in their own seat
    Examples:
      | passengerMix          | original | new   | channel   |
      | 1 Adult, 1 Infant OL  | Infant   | Adult | ADAirport |
      | 2 Adults, 1 Infant OL | Infant   | Child | ADAirport |
      | 1 Adult, 1 Infant OL  | Infant   | Adult | Digital   |
      | 2 Adults, 1 Infant OL | Infant   | Child | Digital   |