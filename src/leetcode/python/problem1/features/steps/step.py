from behave import *
from code  import Solution
#import pysnooper

@given('a list of {nums}')
def set_nums(context, nums):
    context.solution = Solution()
    context.nums = [int(d) for d in nums.split(',')]

@given('a sum {target:d}')
def set_target(context, target):
    context.target = target

#@pysnooper.snoop()
@when('found sum of 2 nums meets target')
def find_nums(context):
    context.indexes = context.solution.twoSum(context.nums, context.target)

#@pysnooper.snoop()
#compare list: https://www.cnblogs.com/lsdb/p/10275657.html
@then('return indexes {result}')
def check_result(context, result):
    check_ref = ([int(d) for d in result.split(',')])
    check_ref.sort()
    context.indexes.sort()
    #assert (context.indexes.sort() == check_ref.sort())
    for i in range(len(check_ref)):
        assert (check_ref[i] == context.indexes[i])