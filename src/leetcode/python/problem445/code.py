# [445] 两数相加 II
# https://leetcode-cn.com/problems/add-two-numbers-ii/
# 进阶：
# 如果输入链表不能修改该如何处理？即你不能对列表中的节点进行翻转。

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

        newnodes = ListNode(-1)
        result = newnodes # store the init address

        next_extra_val = 0
        while l1 != None or l2 != None:
            num = 0

            if l1 != None and l2 != None:
                num = l1.val + l2.val
                l1 = l1.next
                l2 = l2.next
            elif l1 != None:
                num = l1.val
                l1 = l1.next
            elif l2 != None:
                num = l2.val
                l2 = l2.next

            current = (num + next_extra_val) % 10
            next_extra_val = int((num + next_extra_val)  / 10)

            if newnodes.val < 0:
                newnodes.next = ListNode(current)
                newnodes = newnodes.next
            else:
                newnodes.val = current

            if next_extra_val > 0:
                newnodes.next = ListNode(0)
                newnodes = newnodes.next
                if (l1 == None and l2 == None):
                    l1 = ListNode(0)
            elif (l1 != None or l2 != None):
                newnodes.next = ListNode(0)
                newnodes = newnodes.next

        return result.next

if __name__ == "__main__":
    solution = Solution()
    print('problem 445...')
    nodeTest = ListNode(-1)
    # 342 is expected to be 3 -> 4 -> 2
    nodeTest = solution.get_list_from_num(342, nodeTest)
    print(nodeTest.val)
    print(nodeTest.next.val)
    print(nodeTest.next.next.val)

    # 465 is 4 -> 6 -> 5
    nodeTest = ListNode(-1)
    nodeTest = solution.get_list_from_num(465, nodeTest)
    print(nodeTest.val)
    print(nodeTest.next.val)
    print(nodeTest.next.next.val)