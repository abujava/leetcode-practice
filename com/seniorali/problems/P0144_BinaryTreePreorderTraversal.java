package com.seniorali.problems;

import com.seniorali.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Problem: <a href="https://leetcode.com/problems/binary-tree-preorder-traversal/">144. Binary Tree Preorder Traversal</a><br/>
 * <p>
 * Difficulty: <code>Easy</code>
 * <p>
 * Topics: <code>Binary Tree</code>, <code>Stack</code>, <code>Tree</code>, <code>Depth-First Search</code>
 */
public class P0144_BinaryTreePreorderTraversal {

    // Iterative Approach
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return List.of();

        var result = new ArrayList<Integer>();
        var stack = new Stack<TreeNode>();
        var current = root;

        while (!stack.isEmpty() || current != null){
            while (current != null) {
                result.add(current.val);
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            current = current.right;
        }

        return result;
    }

//    // Recursive Approach
//    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> result = new ArrayList<>();
//        preOrderTraversal(root, result);
//        return result;
//    }
//
//    private void preOrderTraversal(TreeNode root, List<Integer> result) {
//        if (root == null)
//            return;
//
//        result.add(root.val);
//        preOrderTraversal(root.left, result);
//        preOrderTraversal(root.right, result);
//    }
}
