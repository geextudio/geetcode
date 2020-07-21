/**
 * https://leetcode-cn.com/problems/fibonacci-number/submissions/
 * @param {number} N
 * @return {number}
 */

var fib = function(N) {
    var fibNumbers =  [0, 1, 1];
    if(N > 2) {
        for(var i=2; i < N; i++) {
            fibNumbers[i+1]=fibNumbers[i] + fibNumbers[i-1]
        }
    }    
    return fibNumbers[N]
};