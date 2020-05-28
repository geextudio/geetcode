from behave import *
from code  import Solution, ListNode

# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

@given('a list1 of {num1:d}')
def set_numslist1(context, num1):
    context.solution = Solution()
    context.num1List = ListNode(-1)
    context.num1List = context.solution.get_list_from_num(num1, context.num1List)

@given('a list2 of {num2:d}')
def set_numslist2(context, num2):
    context.num2List = ListNode(-1)
    context.num2List = context.solution.get_list_from_num(num2, context.num2List)

#@pysnooper.snoop()
@when('sum the 2 nums')
def find_nums(context):
    context.expectedNumberList = context.solution.addTwoNumbers(context.num1List, context.num2List)

#@pysnooper.snoop()
@then('return {result:d}')
def check_result(context, result):
    expectList = ListNode(-1)
    expectList = context.solution.get_list_from_num(result, expectList)
    assert (expectList.val == context.expectedNumberList.val)