Feature: Leetcode problem ext 001

  Scenario Outline: Reverse a num
    Given an integer <num>
    When reverse
    Then return <expected>

    Examples: Nums Meet Target
      | num | expected |
      |123|321|
      |-189|-981|
      |120|21|