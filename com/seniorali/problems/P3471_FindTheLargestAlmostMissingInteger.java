package com.seniorali.problems;

/**
 * Problem: <a href="https://leetcode.com/problems/find-the-largest-almost-missing-integer/">3471. Find the Largest Almost Missing Integer</a><br/>
 * Difficulty: {@code Easy}
 * <p>
 * Topics: {@code Array}, {@code Hash Table}, {@code Counting}
 */
public class P3471_FindTheLargestAlmostMissingInteger {
    public static int largestInteger(int[] nums, int k) {
        int[] freq = new int[51];
        int n = nums.length, maxNum = -1;

        for (int num : nums) {
            freq[num]++;
            maxNum = Math.max(maxNum, num);
        }

        if (k == n) return maxNum;

        if (k == 1) {
            for (int i = 50; i >= 0; i--)
                if (freq[i] == 1) return i;
            return -1;
        }

        int result = -1;
        if (freq[nums[0]] == 1)
            result = nums[0];
        if (freq[nums[n - 1]] == 1)
            result = Math.max(result, nums[n - 1]);

        return result;
    }
}
