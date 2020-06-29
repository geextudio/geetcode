#
# @lc app=leetcode.cn id=19 lang=python3
#
# [19] 删除链表的倒数第N个节点
# https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/

# @lc code=start
# Definition for singly-linked list.
import pysnooper

class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def removeNthFromEnd(self, head: ListNode, n: int) -> ListNode:
# @lc code=end

