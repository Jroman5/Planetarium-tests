Feature: User Planet Creation
  Scenario Outline: Successful Planet Creation
    Given the user is logged in the planetarium
    When the user selects planet creation
    And the user inputs planet name "<planetName>"
    And the user inputs fileType "<fileType>"
    And the user submits the planet data
    Then the homepage should reflect the change on the list

    Examples:
      |planetName|fileType|
      |1aA _-|C:\Programming\projects\planetarium\Planetarium & Setup\db-setup\src\test\resources\TestImages\ValidmoonJpeg.jpg|
      |1aA _-|C:\Programming\projects\planetarium\Planetarium & Setup\db-setup\src\test\resources\TestImages\ValidMoonPng.png|

  Scenario Outline: Unsuccessful Planet Creation
    Given the user is logged in the planetarium
    When the user selects planet creation
    And the user inputs planet name "<planetName>"
    And the user inputs fileType "<fileType>"
    And the user submits the planet data
    Then the user should expect and alert "<alert>"

    Examples:
      |planetName|fileType|alert|
      |1aA _-|C:\Programming\projects\planetarium\Planetarium & Setup\db-setup\src\test\resources\TestImages\InvalidImage.txt|invalid file type|
      |Abcdefghi12345678901234567890_-|C:\Programming\projects\planetarium\Planetarium & Setup\db-setup\src\test\resources\TestImages\validPlanetJPEG.jpg|Invalid planet name|
      |1aA _-@|C:\Programming\projects\planetarium\Planetarium & Setup\db-setup\src\test\resources\TestImages\ValidMoonPng.png|Invalid planet name|
      |1aA _-|C:\Programming\projects\planetarium\Planetarium & Setup\db-setup\src\test\resources\TestImages\validPlanetJPEG.jpg|Invalid planet name|



