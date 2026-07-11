package com.seniorali.problems;

import com.seniorali.utils.TreeNode;

/**
 * Problem: <a href="https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/">108. Convert Sorted Array to Binary Search Tree</a><br/>
 * <p>
 * Difficulty: <code>Easy</code>
 * <p>
 * Topics: {@code Array}, {@code Divide and Conquer}, {@code Tree}, {@code Binary Search Tree}, {@code Binary Tree}
 */
public class P0108_ConvertSortedArrayToBinarySearchTree {
    // TODO
    public static TreeNode sortedArrayToBST(int[] nums) {
        return convert(nums, 0, nums.length - 1);
    }

    public static TreeNode convert(int[] nums, int left, int right) {
        // -10,-3,0,5,9
        if (left > right) return null;

        int mid = left + ((right - left) / 2); // mid=2 | nums[mid]=0
        var node = new TreeNode(nums[mid]);
        // 0
        //  5

        node.right = convert(nums, mid + 1, right); // mid=3,4 | 4
        node.left = convert(nums, left, mid - 1);
        return node;
    }


    public static void main(String[] args) {
        var result = sortedArrayToBST(
                new int[]{-10,-3,0,5,9}
        );

        System.out.println(result);
    }
}
