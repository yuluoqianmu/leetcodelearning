package com.shml.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树前序，中序，后序遍历，迭代法
 */
public class BinaryTree_2 {
    /**
     * 中序遍历，迭代法
     */
    public List<Integer> midOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while(cur != null || !stack.empty()) {

            if(cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                result.add(cur.val);
                cur = cur.right;
            }
        }
        return result;
    }

    /**
     * 官方答案
     */
    public List<Integer> midOrderTraversal_3(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {

            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            result.add(root.val);
            root = root.right;

        }

        return result;
    }

    /**
     * 中序遍历，迭代标记法
     */
    public List<Integer> midOrderTraversal_2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if (root != null) {
            stack.push(root);
        }

        while (!stack.empty()) {
            TreeNode node = stack.peek();

            if (node != null) {
                stack.pop();
                if (node.right != null) {
                    stack.push(node.right);
                }

                stack.push(node);
                stack.push(null);

                if (node.left != null) {
                    stack.push(node.left);
                }
            } else {
                stack.pop();
                node = stack.peek();
                stack.pop();
                result.add(node.val);
            }
        }

        return result;
    }


    /**
     * 前序遍历，迭代法
     */
    public List<Integer> beforeOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.empty()) {

            while (root != null) {
                result.add(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }

        return result;
    }


    /**
     * 后序遍历，迭代法
     */
    public List<Integer> afterOrderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {

            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();

            if (root.right == null || root.right == prev) {
                res.add(root.val);
                prev = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }

        }
        return res;
    }

}
