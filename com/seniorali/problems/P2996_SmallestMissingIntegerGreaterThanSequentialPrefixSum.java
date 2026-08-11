package com.seniorali.problems;

import java.util.Arrays;

/**
 * Problem: <a href="https://leetcode.com/problems/smallest-missing-integer-greater-than-sequential-prefix-sum/">2996. Smallest Missing Integer Greater Than Sequential Prefix Sum</a><br/>
 * Difficulty: {@code Easy}
 * <p>
 * Topics: {@code Array}, {@code Hash Table}, {@code Sorting}, {@code Simulation}
 */
public class P2996_SmallestMissingIntegerGreaterThanSequentialPrefixSum {

    public static int missingInteger(int[] nums) {
        boolean[] arr = new boolean[52];
        for (int num : nums) arr[num] = true;

        int sum = nums[0], maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] != 1) break;

            sum += nums[i];
            maxSum = Math.max(sum, maxSum);
        }

        for (int i = maxSum; i < arr.length; i++)
            if (!arr[i]) return i;

        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(missingInteger(new int[]{3, 4, 5, 1, 12, 14, 13}));
    }
}