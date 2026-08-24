package com.seniorali.problems;

import java.util.Arrays;

/**
 * Problem: <a href="https://leetcode.com/problems/stone-game-viii/">1872. Stone Game VIII</a><br/>
 * Difficulty: {@code Hard}
 * <p>
 * Topics: {@code Array}, {@code Math}, {@code Dynamic Programming}, {@code Prefix Sum}, {@code Game Theory}
 */
public class P1872_StoneGameVIII {

    public static int stoneGameVIII(int[] stones) {
        int n = stones.length;
        int[] prefix = new int[n];

        prefix[0] = stones[0];
        for (int i = 1; i < n; i++)
            prefix[i] = prefix[i - 1] + stones[i];

        int best = prefix[n - 1];
        for (int i = n - 2; i >= 1; i--)
            best = Math.max(best, prefix[i] - best);

        return best;
    }

    public static void main(String[] args) {
        System.out.println(stoneGameVIII(new int[]{-1, 2, -3, 4, -5}));
    }
}
