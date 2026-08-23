package com.seniorali.problems;

import com.seniorali.utils.TreeNode;

/**
 * Problem: <a href="https://leetcode.com/problems/construct-string-from-binary-tree/">606. Construct String from Binary Tree</a><br/>
 * Difficulty: {@code Medium}
 * <p>
 * Topics: {@code String}, {@code Tree}, {@code Depth-First Search}, {@code Binary Tree}
 */
public class P0606_ConstructStringFromBinaryTree {

    public String tree2str(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        append(root, builder);
        return builder.toString();
    }

    private void append(TreeNode root, StringBuilder builder) {
        if (root == null)
            return;

        builder.append(root.val);

        if (root.left == null && root.right == null)
            return;

        builder.append('(');
        append(root.left, builder);
        builder.append(')');

        if (root.right != null) {
            builder.append('(');
            append(root.right, builder);
            builder.append(')');
        }
    }

}