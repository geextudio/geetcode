/**
 * @param {string} s
 * @return {boolean}
 */
const ParenttheseDic = {
    '(': ')',
    '[': ']',
    '{': '}'
}
var isValid = function(s) {
   if(!s) return true
   let parenttheseArray = s.split('')
   if(parenttheseArray.length % 2 != 0) return false

   let stack = []
   for(let parentthese of parenttheseArray) 
   {
       if(stack.length > 0 && ParenttheseDic[stack[stack.length - 1]] == parentthese){
           stack.pop()
       }
       else{
           stack.push(parentthese)
       }
   }

   return stack.length == 0
};