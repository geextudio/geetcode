Feature: Leetcode problem 2

  Scenario Outline: Sum 2 nums
    Given a list1 of <num1>
    And a list2 of <num2>
    When sum the 2 nums
    Then return <result>

    Examples: Nums Meet Target
      | num1             | num2 | result |
      |0|0|0|
      |10|10|20|
      |101|101|202|
      | 8                | 8    | 16     |
      | 8                | 18    | 26     |
      | 18                | 18    | 36     |
      | 98                | 18    | 116     |
      | 342              | 465  | 807    |
