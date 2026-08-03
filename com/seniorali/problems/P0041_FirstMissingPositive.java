package com.seniorali.problems;

import java.util.Arrays;

/**
 * Problem: <a href="https://leetcode.com/problems/first-missing-positive/">41. First Missing Positive</a><br/>
 * Difficulty: {@code Hard}
 * <p>
 * Topics: {@code Array}, {@code Hash Table}
 */
public class P0041_FirstMissingPositive {

    public static int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int orphan = nums[i];
            while (orphan > 0 && orphan <= nums.length && nums[orphan - 1] != orphan) {
                int temp = nums[orphan - 1];
                nums[orphan - 1] = orphan;
                orphan = temp;
            }
        }

        System.out.println(Arrays.toString(nums));

        int target = 1;
        for (int num : nums) {
            if (num != target)
                return target;
            target++;
        }
        return target;
    }

    /*public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);

        int target = 1;
        for (int n : nums) {
            if (n == target) {
                target++;
            } else if (n > 0 && n > target) {
                return target;
            }
        }

        return target;
    }*/

    public static void main(String[] args) {
        System.out.println("Result:" + firstMissingPositive(new int[]{4, 1, 0, 5, 3, 12, 6}));
//        System.out.println("Result:" + firstMissingPositive(new int[]{2, 1}));
    }
}