Feature: feature to test google search functionality

  Scenario: Validate amazon addto cart is working
    Given browser is open
    Then navigate to amazon website
    And search iphone in searchbox
    And hits enter
    Then select first product in the list
    And Open product detail page in another page
    And click on add  to cart button
    Then product is added to cart
