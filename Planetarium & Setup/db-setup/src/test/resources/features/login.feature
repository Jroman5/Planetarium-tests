Feature: Planetarium User Login
  Scenario Outline: User Login
    Given the user is on the login page.
    When the user provides the username <username>.
    And the user provides the password <password>.
    And the user submits their credentials.
    Then the user should expect <result>.

    Examples:
    |username|password|result|
  |Batman|Iamthenight1939|login success|
  |Batman|b0Ts|Invalid Credentials alert|
  |Robin|Iamthenight1939|Invalid Credentials alert|
  |Robin|b0Ts|Invalid Credentials alert|


  Scenario: Valid User log out
      Given the user is in the logged in
      And in the home page
      When the User chooses to log out
      Then the User should be logged out
      And the user should be redirected to the log in page



