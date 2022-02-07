@remove
Feature: As a glisshop user I want to remove my product from cart
  Scenario Outline: Remove product from cart
    Given user is at cart <product>
    When  user remove product
    Then  the product is removed from the cart
    Examples:
      | product |
      | gant    |
