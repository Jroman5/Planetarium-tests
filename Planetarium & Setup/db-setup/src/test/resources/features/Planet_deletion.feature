Feature: User Planet Deletion
  Scenario: Valid Planet Name Planet Deletion
    Given the User is logged in
    When the user chooses to delete a Moon
    And inputs a valid name
    Then the table should refresh and reflect the changes

  Scenario: Invalid Planet Name Planet Deletion
    Given the user is logged in
    When the user chooses to delete a moon
    And inputs an invalid name
    Then the browser should show an alert message for an invalid name
    And should return to the home page

