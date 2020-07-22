Feature: Fibonacci numbers
  F(0) = 0,   F(1) = 1
  F(N) = F(N - 1) + F(N - 2), for N > 1.

  Scenario Outline: Given N, calculate F(N).
    Given a <index> of number
    Then return sum <result>

  Examples: Nums Index
    | index                    | result |
    | 0                        | 0      |
    | 1                        | 1      |
    | 2                        | 1      |
    | 3                        | 2      |
    | 4                        | 3      |    
