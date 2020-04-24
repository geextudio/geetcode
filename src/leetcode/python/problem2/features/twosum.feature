Feature: Leetcode problem 2

  Scenario Outline: Found sum of 2 nums meets target
    Given a list of <nums>
    And a sum <target>
    When found sum of 2 nums meets target
    Then return indexes <result>

    Examples: Nums Meet Target
      | nums                   | target | result |
      | 2,7,11,15              | 9      | 0,1    |
      | 3,2,3                  | 6      | 0,2    |
      | -1,-2,-3,-4,-5         | -8     | 2,4    |

