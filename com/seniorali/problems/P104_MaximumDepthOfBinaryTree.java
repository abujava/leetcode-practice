package com.seniorali.problems;

import com.seniorali.utils.TreeNode;

/**
 * Problem: <a href="https://leetcode.com/problems/maximum-depth-of-binary-tree/">104. Maximum Depth of Binary Tree</a><br/>
 * <p>
 * Difficulty: <code>Easy</code>
 * <p>
 * Topics: <code>Tree</code>, <code>Binary Tree</code>, <code>Depth-First Search</code>, <code>Breadth-First Search</code>
 */
public class P104_MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
