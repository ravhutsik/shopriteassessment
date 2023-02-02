@SearchShopriteProducts

Feature: Search Product

  Scenario: As a user i want to be able to search a product by name
    Given i have launched the TakeALot website and page title
    When i enter the name of the product and click the search icon button.
    And i Click on the searched product to verify the product price and description
    Then i validate verify that product information is displayed
