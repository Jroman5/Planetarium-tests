Feature: Planetarium Home Page

  Scenario: Unauthorized User Access to Home Page
    Given the user is not logged in
    When the user tries to access the home page directly
    Then the user should be denied access

  Scenario: Authorized User access to Home Page
    Given the user is on the login page
    When the user logs in
    Then the user should see their planets
    And the user should see their moons
    And the user should see a greeting on the home page



