package com.seniorali.problems;

import java.util.*;

/**
 * Problem: <a href="https://leetcode.com/problems/n-ary-tree-preorder-traversal">589. N-ary Tree Preorder Traversal</a><br/>
 * Difficulty: {@code Easy}
 * <p>
 * Topics: {@code Stack}, {@code Tree}, {@code Depth-First Search}
 */
public class P0589_NAryTreePreorderTraversal {
    public List<Integer> preorder(Node root) {
        if (root == null) return List.of();
        List<Integer> result = new ArrayList<>();
        traverse(root, result);
        return result;
    }

    public void traverse(Node root, List<Integer> result) {
        result.add(root.val);
        if (!root.children.isEmpty()) {
            root.children.forEach(n -> traverse(n, result));
        }
    }


    private static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }

        @Override
        public String toString() {
            return "Node{" + val + '}';
        }
    }

}
