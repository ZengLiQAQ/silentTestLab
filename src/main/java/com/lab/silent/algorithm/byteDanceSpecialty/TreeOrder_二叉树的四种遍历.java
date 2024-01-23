package com.lab.silent.algorithm.byteDanceSpecialty;

import com.lab.silent.algorithm.structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树遍历:
 *  前序遍历: 根左右
 *  中序遍历: 左根右
 *  后序遍历: 左右根
 *  层序遍历: 按层从左到右遍历
 */
public class TreeOrder_二叉树的四种遍历 {
    //返回结果
    List<Integer> list = new ArrayList<>();
    /**
     * 层序遍历：
     *  根左右
     */
    public  void levelOrder(TreeNode root){
        //申明队列
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            //队列出队
            TreeNode node = queue.pop();
            list.add(node.val);
            if(node.left != null){
                //左子节点入队
                queue.push(node.left);
            }
            if(node.right != null){
                //右子节点入队
                queue.push(node.right);
            }
        }
    }

    /**
     * 前序遍历:
     * @param root
     */
    public  void dfs(TreeNode root){
        if(root == null){
            return;
        }
        //前序: 根左右
        list.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }

    /**
     * 中序遍历:
     * @param root
     */
    public  void dfs1(TreeNode root){
        if(root == null){
            return;
        }
        dfs1(root.left);
        //前序: 左根右
        list.add(root.val);
        dfs1(root.right);
    }

    /**
     * 后序遍历:
     * @param root
     */
    public  void dfs2(TreeNode root){
        if(root == null){
            return;
        }
        dfs2(root.left);
        dfs2(root.right);
        //前序: 左右根
        list.add(root.val);
    }

}
