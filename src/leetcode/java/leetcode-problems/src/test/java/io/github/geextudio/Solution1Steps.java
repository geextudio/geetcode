package io.github.geextudio;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import org.junit.Assert;
//import static org.junit.Assert.*;

import io.github.geextudio.solutions.*;

public class Solution1Steps {
    private int[] nums;
    private int target;
    private int[] indexes;

    @Given("a list of {string}")
    public void a_list_of(String numsPara) {
        // Write code here that turns the phrase above into concrete actions
        String[] numsArray = numsPara.split(",");
        this.nums = new int[numsArray.length];
        for(int index = 0; index < numsArray.length; index++){
            this.nums[index] = Integer.parseInt(numsArray[index]);
        }
    }

    @Given("a sum {int}")
    public void a_sum(Integer targetPara) {
        // Write code here that turns the phrase above into concrete actions
        this.target = targetPara;
    }

    @When("found sum of 2 nums meets target")
    public void found_sum_of_nums_meets_target() {
        // Write code here that turns the phrase above into concrete actions
        Solution1 solution = new Solution1();
        this.indexes = solution.twoSum(this.nums, this.target);
    }

    @Then("return indexes {string}")
    public void return_indexes(String resultPara) {
        // Write code here that turns the phrase above into concrete actions
        String[] resultArray = resultPara.split(",");
        int[] result = new int[resultArray.length];
        for(int index = 0; index < resultArray.length; index++){
            result[index] = Integer.parseInt(resultArray[index]);
        }
        Assert.assertArrayEquals( result, this.indexes );
    }
}
