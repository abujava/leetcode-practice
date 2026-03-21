package com.seniorali.problems;

import com.seniorali.utils.TreeNode;

/**
 * Problem: <a href="https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/">1022. Sum of Root To Leaf Binary Numbers</a>
 * <p>
 * Difficulty: <code>Easy</code>
 * <p>
 * Topics: {@code Staff}, {@code Tree}, {@code Depth-First Search}, {@code Binary Tree},
 */
public class P1022_SumOfRootToLeafBinaryNumbers {
    public static int sumRootToLeaf(TreeNode root) {
        return recursiveSum(root, 0);
    }

    private static int recursiveSum(TreeNode root, int current) {
        if (root == null) return 0;

        current = current * 2 + root.val;

        if (root.left == null && root.right == null) {
            return current;

        }
        return recursiveSum(root.left, current) + recursiveSum(root.right, current);
    }
}
