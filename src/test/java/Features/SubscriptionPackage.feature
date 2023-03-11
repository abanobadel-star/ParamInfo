Feature: Subscription Package

  Scenario Outline: check Price Subscription Very Country
    Given user in Home Page
    When user open country list
    And user select country "<Country>"
    Then verify price for subscription is "<price_of_Subscription>"
    Examples:
      | Country | price_of_Subscription |
      | #eg     | 10.00                 |
      | #ae     | 10.00                 |
      | #jo     | 0.99                  |

  Scenario Outline: check Type of Subscription Very Country
    Given user in Home Page
    When user open country list
    And user select country "<Country>"
    Then verify Type for subscription is "<Type_of_Subscription>"
    Examples:
      | Country | Type_of_Subscription |
      | #eg     | CLASSIC              |
      | #ae     | CLASSIC              |
      | #jo     | CLASSIC              |

  Scenario Outline: check currency of Subscription Very Country
    Given user in Home Page
    When user open country list
    And user select country "<Country>"
    Then verify currency for subscription is "<Currency_of_Subscription>"
    Examples:
      | Country | Currency_of_Subscription |
      | #eg     | Egyptian pound           |
      | #ae     | AED                      |
      | #jo     | JOD                      |


