package com.seniorali.problems;

import java.util.Arrays;

/**
 * Problem: <a href="https://leetcode.com/problems/stone-game-ii/">1140. Stone Game II</a><br/>
 * Difficulty: {@code Medium}
 * <p>
 * Topics: {@code Array}, {@code Math}, {@code Dynamic Programming}, {@code Prefix Sum}, {@code Game Theory}
 */
class P1140_StoneGameII {

    public static
    int stoneGameII(int[] piles) {
        int n = piles.length;
        int[] suffixSum = new int[n];
        System.arraycopy(piles, 0, suffixSum, 0, n);

        for (int i = suffixSum.length - 2; i >= 0; i--)
            suffixSum[i] += suffixSum[i + 1];

        return maxStones(suffixSum, 1, 0, new int[n][n]);
    }

    private static
    int maxStones(int[] suffixSum, int M, int ind, int[][] dp) {
        if (ind + 2 * M >= suffixSum.length) {
            return suffixSum[ind];
        }
        if (dp[ind][M] > 0) return dp[ind][M];
        int res = Integer.MAX_VALUE;

        for (int i = 1; i <= 2 * M; i++) {
            res = Math.min(
                    res,
                    maxStones(suffixSum, Math.max(i, M), ind + i, dp)
            );
        }

        dp[ind][M] = suffixSum[ind] - res;
        return dp[ind][M];
    }

    public static void main(String[] args) {
        System.out.println(stoneGameII(new int[]{2, 7, 9, 4, 4}));
    }
}