package com.seniorali.problems;

/**
 * Problem: <a href="https://leetcode.com/problems/fibonacci-number/">509. Fibonacci Number</a><br/>
 * Difficulty: {@code Easy}
 * <p>
 * Topics: {@code Math}, {@code Dynamic Programming}, {@code Recursion}, {@code Memoization}
 */
public class P0509_FibonacciNumber {

    public int fib(int n) {
        if (n < 2) return n;

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
