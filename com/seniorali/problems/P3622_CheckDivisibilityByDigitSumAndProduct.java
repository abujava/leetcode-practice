package com.seniorali.problems;

/**
 * Problem: <a href="https://leetcode.com/problems/check-divisibility-by-digit-sum-and-product/">3622. Check Divisibility by Digit Sum and Product</a><br/>
 * Difficulty: {@code Easy}
 * <p>
 * Topics: {@code Math}
 */
public class P3622_CheckDivisibilityByDigitSumAndProduct {

    public static boolean checkDivisibility(int n) {
        int digitSum = 0, digitProduct = 1;
        int mod = n;
        while (mod > 0) {
            digitSum += mod % 10;
            digitProduct *= mod % 10;
            mod = mod / 10;
        }

        return n % (digitSum + digitProduct) == 0;
    }
}