package com.seniorali.problems;

/**
 * Problem: <a href="https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-i/">3014. Minimum Number of Pushes to Type Word I</a><br/>
 * Difficulty: {@code Easy}
 * <p>
 * Topics: {@code Greedy}, {@code Math}, {@code String}
 */
public class P3014_MinimumNumberOfPushesToTypeWordI {

    public int minimumPushes(String word) {
        int n = word.length();
        int result = 0;
        for (int i = n; i > 0; i--) {
            if (i > 24)
                result += 4;
            else if (i > 15)
                result += 3;
            else if (i > 8)
                result += 2;
            else
                result += 1;
        }
        return result;
    }
}
