Feature: The user should be able to place order from website
  @wip
  Scenario: Placing a successful order
    Given The user navigates to web site
    When The user cliks on login button and enters "salih" and "qayxsw159753" credentials
    And The user adds "Samsung galaxy s7" product from "Phones" category
    And The user adds "Sony vaio i5" product from "Laptops" category
    And The user adds "MacBook Pro" product from "Laptops" category
    And The user adds "Apple monitor 24" product from "Monitors" category
    And The user removes "Sony vaio i5" chosen product from Cart Page
    And The user places order and captures and log amount
    Then The user verifies purchase amount
