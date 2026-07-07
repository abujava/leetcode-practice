package com.seniorali.problems;

import com.seniorali.utils.TreeNode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;

/**
 * Problem: <a href="https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/">103. Binary Tree Zigzag Level Order Traversal</a><br/>
 * Difficulty: {@code Medium}
 * <p>
 * Topics: {@code Tree}, {@code Breadth-First Search}, {@code Binary Tree}
 */
public class P0103_BinaryTreeZigzagLevelOrderTraversal {

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return List.of();

        List<List<Integer>> result = new LinkedList<>();
        var deque = new LinkedList<TreeNode>();

        deque.offer(root);
        boolean leftToRight = true;
        while (!deque.isEmpty()) {
            var level = new LinkedList<Integer>();

            var size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();

                if (leftToRight)
                    level.addLast(node.val);
                else
                    level.addFirst(node.val);

                if (node.left != null) deque.offer(node.left);
                if (node.right != null) deque.offer(node.right);
            }
            result.add(level);
            leftToRight = !leftToRight;
        }

        return result;
    }

    static void main() {
        new ArrayDeque<>();
        var root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        System.out.println(zigzagLevelOrder(root));
    }
}
