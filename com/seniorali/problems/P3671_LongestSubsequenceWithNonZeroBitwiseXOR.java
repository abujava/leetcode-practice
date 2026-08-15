package com.seniorali.problems;

/**
 * Problem: <a href="https://leetcode.com/problems/longest-subsequence-with-non-zero-bitwise-xor/">3671. Longest Subsequence With Non-Zero Bitwise XOR</a><br/>
 * Difficulty: {@code Medium}
 * <p>
 * Topics: {@code Array}, {@code Bit Manipulation}
 */
public class P3671_LongestSubsequenceWithNonZeroBitwiseXOR {

    public int longestSubsequence(int[] nums) {
        int total = 0, n = nums.length;
        boolean nonZero = false;

        for (int x : nums) {
            nonZero |= x > 0;
            total ^= x;
        }

        if (!nonZero) return 0;
        return total == 0 ? n - 1 : n;
    }
}
