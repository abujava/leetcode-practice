package com.seniorali.problems;

import com.seniorali.utils.TreeNode;

/**
 * Problem: <a href="https://leetcode.com/problems/validate-binary-search-tree/">98. Validate Binary Search Tree</a><br/>
 * Difficulty: {@code Medium}
 * <p>
 * Topics: {@code Tree}, {@code Depth-First Search}, {@code Binary Search Tree}, {@code Binary Tree}
 */
public class P0098_ValidateBinarySearchTree {

    public static boolean isValidBST(TreeNode root) {
        return isValid(root.left, Long.MIN_VALUE, root.val)
                && isValid(root.right, root.val, Long.MAX_VALUE);
    }

    private static boolean isValid(TreeNode root, long min, long max) {
        if (root == null) return true;

        if (root.val >= max || root.val <= min) return false;

        return isValid(root.left, min, root.val)
                && isValid(root.right, root.val, max);
    }

    static void main() {
        var root = new TreeNode(-2147483648);
        root.right = new TreeNode(2147483647);

//        root.left = new TreeNode(1);
//        root.right = new TreeNode(5);
//
//        root.left.left = new TreeNode(0);
//        root.left.right = new TreeNode(2);
//
//        root.right.left = new TreeNode(4);
//        root.right.right = new TreeNode(6);

        System.out.println(isValidBST(root));
    }
}