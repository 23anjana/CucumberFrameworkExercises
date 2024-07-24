Feature: Validate login functionality

  Scenario: Verify user can login into the website
    Given user opens the website
    When user clicks on signUp button
    Then verify user is on signup page
    And user fills the first section of signUp page
    When user clicks on next
    And user fills out the rest of section in signUp page
    When user clicks on Register
    Then verify registration is successful


