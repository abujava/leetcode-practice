package com.seniorali.problems;

import com.seniorali.utils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Problem: <a href="https://leetcode.com/problems/binary-tree-postorder-traversal/">145. Binary Tree Postorder Traversal</a>
 * <p>
 * Difficulty: <code>Easy</code>
 * <p>
 * Topics: {@code Tree}, {@code Binary Tree}, {@code Depth First Search}, {@code Stack}
 */
public class P0145_BinaryTreePostOrderTraversal {

    /**
     * Iterative Approach Using Single Stack
     */
    public List<Integer> postorderTraversalSingleStack(TreeNode root) {
        if (root == null) return List.of();

        var stack = new Stack<TreeNode>();
        var result = new ArrayList<Integer>();

        TreeNode lastVisited = null;
        var current = root;
        while (!stack.isEmpty() || current != null) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.peek();

            if (current.right != null && current.right != lastVisited) {
                current = current.right;
            } else {
                stack.pop();
                result.add(current.val);
                lastVisited = current;
                current = null;
            }
        }

        return result;
    }

    /**
     * Iterative Approach Using Double Stack
     */
    public List<Integer> postorderTraversalTwoStack(TreeNode root) {
        if (root == null) return List.of();

        var s1 = new Stack<TreeNode>();
        var s2 = new Stack<TreeNode>();

        s1.push(root);
        while (!s1.isEmpty()) {
            var temp = s1.pop();
            s2.push(temp);

            if (temp.left != null)
                s1.push(temp.left);

            if (temp.right != null)
                s1.push(temp.right);
        }

        var result = new ArrayList<Integer>(s2.size());
        while (!s2.isEmpty()) {
            result.add(s2.pop().val);
        }

        return result;
    }

    /**
     * Recursive Approach
     */
    public List<Integer> postorderTraversalRecursive(TreeNode root) {
        return postorderTraversalRecursive(root, new ArrayList<>());
    }

    private List<Integer> postorderTraversalRecursive(TreeNode root, List<Integer> result) {
        if (root == null) return result;

        postorderTraversalRecursive(root.left, result);
        postorderTraversalRecursive(root.right, result);
        result.add(root.val);
        return result;
    }

}