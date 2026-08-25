package com.seniorali.problems;

/**
 * Problem: <a href="https://leetcode.com/problems/smallest-missing-multiple-of-k/">3264. Smallest Missing Multiple of K</a><br/>
 * Difficulty: {@code Easy}
 * <p>
 * Topics: {@code Array}, {@code Hash Table}, {@code Math}
 */
public class P3264_SmallestMissingMultipleOfK {
    public static int missingMultiple(int[] nums, int k) {
        boolean[] arr = new boolean[101];
        for (int num : nums) {
            arr[num] = true;
        }

        int target = k;
        for (; target <= 100; target += k) {
            if (!arr[target]) return target;
        }
        return target;
    }
}
