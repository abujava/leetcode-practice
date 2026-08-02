package com.seniorali.problems;

/**
 * Problem: <a href="https://leetcode.com/problems/smallest-palindromic-rearrangement-ii/">3518. Smallest Palindromic Rearrangement II</a><br/>
 * Difficulty: {@code Hard}
 * <p>
 * Topics: {@code Hash Table}, {@code String}, {@code Counting}, {@code Math}, {@code Combinatorics}
 */
public class P3518_SmallestPalindromicRearrangementII {

    public static String smallestPalindrome(String s, int k) {
        int[] freq = new int[26];
        for (char c : s.toCharArray())
            freq[c - 'a']++;

        char middleChar = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 != 0) {
                middleChar = (char) ('a' + i);
            }
            freq[i] /= 2;
        }

        if (countCombinations(freq, k) < k)
            return "";

        int n = s.length();
        char[] res = new char[n];
        if (middleChar != 0) {
            res[n / 2] = middleChar;
        }

        int left = 0;
        int right = n - 1;
        while (left < n / 2) {
            for (int i = 0; i < 26; i++) {
                if (freq[i] == 0) continue;

                freq[i]--;
                long comb = countCombinations(freq, k);
                if (comb >= k) {
                    char ch = (char) ('a' + i);
                    res[left] = ch;
                    res[right] = ch;
                    break;
                } else {
                    k -= comb;
                    freq[i]++;
                }
            }

            left++;
            right--;
        }
        return new String(res);
    }

    private static long countCombinations(int[] freq, long k) {
        int totalElements = 0;
        for (int c : freq) {
            totalElements += c;
        }

        if (totalElements == 0) {
            return 1;
        }

        long totalWays = 1;
        int currentSum = 0;

        for (int c : freq) {
            if (c == 0) continue;

            for (int i = 1; i <= c; i++) {
                currentSum++;
                totalWays = totalWays * currentSum / i;

                if (totalWays >= k) {
                    return k;
                }
            }
        }

        return totalWays;
    }

/*
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

        return (odd != Character.MIN_VALUE ? sb.toString() + odd : sb.toString()) + sb.reverse();
    }
*/

    public static void main(String[] args) {
        String s = "abba";
        System.out.println(smallestPalindrome(s, 2));
//        System.out.println(Character.);
    }
}