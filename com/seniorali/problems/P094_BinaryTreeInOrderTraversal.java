package com.seniorali.problems;

import com.seniorali.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Problem: <a href="https://leetcode.com/problems/binary-tree-inorder-traversal/">94. Binary Tree Inorder Traversal</a><br/>
 * <p>
 * Difficulty: <code>Easy</code>
 * <p>
 * Topics: <code>Binary Tree</code>, <code>Stack</code>, <code>Tree</code>, <code>Depth-First Search</code>
 */
public class P094_BinaryTreeInOrderTraversal {

    // ===============================Stack Solution===============================
    // TODO This problem must solved by iterative, not recursive
    public static List<Integer> inorderTraversal(TreeNode root) {
        var stack = new Stack<TreeNode>();
        var result = new ArrayList<Integer>();

        return List.of();
    }


//    // ===============================Recursive Solution===============================
//    public static List<Integer> inorderTraversal(TreeNode root) {
//        var result = new ArrayList<Integer>();
//        inOrderTraversalRecursive(root, result);
//        return result;
//    }
//
//    public static void inOrderTraversalRecursive(TreeNode root, List<Integer> result) {
//        if (root == null)
//            return;
//
//        inOrderTraversalRecursive(root.left, result);
//        result.add(root.val);
//        inOrderTraversalRecursive(root.right, result);
//    }

    static void main(String[] args) {
        TreeNode root = new TreeNode(
                1,
                new TreeNode(
                        2,
                        new TreeNode(4),
                        new TreeNode(5,
                                new TreeNode(6),
                                new TreeNode(7)
                        )
                ),
                new TreeNode(
                        3,
                        null,
                        new TreeNode(8, new TreeNode(9), null)
                )
        );

        var result = inorderTraversal(root);
        System.out.println(result);
    }
}
