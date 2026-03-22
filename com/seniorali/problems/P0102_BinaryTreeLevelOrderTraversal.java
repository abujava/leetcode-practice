package com.seniorali.problems;

import com.seniorali.utils.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Problem: <a href="https://leetcode.com/problems/binary-tree-level-order-traversal/">102. Binary Tree Level Order Traversal</a><p>
 * Difficulty: {@code Medium}
 * <p>
 * Topics: {@code Tree}, {@code Breadth-First Search}, {@code Binary Tree}
 */
public class P0102_BinaryTreeLevelOrderTraversal {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return List.of();

        List<List<Integer>> result = new LinkedList<>();
        var deque = new LinkedList<TreeNode>();

        deque.offer(root);
        while (!deque.isEmpty()){
            var level = new LinkedList<Integer>();

            var size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.pop();
                level.add(node.val);

                if (node.left != null) deque.offer(node.left);
                if (node.right != null) deque.offer(node.right);
            }
            result.add(level);
        }

        return result;
    }

    static void main() {
        var root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(levelOrder(root));
    }
}