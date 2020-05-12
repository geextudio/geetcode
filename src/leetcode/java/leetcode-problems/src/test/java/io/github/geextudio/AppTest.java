package io.github.geextudio;

//import static org.junit.Assert.assertTrue;

import io.github.geextudio.solutions.*;

import org.junit.Test;
import org.junit.Assert;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void TestSolution1()
    {
        Solution1 solution = new Solution1();
        int[] nums = new int[] {1,2,3,4};
        int target = 6;
        int[] expected = new int[]{1,3};
        int[] result = new int[2];

        result = solution.twoSum(nums, target);

        System.out.println("Solution Result: " );
        System.out.println(result[0] + ", " + result[1]);

        Assert.assertArrayEquals( expected, result );
    }
}
