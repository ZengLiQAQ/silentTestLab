package com.lab.silent.algorithm.solution;/**
 * Created by zengli on 2020/11/27.
 */

import com.lab.silent.algorithm.structure.TreeNode;

import java.util.LinkedList;

/**
 * @ClassName Solution617
 * @Description 合并二叉树
 * @Author ZengLi
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 * <p>
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
 * 注意: 合并必须从两个树的根节点开始。
 * @Date 2020/11/27 9:50
 * @VerSion 1.0
 **/
public class 合并二叉树_leetCode_617 {
    /**
     * 二叉树类问题主要从两个角度考虑: 深度优先--> 递归, 广度优先 --> 迭代
     * 递归思路: 1.拆解可重复执行元素
     * 2.梳理可重复执行流程
     * 3.直接从最后一次执行开始逆向推导,第n次的运算是第n-1次的结果
     * ①.重复执行元素: node , left ,right
     * ②.重复执行流程: 参数: t1,t2, 申明node, node.left = t1.left + t2.left; node.right = t1.right + t2.right,
     *   每次递归的去合并两个树的左子树和右子树
     *
     *   时间复杂度：O(\min(m,n))O(min(m,n))，其中 mm 和 nn 分别是两个二叉树的节点个数。对两个二叉树同时进行深度优先搜索，只有当两个二叉树中的对应节点都不为空时才会对该节点进行显性合并操作，因此被访问到的节点数不会超过较小的二叉树的节点数。
     *
     *   空间复杂度：O(\min(m,n))O(min(m,n))，其中 mm 和 nn 分别是两个二叉树的节点个数。空间复杂度取决于递归调用的层数，递归调用的层数不会超过较小的二叉树的最大高度，最坏情况下，二叉树的高度等于节点数。
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        TreeNode treeNode = new TreeNode(t1.val + t2.val);
        treeNode.left = mergeTrees(t1.left, t2.left);
        treeNode.right = mergeTrees(t1.right, t2.right);
        return treeNode;
    }


    /**
     * 迭代实现用的是广度优先算法，广度优先就需要额外的数据结构来辅助了，我们可以借助栈或者队列来完成。
     * 只要两颗树的左节点都不为 null，就把将他们放入队列中；同理只要两棵树的右节点都不为 null 了，也将他们放入队列中。
     * 然后我们不断的从队列中取出节点，把他们相加。
     * 如果出现 树 1 的 left 节点为 null，树 2 的 left 不为 null，
     * 直接将树 2 的 left 赋给树 1 就可以了
     * ；同理如果树 1 的 right 节点为 null，
     * 树 2 的不为 null，将树 2 的 right 节点赋给树 1。
     *
     * @param t1
     * @param t2
     * @return
     */
    public TreeNode mergeTrees2(TreeNode t1, TreeNode t2) {
        if( t1 == null || t2 == null){
            return t1 == null ? t2 : t1;
        }
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(t1);
        queue.add(t2);
        //循环的边界: 每次往队列中放入要计算的左右子树,每次出队取出对应节点位置的,t1和t2的节点进行计算,一直到队列中的数据都处理完成
        while(queue.size() > 0){
            //先入先出,取出原左边树t1
            TreeNode q1 = queue.remove();
            //后入后出,取出原右边树t2
            TreeNode q2 = queue.remove();
            //每次累加两个节点的val
            q1.val = q1.val + q2.val;
            //如果q1,q2的左子树都不为null,则将对应的左子树入队,且要保证模板树再前
            if(q1.left != null && q2.left != null){
                queue.add(q1.left);
                queue.add(q2.left);
            }else if(q1.left == null){
                q1.left = q2.left;
            }
            //右子树,与左子树同理
            if(q1.right != null && q2.right != null){
                queue.add(q1.right);
                queue.add(q2.right);
            }else if(q1.right == null){
                q1.right = q2.right;
            }
        }

        return t1;
    }

}
