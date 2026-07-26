package com.seniorali.problems;

import java.util.Arrays;

/**
 * Problem: <a href="https://leetcode.com/problems/maximum-product-of-three-numbers/">628. Maximum Product of Three Numbers</a><br/>
 * Difficulty: {@code Easy}
 * <p>
 * Topics: {@code Array}, {@code Math}, {@code Sorting}
 */
public class P0628_MaximumProductOfThreeNumbers {

    public static int maximumProduct(int[] a) {
        Arrays.sort(a);
        int l = a.length;
        return Math.max(
                a[l - 1] * a[l - 2] * a[l - 3],
                a[l - 1] * a[0] * a[1]
        );
    }
}