package com.seniorali.problems;

import com.seniorali.utils.TreeNode;

import java.util.*;

/**
 * Problem: <a href="https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/">987. Vertical Order Traversal of a Binary Tree</a><br/>
 * Difficulty: {@code Hard}
 * <p>
 * Topics: {@code Tree}, {@code Depth-First Search}, {@code Breadth-First Search}, {@code Binary Tree}
 */
public class P0987_VerticalOrderTraversalOfABinaryTree {
    static class Node {
        public int val;
        public int col;
        public int row;

        public Node(int val, int col, int row) {
            this.val = val;
            this.col = col;
            this.row = row;
        }

        public int getVal() {
            return val;
        }

        public int getCol() {
            return col;
        }

        public int getRow() {
            return row;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", col=" + col +
                    ", row=" + row +
                    '}';
        }
    }

    static final Comparator<Node> COMPARATOR = Comparator
            .comparing(Node::getCol)
            .thenComparing(Node::getRow)
            .thenComparing(Node::getVal);

    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        List<Node> nodes = new ArrayList<>();
        collect(root, 0, 0, nodes);
        nodes.sort(COMPARATOR);

        List<List<Integer>> result = new ArrayList<>();
        int currCol = Integer.MIN_VALUE;
        for (Node node : nodes) {
            if (node.col == currCol) {
                result.getLast().add(node.val);
            } else {
                List<Integer> colList = new ArrayList<>();
                colList.add(node.val);
                result.add(colList);
                currCol = node.col;
            }
        }
        return result;
    }

    private static void collect(TreeNode root, int col, int row, List<Node> nodes) {
        if (root == null) return;
        nodes.add(new Node(root.val, col, row));
        collect(root.left, col - 1, row + 1, nodes);
        collect(root.right, col + 1, row + 1, nodes);
    }
}