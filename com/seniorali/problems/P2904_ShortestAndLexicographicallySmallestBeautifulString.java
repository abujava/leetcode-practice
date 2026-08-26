package com.seniorali.problems;

/**
 * Problem: <a href="https://leetcode.com/problems/shortest-and-lexicographically-smallest-beautiful-string/">2904. Shortest and Lexicographically Smallest Beautiful String</a><br/>
 * Difficulty: {@code Medium}
 * <p>
 * Topics: {@code String}, {@code Sliding Window}
 */
public class P2904_ShortestAndLexicographicallySmallestBeautifulString {
    public static String shortestBeautifulSubstring(String s, int k) {
        char[] chars = s.toCharArray();

        int n = chars.length;
        int bestStart = -1;
        int minLength = 101;

        for (int start = 0; start <= n - k; start++) {
            int count = 0;

            for (int end = start; end < n; end++) {
                if (chars[end] == '1') count++;
                if (count != k) continue;

                int currentLength = end - start + 1;
                if (currentLength < minLength) {
                    minLength = currentLength;
                    bestStart = start;
                } else if (currentLength == minLength) {
                    for (int i = 0; i < minLength; i++) {
                        char current = chars[start + i];
                        char best = chars[bestStart + i];

                        if (current < best) {
                            bestStart = start;
                            break;
                        }

                        if (current > best) break;
                    }
                }
                break;
            }
        }

        return bestStart == -1 ? "" : s.substring(bestStart, bestStart + minLength);
    }
}