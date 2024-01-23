package com.lab.silent.algorithm.solution;

import com.alibaba.fastjson.JSONObject;
import com.lab.silent.algorithm.structure.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 返回二叉树搜索值的节点返回根节点到这些节点的路径
 */
public class 返回二叉树搜索值的节点返回根节点到这些节点的路径 {

    static List<TreeNode> path;
    static List<List<TreeNode>> res;

    /* 前序遍历：例题二 */
    static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        // 尝试
        path.add(root);
        if (root.val == 7) {
            // 记录解
            res.add(new ArrayList<>(path));
        }
        preOrder(root.left);
        preOrder(root.right);
        // 回退
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.listToTree(Arrays.asList(1, 7, 3, 4, 5, 6, 7));
        System.out.println("\n初始化二叉树");
        System.out.println(JSONObject.toJSONString(root));

        // 前序遍历
        path = new ArrayList<>();
        res = new ArrayList<>();
        preOrder(root);

        System.out.println("\n输出所有根节点到节点 7 的路径");
        for (List<TreeNode> path : res) {
            List<Integer> vals = new ArrayList<>();
            for (TreeNode node : path) {
                vals.add(node.val);
            }
            System.out.println(vals);
        }
    }

}
