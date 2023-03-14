package com.learn.leetcode.DFS.MaximumDepthOfBinaryTree;

import java.util.Arrays;
import java.util.List;

/**
 * 104. Maximum Depth of Binary Tree
 */
public class MainApp {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public TreeNode buildTree(List<Integer> list) {
            TreeNode root = new TreeNode(list.get(0));
            for (Integer item : list) {
                if (item == null) continue;
                addRecursive(root, item);
            }
            return root;
        }

        public TreeNode addRecursive(TreeNode root, int value) {
            if (root == null) {
                return new TreeNode(value);
            }
            if (value < root.val) {
                // Add node left
                root.left = addRecursive(root.left, value);
            } else if (value > root.val) {
                // Add node right
                root.right = addRecursive(root.right, value);
            } else {
                // Do not anything
                return root;
            }
            return root;
        }

    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxLeft = maxDepth(root.left);
        int maxRight = maxDepth(root.right);

        return Math.max(maxLeft, maxRight) + 1;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode();
        System.out.println(treeNode.buildTree(Arrays.asList(3, 9, 20, null, null, 15, 7)));
    }
}
