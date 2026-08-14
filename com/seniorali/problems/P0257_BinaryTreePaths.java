package com.seniorali.problems;

import com.seniorali.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: <a href="https://leetcode.com/problems/invert-binary-tree/">257. Binary Tree Paths</a>
 * <p>
 * Difficulty: <code>Easy</code>
 * <p>
 * Topics: {@code Tree} {@code Binary Tree} {@code Depth-First Search} {@code Backtracking} {@code String}
 */
public class P0257_BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> result = new ArrayList<>();
        makePath(root, String.valueOf(root.val), result);
        return result;
    }

    public void makePath(TreeNode root, String s, List<String> result) {
        if (root.left == null && root.right == null) {
            result.add(s);
        }
        if (root.left != null) {
            makePath(root.left, s + "->" + root.left.val, result);
        }
        if (root.right != null) {
            makePath(root.right, s + "->" + root.right.val, result);
        }
    }
}
