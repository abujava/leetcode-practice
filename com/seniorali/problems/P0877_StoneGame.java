package com.seniorali.problems;

import java.util.Arrays;

/**
 * Problem: <a href="https://leetcode.com/problems/stone-game/">877. Stone Game</a><br/>
 * Difficulty: {@code Medium}
 * <p>
 * Topics: {@code Array}, {@code Math}, {@code Dynamic Programming}, {@code Game Theory}
 */
public class P0877_StoneGame {
    public static boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        return getScoreDiff(piles, 0, piles.length - 1, dp) > 0;
    }

    private static int getScoreDiff(int[] nums, int i, int j, int[][] dp) {
        if (dp[i][j] != -1) return dp[i][j];
        if (i == j) return dp[i][j] = nums[i];

        return dp[i][j] = Math.max(
                nums[i] - getScoreDiff(nums, i + 1, j, dp),
                nums[j] - getScoreDiff(nums, i, j - 1, dp)
        );
    }

    public static void main(String[] args) {
        System.out.println(stoneGame(new int[]{3, 7, 2, 3}));
    }
}