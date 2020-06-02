using System;
using Xunit;
using Xunit.Gherkin.Quick;
using LeetcodeProblems.Problem1;

namespace LeetcodeProblems.Problem1.features
{
    [FeatureFile("./twonums.Feature")]
    public sealed class Steps : Feature
    {

        private readonly Solution _solution = new Solution();

        [Given(@"a list of ""(.*)""")]
        public void set_list_of_number(string nums)
        {
            Console.WriteLine(nums);
        }

        [And(@"a sum (\d+)")]
        public void set_sum(int targetPara)
        {
            Console.WriteLine(targetPara);
        }

        [When(@"found sum of 2 nums meets target")]
        public void find_indexes()
        {

        }

        [Then(@"return indexes ""(.*)""")]
        public void The_result_should_be_equal(string resultPara)
        {
            Console.WriteLine(resultPara);
            var a = 1;
            var b = 2;
            Assert.Equal(a, b);
        }
    }
}