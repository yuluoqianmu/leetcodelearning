package com.shml.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的遍历
 */
public class BinaryTree {

    /**
     * 中序遍历，递归法
     */
    public List<Integer> midOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        midTraversal(root, result);
        return result;
    }

    /**
     * 中序遍历，递归法
     */
    public void midTraversal(TreeNode cur, List<Integer> list) {
        if (cur == null)
            return;
        midTraversal(cur.left, list);
        list.add(cur.val);
        midTraversal(cur.right, list);
    }

    /**
     * 前序遍历，递归法
     */
    public List<Integer> beforeOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        beforeTraversal(root, result);
        return result;
    }
    /**
     * 前序遍历，递归法
     */
    public void beforeTraversal(TreeNode cur, List<Integer> list) {
        if (cur == null)
            return;
        list.add(cur.val);
        beforeTraversal(cur.left, list);
        beforeTraversal(cur.right, list);
    }

    /**
     * 后序遍历，递归法
     */
    public List<Integer> afterOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        afterTraversal(root,result);
        return result;
    }
    /**
     * 后序遍历，递归法
     */
    public void afterTraversal(TreeNode cur, List<Integer> list) {
        if (cur == null)
            return;
        afterTraversal(cur.left, list);
        afterTraversal(cur.right, list);
        list.add(cur.val);
    }
}
