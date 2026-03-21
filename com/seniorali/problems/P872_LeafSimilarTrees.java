package com.seniorali.problems;

import com.seniorali.utils.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Problem: <a href="https://leetcode.com/problems/leaf-similar-trees/">872. Leaf-Similar Trees</a><br/>
 * Difficulty: {@code Easy}
 * <p>
 * Topics: {@code Tree}, {@code Depth-First Search}, {@code Binary Tree}
 */
public class P872_LeafSimilarTrees {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leafValues1 = new LinkedList<>();
        List<Integer> leafValues2 = new LinkedList<>();

        collectLeafValues(root1, leafValues1);
        collectLeafValues(root2, leafValues2);

        return leafValues1.equals(leafValues2);
    }

    private void collectLeafValues(TreeNode root, List<Integer> leafValues) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            leafValues.add(root.val);
            return;
        }
        collectLeafValues(root.left, leafValues);
        collectLeafValues(root.right, leafValues);
    }

//    public static boolean leafSimilar(TreeNode p, TreeNode q) {
//        Deque<Integer> deque = collectLeaf(p);
//
//        var stack = new Stack<TreeNode>();
//        var current = q;
//        while (!stack.isEmpty() || current != null) {
//            while (current != null) {
//                stack.push(current);
//                current = current.left;
//            }
//            current = stack.pop();
//            if (current.left == null && current.right == null) {
//                if (deque.isEmpty() || deque.pop() != current.val)
//                    return false;
//            }
//            current = current.right;
//        }
//        return deque.isEmpty();
//    }
//
//    private static Deque<Integer> collectLeaf(TreeNode root) {
//        Deque<Integer> deque = new LinkedList<>();
//        var stack = new Stack<TreeNode>();
//        var current = root;
//
//        while (!stack.isEmpty() || current != null) {
//            while (current != null) {
//                stack.push(current);
//                current = current.left;
//            }
//            current = stack.pop();
//            if (current.left == null && current.right == null) {
//                deque.offer(current.val);
//            }
//            current = current.right;
//        }
//        return deque;
//    }
}