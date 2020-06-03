namespace LeetcodeProblems.Problem1
{
    using System.Linq;
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
                    var current = nums[index];
                    var rest = target - current;

                    if (restReference.ContainsKey(current))
                    {
                        result[0] = restReference[current];
                        result[1] = index;
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