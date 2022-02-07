@search
Feature: As a glisshop user I want to search products
  Scenario Outline: Perform a product search
    Given user is on the search bar
    When  user look for the product <product>
    Then  the products are displayed to him
    Examples:
      | product  |
      | ski |
