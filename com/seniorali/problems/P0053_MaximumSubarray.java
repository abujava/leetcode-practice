package com.seniorali.problems;

import java.util.Arrays;

/**
 * Problem: <a href="https://leetcode.com/problems/maximum-subarray/">53. Maximum Subarray</a><br/>
 * Difficulty: {@code Medium}
 * <p>
 * Topics: {@code Array}, {@code Divide and Conquer}, {@code Dynamic Programming}
 */
public class P0053_MaximumSubarray {

    // [-2, 1, -3, 4, -1, 2, 1, -5, 4]
    public static int maxSubArray(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int s1 = 0;
        int s2 = nums[0];
        for (int i = 1; i < nums.length; i++) {
            s1 = Math.max(nums[i], s1 + nums[i]);
            s2 = Math.max(s1, s2);
        }
        return s2;
    }

    public static void main(String[] args) {
        maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
    }
}