package com.lab.silent.algorithm.solution;

import com.lab.silent.algorithm.structure.Stack;
import com.lab.silent.algorithm.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树遍历:
 *  前序遍历: 根左右
 *  中序遍历: 左根右
 *  后序遍历: 左右根
 *  层序遍历: 按层从左到右遍历
 */
public class 二叉树的中序遍历_leetCode_94 {
    List<Integer> ans = new ArrayList<>();

    /**
     * 二叉树中序遍历--递归的方式
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null){
            return ans;
        }
        inorderTraversal(root.left);
        //之前add即中序遍历
        ans.add(root.val);
        inorderTraversal(root.right);
        return ans;
    }

    /**
     * 二叉树中序遍历--迭代: 左根右
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        if(root == null){
            return ans;
        }
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.empty() || cur != null){
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode node = stack.pop();
            ans.add(node.val);
            if(node.right != null){
                cur = node.right;
            }
        }
        return ans;
    }
}
