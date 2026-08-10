package com.seniorali.problems;

/**
 * Problem: <a href="https://leetcode.com/problems/maximum-average-subarray-i/">643. Maximum Average Subarray I</a><br/>
 * Difficulty: {@code Easy}
 * <p>
 * Topics: {@code Array}, {@code Sliding Window}
 */
public class P0643_MaximumAverageSubarrayI {
    public static double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) sum += nums[i];

        int maxSum = sum;
        for (int i = k; i < nums.length; i++) {
            sum -= nums[i - k];
            sum += nums[i];
            maxSum = Math.max(maxSum, sum);
        }

        return (double) maxSum / k;
    }

    public static void main(String[] args) {
        System.out.println(findMaxAverage(new int[]{5}, 1));
    }
}