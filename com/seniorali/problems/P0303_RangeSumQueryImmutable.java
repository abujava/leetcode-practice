package com.seniorali.problems;

/**
 * Problem: <a href="https://leetcode.com/problems/range-sum-query-immutable/">303. Range Sum Query - Immutable</a><br/>
 * Difficulty: {@code Easy}
 * <p>
 * Topics: {@code Array}, {@code Design}, {@code Prefix Sum}
 */
public class P0303_RangeSumQueryImmutable {

    static class NumArray {
        int[] pref;

        public NumArray(int[] nums) {
            int n = nums.length;
            pref = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                pref[i] = pref[i - 1] + nums[i - 1];
            }
        }

        public int sumRange(int left, int right) {
            return pref[right + 1] - pref[left];
        }
    }
}
