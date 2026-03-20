package com.seniorali.problems;

import com.seniorali.utils.TreeNode;

import java.util.ArrayDeque;

/**
 * Problem: <a href="https://leetcode.com/problems/minimum-depth-of-binary-tree">111. Minimum Depth of Binary Tree</a>
 * <p>
 * Difficulty: <code>Easy</code>
 * <p>
 * Topics: {@code Tree}, {@code Binary Tree}, {@code Depth First Search}, {@code Breadt First Search}
 */
public class P111_MinimumDepthOfBinaryTree {

    // Breadth First Search Approach
    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        var queue = new ArrayDeque<TreeNode>();
        queue.push(root);

        var depth = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                var temp = queue.pop();

                if (temp.left == null && temp.right == null)
                    return depth;

                if (temp.left != null) queue.offer(temp.left);
                if (temp.right != null) queue.offer(temp.right);
            }

            depth++;
        }
        return depth;
    }

//    // Recursive approach
//    public int minDepth(TreeNode root) {
//        if (root == null)
//            return 0;
//
//        var leftDepth = minDepth(root.left);
//        var rightDepth = minDepth(root.right);
//
//        if (leftDepth > 0 && rightDepth > 0) {
//            return 1 + Math.min(leftDepth, rightDepth);
//        }else {
//            return 1 + Math.max(leftDepth, rightDepth);
//        }
//    }
}