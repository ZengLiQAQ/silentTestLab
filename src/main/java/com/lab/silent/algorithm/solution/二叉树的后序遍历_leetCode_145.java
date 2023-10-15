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
public class 二叉树的后序遍历_leetCode_145 {
    List<Integer> ans = new ArrayList<>();

    /**
     * 二叉树的后序遍历--递归
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null){
            return ans;
        }
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        ans.add(root.val);
        return ans;
    }

    /**
     * 二叉树的后序遍历--迭代
     *   前序遍历: 中左右 -> 改成 中右左 --> 翻转之后就是: 左右中了
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal2(TreeNode root) {
        if(root == null){
            return ans;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.empty()){
            TreeNode node = stack1.pop();
            stack2.push(node);
            if(node.left != null){
                stack1.push(node.left);
            }
            if(node.right != null){
                stack1.push(node.right);
            }
        }
        while(!stack2.empty()){
            ans.add(stack2.pop().val);
        }
        return ans;
    }

}
