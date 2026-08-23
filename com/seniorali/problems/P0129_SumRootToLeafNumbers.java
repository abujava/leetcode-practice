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
        return traverse(root, 0);
    }

    private int traverse(TreeNode node, int currentSum) {
        if (node == null)
            return 0;
        int sum = currentSum * 10 + node.val;
        if (node.left == null && node.right == null)
            return sum;
        return traverse(node.left, sum) + traverse(node.right, sum);
    }
}