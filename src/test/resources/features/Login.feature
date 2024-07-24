Feature: Verify account functionality

  Background:
    Given user open the website
    Then verify user is on login page

  Scenario: Verify user can create checking account
    When user login using username "email" and password "password"
    Then verify user is on banking page
    When user click new checking from checking
    And create new checking account
    Then verify checking account is created


  Scenario: Verify user can create savings account
    When user login using username "email" and password "password"
    Then verify user is on banking page
    When user click new savings account from savings menu
    And create new savings account
    Then verify savings account is created
    And verify created account details

    Scenario: Verify user can transfer some amount
      When user login using username "email" and password "password"
      Then verify user is on banking page
      When user clicks on Transfer button
      Then verify user is on transaction page
      And user selects the appropriate transaction details
      When user clicks on submit button
      Then verify the successful transaction
