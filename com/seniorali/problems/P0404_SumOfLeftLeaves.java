package com.seniorali.problems;

import com.seniorali.utils.TreeNode;

/**
 * Problem: <a href="https://leetcode.com/problems/sum-of-left-leaves/">404. Sum of Left Leaves</a><br/>
 * Difficulty: {@code Easy}
 * <p>
 * Topics: {@code Tree}, {@code Depth-First Search}, {@code Breadth-First Search}, {@code Binary Tree}
 */
public class P0404_SumOfLeftLeaves {

    public int sumOfLeftLeaves(TreeNode root) {
        return sum(root, false);
    }

    private int sum(TreeNode root, boolean isLeft) {
        if (root == null) return 0;

        if (root.left == null && root.right == null)
            return isLeft ? root.val : 0;

        return sum(root.left, true) + sum(root.right, false);
    }
}
