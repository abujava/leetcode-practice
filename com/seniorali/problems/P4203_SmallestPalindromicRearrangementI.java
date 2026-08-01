package com.seniorali.problems;

/**
 * Problem: <a href="https://leetcode.com/problems/smallest-palindromic-rearrangement-i/">4203. Smallest Palindromic Rearrangement I</a><br/>
 * Difficulty: {@code Medium}
 * <p>
 * Topics: {@code Hash Table}, {@code String}, {@code Counting}, {@code Greedy}, {@code Sorting}
 */
public class P4203_SmallestPalindromicRearrangementI {

    public static String smallestPalindrome(String s) {
        int[] count = new int[26];
        char[] chars = s.toCharArray();
        for (char c : chars)
            count[c - 'a']++;

        StringBuilder sb = new StringBuilder(s.length());
        char odd = Character.MIN_VALUE;
        for (int i = 0; i < count.length; i++) {
            int j = count[i];
            if (j > 0) {
                sb.repeat('a' + i, j / 2);
            }
            if ((j & 1) != 0)
                odd = (char) ('a' + i);
        }

        // bad
        return (odd != Character.MIN_VALUE ? sb.toString() + odd : sb.toString()) + sb.reverse();
    }
}