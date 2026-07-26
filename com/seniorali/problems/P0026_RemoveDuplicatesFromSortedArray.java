package com.seniorali.problems;

import java.util.Arrays;

/**
 * Problem: <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array">26. Remove Duplicates from Sorted Array</a><br/>
 * Difficulty: {@code Easy}
 * <p>
 * Topics: {@code Array}, {@code Two Pointers}
 */
public class P0026_RemoveDuplicatesFromSortedArray {
    public static int removeDuplicates(int[] nums) {
        // 0, 0, 1, 1, 1, 2, 2, 3, 3, 4
        // ^
        // 0, 1, 1  2, 3, 4
        //    ^     ^

        int unq = 1;

        for (int left = 0, i = 1; i < nums.length; i++) {
            if (nums[i] > nums[left]){
                unq++;
                nums[++left] = nums[i];
            }
        }
        return unq;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int unq = removeDuplicates(nums);
        System.out.println("Unq: " + unq + " Nums: " + Arrays.toString(nums));
    }
}
