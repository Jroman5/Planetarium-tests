Feature: User Planet Deletion
  Scenario: Valid Planet Name Planet Deletion
    Given the user is logged in to the planetarium
    And is on the planet page
    When inputs an valid planet name
    And the user clicks the delete planet button
    Then the table should refresh and reflect the deleted planet

  Scenario: Invalid Planet Name Planet Deletion
    Given the user is logged in
    And is on the planet page
    When inputs an invalid planet name
    And the user clicks the delete planet button
    Then the browser should show an alert message for an invalid planet name
    And should return to the home page
