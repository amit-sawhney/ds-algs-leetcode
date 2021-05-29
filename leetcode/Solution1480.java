package leetcode;

public class Solution1480 {

    public int[] runningSum(int[] nums) {
        // Avoids index out of bounds error when initializing first element of dp array
        if (nums.length == 0) {
            return new int[] {};
        }

        int[] dp = new int[nums.length];

        dp[0] = nums[0];

        // Cumulative sum; similar to dynmamic programming question
        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i] + dp[i - 1];
        }

        return dp;
    }
}
