package com.seniorali.problems;

import com.seniorali.utils.TreeNode;

/**
 * Problem: <a href="https://leetcode.com/problems/invert-binary-tree/">226. Invert Binary Tree</a>
 * <p>
 * Difficulty: <code>Easy</code>
 * <p>
 * Topics: {@code Tree}, {@code Binary Tree}, {@code Breadth First Search}, {@code Deep First Search}
 */
public class P0226_InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        var temp = root.left;
        root.right = invertTree(temp);
        root.left = invertTree(root.right);
        return root;
    }
}