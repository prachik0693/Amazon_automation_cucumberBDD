@smokeFilterFeature
Feature: feature to validate product filter functionality

  @smokeFilterTest
  Scenario: Validate amazon product filter list
    Given browser is open for product filter
    Then navigate to amazon website to search a product
    And search phone in searchbox
    And hits enter key
    When click on delivery day checkbox
    Then filtered product list populated
