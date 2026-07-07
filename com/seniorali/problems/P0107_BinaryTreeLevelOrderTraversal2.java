package com.seniorali.problems;

import com.seniorali.utils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Problem: <a href="https://leetcode.com/problems/binary-tree-level-order-traversal-ii/">107. Binary Tree Level Order Traversal II</a><br/>
 * Difficulty: {@code Medium}
 * <p>
 * Topics: {@code Tree}, {@code Breadth-First Search}, {@code Binary Tree}
 */
public class P0107_BinaryTreeLevelOrderTraversal2 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return List.of();

        List<List<Integer>> result = new LinkedList<>();
        var deque = new ArrayDeque<TreeNode>();
        deque.offer(root);

        while (!deque.isEmpty()) {
            var size = deque.size();
            var level = new ArrayList<Integer>(size);

            for (int i = 0; i < size; i++) {
                var current = deque.poll();
                level.add(current.val);

                if (current.left != null) deque.offer(current.left);
                if (current.right != null) deque.offer(current.right);
            }
            result.addFirst(level);
        }

        return result;
    }
}