namespace LeetcodeProblems.Problem1
{
    using System.Collections.Generic;

    public class Solution
    {
        public int[] TwoSum(int[] nums, int target)
        {
            if(nums == null || nums.Length < 2)
            {
                return new int[]{};
            }
            else
            {
                var result = new int[2]{0, 0};
                var restReference = new Dictionary<int, int>();

                for (var index = 0; index < nums.Length; index++)
                {
                    var rest = target - nums[index];
                    result[0] = index;
                    if (restReference.ContainsKey(rest))
                    {
                        result[1] = restReference[rest];
                        break;
                    }
                    else
                    {
                        restReference[rest] = index;
                    }
                }

                return result;
            }
        }
    }
}