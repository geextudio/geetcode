/**
 * https://leetcode-cn.com/problems/fibonacci-number/submissions/
 * @param {number} N
 * @return {number}
 */
var memory ={}
var fib = function(n) {
        if(!n) return n
        if (n < 3) return 1
        
        if(!memory[n-2]){
            memory[n-2] = fib(n-2)
        } 
        
        if(!memory[n-1]){
            memory[n-1] = fib(n-1)
        } 
       
        return memory[n-1] + memory[n-2]
};