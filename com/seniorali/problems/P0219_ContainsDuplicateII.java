package com.seniorali.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem: <a href="https://leetcode.com/problems/contains-duplicate-ii/">219. Contains Duplicate II</a><br/>
 * Difficulty: {@code Easy}
 * <p>
 * Topics: {@code Array}, {@code Hash Table}, {@code Sliding Window}
 */
public class P0219_ContainsDuplicateII {

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k == 0 || nums.length <= 1) return false;

        int min = nums[0];
        int max = nums[0];

        for (int num : nums) {
            if (num < min) min = num;
            if (num > max) max = num;
        }

        long range = (long) max - min;
        if (range > 100_000) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
                    return true;
                }
                map.put(nums[i], i);
            }
            return false;
        }

        int[] lastSeen = new int[(int) range + 1];

        for (int i = 0; i < nums.length; i++) {
            int val = nums[i] - min;
            if (lastSeen[val] > 0 && i - (lastSeen[val] - 1) <= k) {
                return true;
            }
            lastSeen[val] = i + 1;
        }

        return false;
    }
}
