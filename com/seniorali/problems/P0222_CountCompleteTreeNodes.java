package com.seniorali.problems;

import com.seniorali.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Problem: <a href="https://leetcode.com/problems/count-complete-tree-nodes">222. Count Complete Tree Nodes</a>
 * <p>
 * Difficulty: <code>Easy</code>
 * <p>
 * Topics: {@code Tree}, {@code Binary Tree}, {@code Binary Search}, {@code Bit Manipulation}
 */
public class P0222_CountCompleteTreeNodes {
    int height(TreeNode root) {
        return -1;
    }

    public int leftHeight(TreeNode root) {
        if (root == null) return 0;

        return 1 + height(root.left);
    }

    public int rightHeight(TreeNode root) {
        if (root == null) return 0;

        return 1 + height(root.right);
    }

}