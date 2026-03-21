package com.seniorali.utils;

import java.util.List;

public class BinaryTreeNodeWrapper {
    public TreeNode root;


    public void insert(int data) {
        TreeNode newNode = new TreeNode(data);

        if (root == null) {
            root = newNode;
            return;
        }

        TreeNode current = root;
        while (true) {
            if (data < current.val) {
                if (current.left == null) {
                    current.left = newNode;
                    return;
                }
                current = current.left;

            } else if (data > current.val) {
                if (current.right == null) {
                    current.right = newNode;
                    return;
                }
                current = current.right;
            }
        }
    }

    public void insert(List<Integer> values) {
        values.forEach(this::insert);
    }

    public void insert(int ...values) {
        for (int value : values) {
            insert(value);
        }
    }

}
