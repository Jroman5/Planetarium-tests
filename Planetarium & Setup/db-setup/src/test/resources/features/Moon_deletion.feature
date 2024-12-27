Feature: User Moon Deletion
  Scenario: Valid Moon name Deletion
    Given the User is logged in
    And is on the moon page
    When inputs a valid name
    And the user clicks the delete button
    Then the table should refresh and reflect the changes

  Scenario: Invalid Moon Name Deletion
    Given the User is logged in
    And is on the moon page
    When inputs an invalid name
    And the user clicks the delete button
    Then the browser should show an alert message for an invalid name
    And should return to the home page

