@add
Feature: As a glisshop user I want to add my products to cart
  Scenario Outline: Add product to cart
    Given user is search product
    When  user add product to cart <product>
    Then  the product is added to cart
    Examples:
      | product  |
      |gant|