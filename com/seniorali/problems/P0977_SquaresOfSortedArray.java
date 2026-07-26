package com.seniorali.problems;

import java.util.Arrays;

/**
 * Problem: <a href="https://leetcode.com/problems/squares-of-a-sorted-array">977. Squares of a Sorted Array</a><br/>
 * Difficulty: {@code Easy}
 * <p>
 * Topics: {@code Array}, {@code Two Pointers}, {@code String}
 */
public class P0977_SquaresOfSortedArray {
    public static int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int pos = n - 1;

        int[] res = new int[n];

        while (left <= right) {
            int leftSqr = nums[left] * nums[left];
            int rightSqr = nums[right] * nums[right];

            if (rightSqr > leftSqr) {
                res[pos] = rightSqr;
                right--;
            } else {
                res[pos] = leftSqr;
                left++;
            }
            pos--;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-4, -1, 0, 3, 10};
        int[] res = sortedSquares(nums);
        System.out.println(Arrays.toString(res));
    }
}
