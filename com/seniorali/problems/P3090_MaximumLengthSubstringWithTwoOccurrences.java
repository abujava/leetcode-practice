package com.seniorali.problems;

/**
 * Problem: <a href="https://leetcode.com/problems/maximum-length-substring-with-two-occurrences/">3090. Maximum Length Substring With Two Occurrences</a><br/>
 * Difficulty: {@code Easy}
 * <p>
 * Topics: {@code Hash Table}, {@code String}, {@code Sliding Window}
 */
public class P3090_MaximumLengthSubstringWithTwoOccurrences {

    public static int maximumLengthSubstring(String s) {
        int[] letters = new int[26];

        int max = 0, left = 0;
        for (int right = 0; right < s.length(); right++) {
            letters[s.charAt(right) - 'a']++;
            while (letters[s.charAt(right) - 'a'] > 2) {
                letters[s.charAt(left) - 'a']--;
                left++;
            }

            max = Math.max(right - left + 1, max);
        }
        return max;
    }
}
