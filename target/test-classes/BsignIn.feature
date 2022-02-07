@signIn
Feature: As a glisshop user I want to log in to my account
  Scenario Outline: Perform login with valid credentials
    Given user is at the login page
    When  user is logging-in with <email> <pwd>
    Then  he should be at the account page
    Examples:
      |email  |pwd |
      | gnanklm@gmail.com	 |Ferd@8918 |
