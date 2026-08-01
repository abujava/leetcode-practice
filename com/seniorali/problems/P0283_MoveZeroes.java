package com.seniorali.problems;

import java.util.Arrays;

/**
 * Problem: <a href="https://leetcode.com/problems/move-zeroes/">283. Move Zeroes</a><br/>
 * Difficulty: {@code Easy}
 * <p>
 * Topics: {@code Array}, {@code Two Pointers}
 */
public class P0283_MoveZeroes {
    // Input:  [0,1,0,3,12]
    // Output: [1,3,12,0,0]
    public static void moveZeroes(int[] nums) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                int temp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = temp;
                slow++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 0};
        moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }
}