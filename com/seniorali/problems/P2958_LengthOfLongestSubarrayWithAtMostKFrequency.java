package com.seniorali.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem: <a href="https://leetcode.com/problems/length-of-longest-subarray-with-at-most-k-frequency/">2958. Length of Longest Subarray With at Most K Frequency</a><br/>
 * Difficulty: {@code Medium}
 * <p>
 * Topics: {@code Array}, {@code Hash Table}, {@code Sliding Window}
 */
public class P2958_LengthOfLongestSubarrayWithAtMostKFrequency {

    static class Counter {
        int count = 0;
    }

    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Counter> map = new HashMap<>();

        int left = 0, right = 0, maxLeng = 0;
        while (right < n) {
            int num = nums[right++];
            Counter counter = map.get(num);
            if (counter == null)
                map.put(num, counter = new Counter());

            if (counter.count < k) {
                counter.count++;
            } else {
                int num2;
                while ((num2 = nums[left++]) != num) {
                    map.get(num2).count--;
                }
            }
            maxLeng = Math.max(maxLeng, right - left);
        }
        return maxLeng;
    }

    /*public static int maxSubarrayLength(int[] nums, int k) {
        int leng = 0, maxLeng = 0, left = 0;

        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {

            int count = freq.merge(num, 1, Integer::sum);
            leng++;

            if (count > k) {
                while (freq.get(num) > k) {
                    freq.merge(nums[left], -1, Integer::sum);
                    left++;
                    leng--;
                }
            }

            maxLeng = Math.max(leng, maxLeng);
        }
        return maxLeng;
    }*/
}