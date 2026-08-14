package com.seniorali.problems;

import com.seniorali.utils.TreeNode;

/**
 * Problem: <a href="https://leetcode.com/problems/balanced-binary-tree/">110. Balanced Binary Tree</a><br/>
 * Difficulty: {@code Easy}
 * <p>
 * Topics: {@code Tree}, {@code Depth-First Search}, {@code Binary Tree}
 */
public class P0110_BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    public int height(TreeNode root) {
        if (root == null) return 0;

        int leftHeight = height(root.left);
        if (leftHeight == -1) return leftHeight;

        int rightHeight = height(root.right);
        if (rightHeight == -1) return rightHeight;

        if (Math.abs(leftHeight - rightHeight) > 1)
            return -1;

        return Math.max(leftHeight, rightHeight) + 1;
    }
}