Feature: User Planet Creation
  Scenario Outline: Successful Planet Creation
    Given the user is logged in
    When the user selects planet creation
    And the user inputs planet name <planet_name>
    And the user inputs fileType <file_type>
    Then the user should expect <outcome>

    Examples:
    |planet_name|file_type|outcome|
    |1aA _-|.jpeg|Planet created Successfully|
    |1aA _-|.png|Planet created Successfully|
    |1aA _-|.txt|invalid file type|
    |Abcdefghi1234567890123456789_-|.jpeg|Invalid planet name Alert|
    |1aA _-@|.png|Invalid planet name Alert|
    |1aA _-|.png|Invalid planet name Alert|



