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
public class 二叉树的前序遍历_leetCode_144 {

    List<Integer> ans = new ArrayList<>();

    /**
     * 二叉树前序遍历--递归的方式
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null){
            return ans;
        }
        ans.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return ans;
    }

    /**
     * 二叉树前序遍历--迭代: 根左右
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        if(root == null){
            return ans;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()){
            TreeNode node = stack.pop();
            ans.add(node.val);
            //这里需要注意右子树需要先入栈,才能保证后出栈时: 根左右的顺序
            if(node.right != null){
                stack.push(node.right);
            }
            if(node.left != null){
                stack.push(node.left);
            }
        }
        return ans;
    }


}
