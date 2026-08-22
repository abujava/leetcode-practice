package com.seniorali.problems;

/**
 * Problem: <a href="https://leetcode.com/problems/distribute-elements-into-two-arrays-i/">3069. Distribute Elements Into Two Arrays I</a><br/>
 * Difficulty: {@code Easy}
 * <p>
 * Topics: {@code Array}, {@code Simulation}
 */
public class P3069_DistributeElementsIntoTwoArraysI {
    public int[] resultArray(int[] nums) {
        int n = nums.length;
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];

        arr1[0] = nums[0];
        arr2[0] = nums[1];

        int p1 = 0, p2 = 0;
        for (int i = 2; i < n; i++) {
            if (arr1[p1] > arr2[p2])
                arr1[++p1] = nums[i];
            else
                arr2[++p2] = nums[i];
        }

        for (int i = p1 + 1, j = 0; i < n; i++, j++)
            arr1[i] = arr2[j];

        return arr1;
    }
}