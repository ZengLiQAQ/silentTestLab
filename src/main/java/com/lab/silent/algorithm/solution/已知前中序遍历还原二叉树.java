package com.lab.silent.algorithm.solution;

import com.lab.silent.algorithm.structure.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 前序: 根左右
 * 中序: 左右根
 */
public class 已知前中序遍历还原二叉树 {
    /**
     * 构建二叉树：分治
     * 将当前树的根节点在 preorder 中的索引记为 i
     * 将当前树的根节点在 inorder 中的索引记为 l
     * 将当前树在 inorder 中的索引区间记为 [l,r]
     * 前序: 3  9       2   1   7
     *      i  (i+1)  i+1+(m-l)
     * 中序: 9 3 1 2  7
     *      l m      r
     * */
    TreeNode dfs(int[] preorder, Map<Integer, Integer> inorderMap, int i, int l, int r) {
        // 子树区间为空时终止
        if (r - l < 0)
            return null;
        // 初始化根节点,前序遍历的第一个节点就是根节点
        TreeNode root = new TreeNode(preorder[i]);
        // 查询 m ，从而划分左右子树
        int m = inorderMap.get(preorder[i]);
        // 子问题：构建左子树
        root.left = dfs(preorder, inorderMap, i + 1, l, m - 1);
        // 子问题：构建右子树
        root.right = dfs(preorder, inorderMap, i + 1 + m - l, m + 1, r);
        // 返回根节点
        return root;
    }

    /* 构建二叉树 */
    TreeNode buildTree(int[] preorder, int[] inorder) {
        // 初始化哈希表，存储 inorder 元素到索引的映射,牺牲空间换时间
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        TreeNode root = dfs(preorder, inorderMap, 0, 0, inorder.length - 1);
        return root;
    }
}
