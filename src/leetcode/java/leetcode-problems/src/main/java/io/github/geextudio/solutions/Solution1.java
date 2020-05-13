package io.github.geextudio.solutions;
//[1. 两数之和](https://leetcode-cn.com/problems/two-sum/)

import java.util.HashMap;
import java.util.Map;

public class Solution1 {

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[] {0,1};
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int index = 0; index < nums.length; index++){
            int rest = target - nums[index];
            
            if(map.containsKey(nums[index])){
                return new int[]{map.get(nums[index]), index};                
            }
            else{ 
                map.put(rest, index);
            }
        }
        
        return result;
    }
}