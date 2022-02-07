@signUp
Feature: As a glisshop user I want to create account so that I could access the site
  Scenario Outline: Perform signup with valid credentials
    Given user is at the signup page
    When  user is registered with <email> <pwd> <cpwd>
    Then  he has a message confirming his account creation
    Examples:
      |email  |pwd | cpwd |
      | gnanklm@gmail.com |Ferd@8918 | Ferd@8918 |
