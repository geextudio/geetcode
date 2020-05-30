# [题目7] 反转整数
# https://leetcode-cn.com/problems/reverse-integer/
# 给定一个整数，将其每位数字反转
# 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2的31次方,  2的31次方 − 1]。
# 请根据这个假设，如果反转后整数溢出那么就返回 0。

import pysnooper

class Solution:

    #@pysnooper.snoop()
    def reverse(self, num: int) -> int:
        max_number = 0x7fffffff # pow(2,31) - 1
        min_number = -0x80000000 #pow(2,31) * -1

        factor = -10 if num < 0 else 10
        # python 对负数取余有点特别，比如 -123 % 10 = 7 而 -123 % -10 = -3
        result = num % factor
        next_number = int(num / 10)

        while next_number != 0:
            result = result * 10
            result = result + (next_number % factor)
            if result > max_number or result < min_number:
                return 0
            next_number = int(next_number / 10)

        return result

if __name__ == "__main__":
    solution = Solution()
    print('problem ext 001...')

    # 342 is expected to be 243
    result = solution.reverse(342)
    print(result)

    # -123 is expected to be -321
    result = solution.reverse(-123)
    print(result)
