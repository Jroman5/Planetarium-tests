Feature: Planetarium User Registration Positive and negative paths

  Scenario Outline: User Registration
    Given the new user is on the login page
    When the user clicks the register link
    When the user provides a "<username>"
    And the user provides a "<password>"
    And the user submits valid credentials
    Then the user should get a browser alert saying "<response>"
    And should be redirected to the login page.

    Examples:
    |username|password|response|
  |Super_man-2001|Krypton-was_2000|Account create successfully alert|
  |Batman|Krypton-was_2000|Invalid username alert|
  |Bane|Krypton-was_2000|Invalid username alert|
  |wonder_woman_for_the_DC_theming|	Krypton-was_2000|Invalid username alert|
  |2face|Krypton-was_2000|Invalid username alert|
  |joker!!!!!!?)|Krypton-was_2000|Invalid username alert|
  |Super_man-2001|b0Ts|Invalid password alert|
  |Super_man-2001|AlfredIsTheBestButlerToExist111|Invalid password alert|
  |Super_man-2001|3atman|Invalid password alert|
  |Super_man-2001|A1fredIsTheBestButlerToExist!!|Invalid password alert|
  |Super_man-2001|batman1|Invalid password alert|
  |Super_man-2001|BATMAN1|Invalid password alert|
  |Super_man-2001|Robin|Invalid password alert|


