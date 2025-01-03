Feature: Planetarium User Login
  Scenario Outline: valid User Login
    Given the user is on the login page.
    When the user provides the username "<username>".
    And the user provides the password "<password>".
    And the user submits their credentials.
    Then the user should be redirected to "<page>" page.


    Examples:
    |username|password|page|
  |Batman|Iamthenight1939|Home|



  Scenario Outline: Invalid User Login
    Given the user is on the login page.
    When the user provides the username "<username>".
    And the user provides the password "<password>".
    And the user submits their credentials.
    Then the user should expect "<result>" alert.
    And the user should be redirected to "<page>" page.


    Examples:
      |username|password|result|page|
      |Batman|b0Ts|Invalid Credentials|login|
      |Robin|Iamthenight1939|Invalid Credentials|login|
      |Robin|b0Ts|Invalid Credentials|login|


  Scenario: Valid User log out
      Given the user is in the logged in
      And in the home page
      When the User chooses to log out
      Then the User should be logged out
      And the user should be redirected to the log in page



