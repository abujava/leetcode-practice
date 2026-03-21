package com.seniorali.problems;

import com.seniorali.utils.TreeNode;

import java.util.Objects;

/**
 * Problem: <a href="https://leetcode.com/problems/sum-root-to-leaf-numbers/">129. Sum Root to Leaf Numbers</a>
 * <p>
 * Difficulty: <code>Medium</code>
 * <p>
 * Topics: {@code Tree}, {@code Binary Tree}, {@code Deep First Search}
 */
public class P0129_SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;

        return sumNumbers(root, "");
    }

    private int sumNumbers(TreeNode root, String path) {
        String currentPath = path + root.val;
        if (root.left == null && root.right == null) {
            return Integer.parseInt(currentPath);
        } else if (root.left != null && root.right != null) {
            return sumNumbers(root.left, currentPath) + sumNumbers(root.right, currentPath);
        } else
            return sumNumbers(Objects.requireNonNullElseGet(root.left, () -> root.right), currentPath);
    }
}