Feature: Automate Search option in GreenKart

  @tag1
  Scenario Outline: Search items and add to cart and then check same items appear in checkout
    Given User is on greenkart landing page
    When item is present select items as per quanity and add to cart
      | item    | quantity |
      | <item1> | <q1>     |
      | <item2> | <q2>     |
      | <item3> | <q3>     |
    And click on cart and click on checkout
    And check wether user landed on place order page
    And check whether items passed to scenario and properly added
      | item    | quantity |
      | <item1> | <q1>     |
      | <item2> | <q2>     |
      | <item3> | <q3>     |
    Then click on place order
    And check whether user landed or select country page
    And Select Country as <country>
    And Tap on proceed

    Examples: 
      | item1    | item2       | item3    | q1 | q2 | q3 | country |
      | Brocolli | Almonds     | Beans    |  4 |  5 |  6 | India   |
      | Pears    | Pomegranate | Mushroom |  3 |  4 |  7 | Fiji    |
