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
        cusor = 0
        dict = {} # 使用的字典保存参考差值与 index，以便对 list 的单次遍历即可得到结果
        while cusor < len(nums):
            rest = target - nums[cusor]

            if rest in dict:
                return [dict[rest], cusor]
            else:
                dict[nums[cusor]] = cusor

            cusor = cusor + 1
