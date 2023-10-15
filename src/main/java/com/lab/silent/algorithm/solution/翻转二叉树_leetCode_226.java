package com.lab.silent.algorithm.solution;/**
 * Created by zengli on 2020/11/27.
 */

import com.lab.silent.algorithm.structure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName Solution226
 * @Description 翻转一棵二叉树。
 * @Author ZengLi
 * @Date 2020/11/27 16:17
 * @VerSion 1.0
 **/
public class 翻转二叉树_leetCode_226 {

    /**
     * 深度优先DFS: 递归
     * 确定可重复执行元素: node, left = right ; right = left
     *
     */
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return root;
        }
        //临时保存左子树
        TreeNode tmp = root.left;
        //将子树交换位置
        root.left = invertTree(root.right);
        root.right = invertTree(tmp);
        return root;
    }

    /**
     * 广度优先BFS: 迭代 需要临时变量
     * 每次跌点当前层的左右子树,并交换对应的位置
     *
     */
    public TreeNode invertTree2(TreeNode root) {
        if(root == null){
            return root;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode curr = queue.remove();
            TreeNode left = curr.left;
            TreeNode right = curr.right;
            //交换位置
            curr.left = right;
            curr.right = left;
            //如果当前的left不为空,则将当前的节点的加入队列
            if(left != null){
                queue.add(left);
            }
            if(right != null){
                queue.add(right);
            }

        }
        return root;
    }
}
