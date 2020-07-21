namespace LeetcodeProblems.Problem509
{
    public class Solution001
    {
         public int Fib(int N) {
            var fibNumbers = new int[]{0,1,1};
            if(N > 2)
            {
                for(var index = 2; index < N; index++)
                {
                        fibNumbers[index + 1] = fibNumbers[index] + fibNumbers[index - 1];
                }
            }
            return fibNumbers[N];
        }
    }
}