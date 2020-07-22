namespace LeetcodeProblems.Tests.Problem509
{
    using Xunit;
    using Xunit.Gherkin.Quick;
    using LeetcodeProblems.Problem509;

    [FeatureFile("./Problem509/Fib.feature")]
    public sealed class Steps: Feature
    {
        private readonly Solution001 solution = new Solution001();
        private int index;

        [Given(@"a (.*) of number")]
        public void set_index_of_numbe(int indexPara)
        {
            this.index = indexPara;
        }

         [Then(@"return sum (.*)")]
        public void The_result_should_be_equal(int  resultPara)
        {
           var sum = this.solution.Fib(this.index);
           Assert.Equal(sum, resultPara);
        }
    }
}