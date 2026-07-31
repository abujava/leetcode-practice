package com.seniorali.problems;

import java.util.*;

/**
 * Problem: <a href="https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-ii">3016. Minimum Number of Pushes to Type Word II</a><br/>
 * Difficulty: {@code Medium}
 * <p>
 * Topics: {@code Greedy}, {@code Hashtable}, {@code String}, {@code Sorting}, {@code Counting}
 */
public class P3016_MinimumNumberOfPushesToTypeWordII {

    public static int minimumPushes(String word) {
        int[] count = new int[26];
        for (char c : word.toCharArray()) {
            count[c - 'a']++;
        }

        countSort(count);

        int result = 0;
        for (int i = 0; i < count.length; i++) {
            result += (i / 8 + 1) * count[count.length - 1 - i];
        }
        return result;
    }

    public static void countSort(int[] nums) {
        int max = 0;
        for (int i = 0; i < 26; i++) {
            max = Math.max(nums[i], max);
        }
        int freq[] = new int[max + 1];
        for (int i = 0; i < 26; i++) {
            freq[nums[i]]++;
        }
        int j = 0;
        for (int i = 0; i < max + 1; i++) {
            while (freq[i] > 0) {
                nums[j] = i;
                freq[i]--;
                j++;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(minimumPushes("aabbccddeeffgghhiiiiii"));
    }
}
