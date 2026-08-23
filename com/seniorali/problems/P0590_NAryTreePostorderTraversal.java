package com.seniorali.problems;

import java.util.*;

/**
 * Problem: <a href="https://leetcode.com/problems/n-ary-tree-postorder-traversal">590. N-ary Tree Postorder Traversal</a><br/>
 * Difficulty: {@code Easy}
 * <p>
 * Topics: {@code Stack}, {@code Tree}, {@code Depth-First Search}
 */
public class P0590_NAryTreePostorderTraversal {
    public static class Node {
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
    }

    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        postorder(root, result);
        return result;
    }

    private void postorder(Node node, List<Integer> result) {
        if (node == null) return;

        for (Node child : node.children)
            postorder(child, result);
        result.add(node.val);
    }
}

