package com.lab.silent.algorithm.solution;

import com.lab.silent.algorithm.structure.TreeNode;

public class 二叉树的最大深度_leetCode104 {
    /**
     * 二叉树的最大深度--递归方式
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }else {
            return  Math.max(maxDepth(root.left) , maxDepth(root.right))  + 1;
        }
    }
}
