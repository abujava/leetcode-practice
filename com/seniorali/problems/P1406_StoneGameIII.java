package com.seniorali.problems;

/**
 * Problem: <a href="https://leetcode.com/problems/stone-game-iii/">1406. Stone Game III</a><br/>
 * Difficulty: {@code Hard}
 * <p>
 * Topics: {@code Array}, {@code Math}, {@code Dynamic Programming}, {@code Game Theory}
 */
public class P1406_StoneGameIII {

    public static String stoneGameIII(int[] piles) {
        int n = piles.length;

        int next1 = 0, next2 = 0, next3 = 0;
        for (int i = n - 1; i >= 0; i--) {
            var take1 = piles[i] - next1;
            var take2 = i + 1 < n ? (piles[i] + piles[i + 1] - next2) : Integer.MIN_VALUE;
            var take3 = i + 2 < n ? (piles[i] + piles[i + 1] + piles[i + 2] - next3) : Integer.MIN_VALUE;

            next3 = next2;
            next2 = next1;
            next1 = Math.max(take1, Math.max(take2, take3));
        }
        return next1 > 0 ? "Alice" : next1 < 0 ? "Bob" : "Tie";
    }

/*
    public static String stoneGameIII(int[] piles) {
        int n = piles.length;
        int min = 0x80000000;
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            var offset = n - i - 1;
            var take1 = piles[i] - dp[i + 1];
            var take2 = offset > 0 ? (piles[i] + piles[i + 1] - dp[i + 2]) : min;
            var take3 = offset > 1 ? (piles[i] + piles[i + 1] + piles[i + 2] - dp[i + 3]) : min;

            dp[i] = Math.max(take1, Math.max(take2, take3));
        }
        return dp[0] > 0 ? "Alice" : dp[0] < 0 ? "Bob" : "Tie";
    }
*/

    public static void main(String[] args) {
        System.out.println(stoneGameIII(new int[]{-1, -2, -3}));
    }
}

// Pick one
// 1, 2, 3, 7
// -1 -2 -4  7

// Pick Two
// 1, 2, 3, 7
// -7 -2 10  7

// Pick three
// 1, 2, 3, 7
// -1  12 10  7

