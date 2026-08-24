package com.seniorali.problems;

/**
 * Problem: <a href="https://leetcode.com/problems/climbing-stairs/">70. Climbing Stairs</a><br/>
 * Difficulty: {@code Easy}
 * <p>
 * Topics: {@code Math}, {@code Dynamic Programming}, {@code Memoization}
 */
public class P0070_ClimbingStairs {
    /*// Top-Down (Recursion + Memorization)
    public static int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;

        return rec(n, dp);
    }

    private static int rec(int n, int[] dp) {
        if (dp[n] != 0) return dp[n];
        return dp[n] = rec(n - 1, dp) + rec(n - 2, dp);
    }*/

    // Bottom-Up (Tabulation)
    public static int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(4));
    }
}
