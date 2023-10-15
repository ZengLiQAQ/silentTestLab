package com.lab.silent.algorithm.solution;

import com.lab.silent.algorithm.structure.TreeNode;

/**
 *
 */
public class 对称二叉树_leetCode_101 {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return false;
        }
        return check(root.left,root.right);
    }

    /**
     * 递归实现: 本质上是去判断,对应左节点的左节点 与 对应 右节点的右节点是否相等,或者 是左节点的右节点 与 对应 右节点的左节点是否相等
     * @param left
     * @param right
     * @return
     */
    public boolean check(TreeNode left,TreeNode right){
        //定义递归终止条件
        if(left == null && right == null){
            return true;
        }
        if(left == null || right == null){
            return false;
        }
        if(left.val != right.val){
            return  false;
        }
        return  check(left.left,right.right) && check(left.right,right.left);
    }
}
