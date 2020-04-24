#
# @lc app=leetcode.cn id=2 lang=python3
#
# [1] 两数之和
# https://leetcode-cn.com/problems/two-sum/
#
# @lc code=start
import pysnooper

class Solution:

    @pysnooper.snoop()
    def twoSum(self, nums, target):
        first_index = 0
        second_index = 1
        nums_len = len(nums)
        for second_index in range(nums_len):
            if second_index > first_index:
                rest = target - nums[second_index]
                if rest == nums[first_index]:
                    break
                first_index = first_index + 1
                second_index = first_index + 1
        return [first_index, second_index]