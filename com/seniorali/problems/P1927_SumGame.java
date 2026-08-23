package com.seniorali.problems;

/**
 * Problem: <a href="https://leetcode.com/problems/sum-game/">1927. Sum Game</a><br/>
 * Difficulty: {@code Medium}
 * <p>
 * Topics: {@code Math}, {@code Greedy}, {@code Game Theory}
 */
public class P1927_SumGame {
    public static boolean sumGame(String s) {
        int leftSum = 0, rightSum = 0;
        int lcnt = 0, rcnt = 0;
        int n = s.length(), mid = n / 2;

        char[] chars = s.toCharArray();
        for (int i = 0; i < n; i++) {
            char c = chars[i];
            if (i < mid) {
                if (c == '?') lcnt++;
                else leftSum += c - 48;
            } else {
                if (c == '?') rcnt++;
                else rightSum += c - 48;
            }
        }

        int diffSum = leftSum - rightSum;
        int diffCnt = lcnt - rcnt;

        if ((lcnt + rcnt) % 2 != 0)
            return true;

        return diffSum + (diffCnt / 2) * 9 != 0;
    }
}
