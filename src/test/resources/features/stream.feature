Feature: Stream Functionality

  Scenario: Add a Comment Validation
    Given the user is on the login page
    When the user enters valid credentials
    And I navigate to Stream Page
    Then I validate a comment is correctly added