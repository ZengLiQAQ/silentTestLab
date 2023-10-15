package com.lab.silent.algorithm.solution;

import com.lab.silent.algorithm.structure.TreeNode;

public class 平衡二叉树_leetCode110 {
    /**
     * 平衡二叉树核心:
     *   类似于后续遍历: 左右根,左子树平衡,右子树平衡,则根平衡,如果不平衡则直接返回-1即可,则当前树不平衡
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    public int height(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        //如果子树存在不平衡,或者高度差大于1,则返回-1,否则
        if(leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1){
            return -1;
        }else{
            //返回当前左右子树中的最高的高度+1(自身的高度)
            return Math.max(leftHeight,rightHeight) + 1;
        }
    }



}
