# [题目7] 反转整数
# https://leetcode-cn.com/problems/reverse-integer/
# 给定一个整数，将其每位数字反转
# 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。
# 请根据这个假设，如果反转后整数溢出那么就返回 0。

import pysnooper

class Solution:

    #@pysnooper.snoop()
    def reverse(self, num):
        max = pow(2,31)-1
        min = pow(2,31) * -1

        result = 0

        factor = -1 if num < 0 else 1
        num = num * factor
        # python 对负数取余有点特别，比如 -123 % 10 = 7 而 -123 % -10 = -3

        result = num % 10
        next = int(num / 10)

        while next != 0:
            result = result * 10
            result = result + (next%10)
            if result * factor > max or result * factor < min:
                return 0
            next = int(next / 10)

        return result * factor

if __name__ == "__main__":
    solution = Solution()
    print('problem ext 001...')

    # 342 is expected to be 243
    result = solution.reverse(342)
    print(result)

    # -123 is expected to be -321
    result = solution.reverse(-123)
    print(result)
