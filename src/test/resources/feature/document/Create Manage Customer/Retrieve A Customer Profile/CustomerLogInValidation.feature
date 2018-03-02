@sprint:Sprint_17
@issue:FCPH-205

Feature: Receive request to Log in to member account

  Scenario: Verify successful login
    Given a customer account exists with a known password
    When I login with valid credentials
    Then I should be successfully logged in

  Scenario: Only Digital channel is allowed to login
    Given a customer account exists with a known password
    When I login with valid credentials using the "ADAirport" channel
    Then I am informed that only Digital can access this channel

  Scenario: Verify login fail with invalid credentials
    Given a customer account exists with a known password
    When I login with invalid credentials
    Then I should not be logged in

  Scenario: Verify login fail with invalid email credentials
    Given a customer account exists with a known password
    When I provide a different email address
    Then I should not be logged in

  @manual
  Scenario: Verify time stores upon successful login
    Given a customer account exists with a known password
    When I login with valid credentials
    Then I should see time recorded


  Scenario: Verify account lock after maximum number of failed attempts in a single session
    Given a customer account exists with a known password
    And configuration is in place for maximum number of failed attempts to get lock
    When I breach the maximum login attempts in a single session
    Then the account is locked
    #This account has been disabled for security reasons is returned to the channel

  Scenario: Verify account lock after maximum number of failed attempts over multiple sessions
    Given a customer account exists with a known password
    And configuration is in place for maximum number of failed attempts to get lock
    When I breach the maximum login attempts over multiple sessions
    Then the account is locked
    #This account has been disabled for security reasons is returned to the channel

  @manual
  Scenario Outline: Verify account time recorded after maximum number of failed attempts
    Given a customer account exists with a known password
    And configuration is in place for maximum number of failed attempts to get lock
    When it reaches to maximum failed attempts limit from "<session>"
    Then I should see account lock time recorded
    Examples:
      | session           |
      | single_session    |
      | multiple_sessions |

  Scenario: Verify unable to login to a disabled account
    Given a customer account exists with a known password
    And the account has been disabled
    When I login with valid credentials
    Then I am informed that the account is disabled

  @manual
  Scenario: Verify staff member login
    Given a staff account exists with a known password
    When I login with staff credentials
    Then I should successfully logged in

  @manual
  Scenario: Verify success login after accounts get unlocked
    Given a customer account exists with a known password is disabled
    When the account is re-enabled
    And I try to login with valid credentials
    Then I should successfully logged in
