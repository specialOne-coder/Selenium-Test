@logout
Feature: As a glisshop user I want to logout
  Scenario Outline: Logout of glisshop
    Given user is logged in <email> <pwd>
    When  user is logout
    Then  he should be at the home page
    Examples:
      |email | pwd |
      | mawu@gmail.com |Ferd@8918 |