Feature: User Moon Creation

  Scenario Outline: Successful Moon Creation
    Given the user is logged in
    When the user selects Moon creation
    And the user inputs valid Moon name <moon_name>
    And the user inputs valid planet_id <planet_id>
    Then the table should expect <outcome>

    Examples:
      |moon_name|planet_id|outcome|
      |1aA _-|1|Moon created Successfully|
      |1aA _-|1|Moon created Successfully|
      |1aA _-|1|invalid file type|
      |Abcdefghi1234567890123456789_-|1|invalid moon name Alert|
      |1aA _-@|1|invalid moon name|
      |1aA _-|1|invalid moon name|
      |1aA _-|55|invalid planet id|


