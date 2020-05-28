# [2] 两数相加
# https://leetcode-cn.com/problems/add-two-numbers/

# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

import pysnooper

class Solution:

    #@pysnooper.snoop()
    def get_list_from_num(self, num, node):
        current = num % 10
        rest = int(num  / 10)
        node = ListNode(current)
        if rest > 0:
            node.next = self.get_list_from_num(rest, ListNode(-1))
        return node

    @pysnooper.snoop()
    def addTwoNumbers(self, l1, l2):
        resultList = ListNode(7)
        resultList.next = ListNode(0)
        resultList.next.next = ListNode(8)

        return resultList


if __name__ == "__main__":
    solution = Solution()
    print('problem 2...')
    nodeTest = ListNode(-1)
    # 342 is expected to be 2 -> 4 -> 3
    nodeTest = solution.get_list_from_num(342, nodeTest)
    print(nodeTest.val)
    print(nodeTest.next.val)
    print(nodeTest.next.next.val)

    # 465 is 5 -> 6 -> 4
    nodeTest = ListNode(-1)
    nodeTest = solution.get_list_from_num(465, nodeTest)
    print(nodeTest.val)
    print(nodeTest.next.val)
    print(nodeTest.next.next.val)