Feature: User Moon Creation

  Scenario Outline: Moon Creation success
    Given the user is logged in
    When the user selects Moon creation
    And the user inputs Moon name "<moon_name>"
    And the user inputs planet_id <planet_id>
    And the user provides a file "<file>"
    And the user submits the moon information
    Then the table should expect the page to reflect the changes

    Examples:
      |moon_name|planet_id|file|
      |1aA _-|1|C:\Programming\projects\planetarium\Planetarium & Setup\db-setup\src\test\resources\TestImages\ValidmoonJpeg.jpg|
      |1aA _-|1|C:\Programming\projects\planetarium\Planetarium & Setup\db-setup\src\test\resources\TestImages\ValidMoonPng.png|


  Scenario Outline: Moon Creation failure
    Given the user is logged in
    When the user selects Moon creation
    And the user inputs Moon name "<moon_name>"
    And the user inputs planet_id <planet_id>
    And the user provides a file "<file>"
    And the user submits the moon information
    Then the table should expect message "<outcome>"

    Examples:
      |moon_name|planet_id|file|outcome|
      |Luna|1|C:\Programming\projects\planetarium\Planetarium & Setup\db-setup\src\test\resources\TestImages\ValidmoonJpeg.jpg|Invalid moon name|
      |1aA _-|1|C:\Programming\projects\planetarium\Planetarium & Setup\db-setup\src\test\resources\TestImages\InvalidImage.txt|invalid file type|
      |Abcdefghi12345678901234567890_-|1|C:\Programming\projects\planetarium\Planetarium & Setup\db-setup\src\test\resources\TestImages\ValidmoonJpeg.jpg|Invalid moon name|
      |1aA _-@|1|C:\Programming\projects\planetarium\Planetarium & Setup\db-setup\src\test\resources\TestImages\ValidmoonJpeg.jpg|Invalid moon name|
      |Luna|1|C:\Programming\projects\planetarium\Planetarium & Setup\db-setup\src\test\resources\TestImages\ValidmoonJpeg.jpg|Invalid moon name|
      |1aA _-|55|C:\Programming\projects\planetarium\Planetarium & Setup\db-setup\src\test\resources\TestImages\ValidmoonJpeg.jpg|Invalid planet ID|


