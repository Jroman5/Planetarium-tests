Feature: Planetarium User Registration Positive and negative paths
  Scenario Outline: User Registration

    Given the new user is on the login page
    When the user clicks the register link
    When the user provides a username "<username>"
    And the user provides a password "<password>"
    And the user submits the credentials
    Then the user should get a browser alert "<response>"
    And should be redirected to the login page.

    Examples:
    |username|password|response|
  |Super_man-2001|Krypton-was_2000|Account created successfully|
  |Batman|Krypton-was_2000|Invalid username provided|
  |Bane|Krypton-was_2000|Invalid username provided|
  |wonder_woman_for_the_DC_theming|	Krypton-was_2000|Invalid username provided |
  |2face|Krypton-was_2000|Invalid username provided|
  |joker!!!!!!?)|Krypton-was_2000|Invalid username provided|
  |Super_man-2001|b0Ts|Invalid password provided|
  |Super_man-2001|AlfredIsTheBestButlerToExist111|Invalid password provided|
  |Super_man-2001|3atman|Invalid password provided|
  |Super_man-2001|A1fredIsTheBestButlerToExist!!|Invalid password provided|
  |Super_man-2001|batman1|Invalid password provided|
  |Super_man-2001|BATMAN1|Invalid password provided|
  |Super_man-2001|Robin|Invalid password provided|

    Scenario: Returning to login page
      Given the user is on the registration page
      When the user clicks on the login link
      Then the user should be redirected to login page.


