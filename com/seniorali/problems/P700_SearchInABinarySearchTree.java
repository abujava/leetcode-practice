package com.seniorali.problems;

import com.seniorali.utils.TreeNode;

import java.util.LinkedList;

/**
 * Problem: <a href="https://leetcode.com/problems/search-in-a-binary-search-tree/">700. Search in a Binary Search Tree</a><br/>
 * Difficulty: {@code Easy}
 * <p>
 * Topics: {@code Tree}, {@code Binary Search Tree}, {@code Binary Tree}
 */
public class P700_SearchInABinarySearchTree {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;

        if (root.val == val)
            return root;
        else if (root.val > val)
            return searchBST(root.left, val);
        else
            return searchBST(root.right, val);
    }
}