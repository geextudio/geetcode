/**
 * https://leetcode-cn.com/problems/fibonacci-number/submissions/
 * @param {number} N
 * @return {number}
 */
 
namespace LeetcodeProblems.Problem509
{
    public class Solution001
    {
         public int Fib(int N) {
            var fibNumbers = new int[]{0,1,1};
            if(N == 0) return fibNumbers[0];
            else if (N <= 2) return fibNumbers[N];
            
            for(var index = 2; index < N; index++)
            {         
                fibNumbers[0] = fibNumbers[1];
                fibNumbers[1] = fibNumbers[2];          
                fibNumbers[2] = fibNumbers[1] + fibNumbers[0];
            }
            return fibNumbers[2];
        }
    }
}