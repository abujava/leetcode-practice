package com.seniorali.problems;

import com.seniorali.utils.TreeNode;

/**
 * Problem: <a href="https://leetcode.com/problems/symmetric-tree/">101. Symmetric Tree</a><br/>
 * <p>
 * Difficulty: <code>Easy</code>
 * <p>
 * Topics: <code>Tree</code>, <code>Binary Tree</code>, <code>Depth-First Search</code>, <code>Breadth-First Search</code>
 */
public class P101_SymmetricTree {

    // TODO This problem must solved by iterative, not recursive
    public boolean isSymmetric(TreeNode root) {

        return false;
    }

//    // ======================Recursive Approach======================
//    public boolean isSymmetric(TreeNode root) {
//        return isMirror(root.left, root.right);
//    }
//
//    private boolean isMirror(TreeNode p, TreeNode q) {
//        if (p == null && q == null)
//            return true;
//
//        if (p == null || q == null)
//            return false;
//
//        return p.val == q.val
//                && isMirror(p.left, q.right)
//                && isMirror(p.right, q.left);
//    }

}
