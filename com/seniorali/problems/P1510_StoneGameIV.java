package com.seniorali.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: <a href="https://leetcode.com/problems/stone-game-iv/">1510. Stone Game IV</a><br/>
 * Difficulty: {@code Hard}
 * <p>
 * Topics: {@code Math}, {@code Dynamic Programming}, {@code Game Theory}
 */
public class P1510_StoneGameIV {
    private static final boolean[] dp = new boolean[100_001];

    static {
        for (int i = 0; i <= 100_000; i++) {
            if (!dp[i]) {
                for (int j = 1; i + j * j <= 100_000; j++) {
                    dp[i + j * j] = true;
                }
            }
        }
    }

    public boolean winnerSquareGame(int n) {
        return dp[n];
    }
}