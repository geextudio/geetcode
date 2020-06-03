using System;
using Xunit;
using Xunit.Gherkin.Quick;
using System.Collections;
using System.Linq;

using LeetcodeProblems.Problem1;

namespace LeetcodeProblems.Tests.Problem1
{
    [FeatureFile("./Problem1/TwoNums.feature")]
    public sealed class TwoNums : Feature
    {
        private readonly Solution solution = new Solution();

        private int[] nums;
        private int target;

        private int[] resultIndex;

        [Given(@"a list of ""(.*)""")]
        public void set_list_of_number(string numsPara)
        {
            this.nums = numsPara.Split(new char[]{','}).Select(n => int.Parse(n)).ToArray();
        }

        /* [And(@"a sum (\d+)")] */
        [And(@"a sum (.*)")]
        public void set_sum(int targetPara)
        {
            this.target = targetPara;
        }

        [When(@"found sum of 2 nums meets target")]
        public void find_indexes()
        {
            this.resultIndex = solution.TwoSum(this.nums, this.target);
        }

        [Then(@"return indexes ""(.*)""")]
        public void The_result_should_be_equal(string resultPara)
        {
            var resultExpected = resultPara.Split(new char[]{','});
            Assert.Equal(this.resultIndex.Length, resultExpected.Length);
            for ( var index = 0; index < resultExpected.Length; index++ )
            {
                Assert.Equal(int.Parse(resultExpected[index].Trim()), this.resultIndex[index]);
            }
        }
    }
}