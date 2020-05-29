from behave import *
from code  import Solution

@given('an integer {num:d}')
def set_numslist1(context, num):
    context.solution = Solution()
    context.num = num

#@pysnooper.snoop()
@when('reverse')
def find_nums(context):
    context.result = context.solution.reverse(context.num)

#@pysnooper.snoop()
@then('return {expected:d}')
def check_result(context, expected):
    assert (expected == context.result)