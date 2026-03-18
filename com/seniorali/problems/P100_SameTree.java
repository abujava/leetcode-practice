package com.seniorali.problems;

import com.seniorali.utils.TreeNode;

/**
 * Problem: <a href="https://leetcode.com/problems/same-tree/">100. Same Tree</a><br/>
 * <p>
 * Difficulty: <code>Easy</code>
 * <p>
 * Topics: <code>Binary Tree</code>, <code>Tree</code>, <code>Depth-First Search</code>, <code>Breadth-First Search</code>
 */
public class P100_SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return isSameTreeRecursive(p, q);
    }

    private boolean isSameTreeRecursive(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;

        if (p != null && q != null)
            return p.val == q.val
                    && isSameTree(p.left, q.left)
                    && isSameTree(p.right, q.right);

        return false;
    }
}
