Feature: Cart

  Background:
    Given the web browser is on the http://skleptest.pl/ page

  Scenario: Adding a product to cart
    When user adds to cart a product
    And views the cart
    Then the product can be found in cart

    Scenario: Add to cart two products
      When user adds to cart a product
      And adds another one
      Then 2 products can be found in cart

    Scenario: Remove product from cart
      Given there's at least one product in cart
      When user views the cart
      And removes a product from cart
      Then product is no longer in cart

  Scenario Outline: Change product quantity
    Given there's at least one product in cart
    When user views the cart
    And performs "<change in quantity>"
    Then product quantity changes accurately
    Examples: changes
      | change in quantity |
      | +                  |
      | -                  |

    Scenario: Checkout
      Given there's at least one product in cart
      When user proceeds to checkout
      And fills in the form
      And Places order
      Then order is received