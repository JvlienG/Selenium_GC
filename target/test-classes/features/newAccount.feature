@Create
  Feature: As frequent user I want to create an account

    Scenario: create a new account with valid credits
      Given user is on the login page
      When user fill fields
      Then he should be on page for account activation