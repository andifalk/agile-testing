Feature: Calculate Amazon shipping costs
  
  As a customer I want to calculate the shipping costs for 
  my products in the shopping cart in order to get the cheapest possible total price.

  Scenario Outline: Calculate shipping costs for prime customers
    Given I am a Prime customer
    When I have an article of <Category1> with <Price1> in my shopping cart
    And I have an article of <Category2> with <Price2> in my shopping cart
    And I selected shipping method <ShippingMethod>
    Then my calculated shipping costs should be <ShippingCosts>

    Examples: 
      | Category1 | Price1     | Category2   | Price2      | ShippingMethod  | ShippingCosts |
      | Books     | 5.00 Euro  | Music       | 5.00 Euro   | PREMIUM         | 0.00 Euro     |
      | Films     | 20.00 Euro | Electronics | 180.00 Euro | MORNING_EXPRESS | 10.00 Euro    |
      | Music     | 10.00 Euro | Films       | 10.00 Euro  | PREMIUM         | 0.00 Euro     |

  Scenario Outline: Calculate shipping costs for standard customers
    Given I am a Standard customer
    When I have an article of <Category1> with <Price1> in my shopping cart
    And I have an article of <Category2> with <Price2> in my shopping cart
    And I selected shipping method <ShippingMethod>
    Then my calculated shipping costs should be <ShippingCosts>

    Examples: 
      | Category1 | Price1     | Category2   | Price2      | ShippingMethod  | ShippingCosts  |
      | Books     | 5.00 Euro  | Music       | 7.00 Euro   | STANDARD        | 0.00 Euro  |
      | Books     | 20.00 Euro | Electronics | 100.00 Euro | MORNING_EXPRESS | 13.00 Euro |
      | Music     | 10.00 Euro | Films       | 18.99 Euro  | STANDARD        | 3.00 Euro  |
      | Music     | 10.00 Euro | Films       | 19.00 Euro  | STANDARD        | 0.00 Euro  |
      | Music     | 10.00 Euro | Films       | 19.00 Euro  | PREMIUM         | 6.00 Euro  |
      | Books     | 10.00 Euro | Music       | 18.99 Euro  | PREMIUM         | 6.00 Euro  |
   
   Scenario: Calculate shipping costs for prime customers using standard shipping method
	Given I am a Prime customer
    When I have articles of any category in my shopping cart
    And I selected shipping method STANDARD
    Then I should get an error with message "Premium customers cannot select standard shipping method"
