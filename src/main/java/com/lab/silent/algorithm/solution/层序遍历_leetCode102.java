package com.lab.silent.algorithm.solution;

import com.lab.silent.algorithm.structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[9,20],[15,7]]
 * 示例 2：
 *
 * 输入：root = [1]
 * 输出：[[1]]
 * 示例 3：
 *
 * 输入：root = []
 * 输出：[]
 *
 *
 * 提示：
 *
 * 树中节点数目在范围 [0, 2000] 内
 * -1000 <= Node.val <= 1000
 */
public class 层序遍历_leetCode102 {
    /**
     * 层序遍历: 根左右
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if(root != null) queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> tmp = new ArrayList<>();
            for(int i = queue.size(); i > 0;i--){
                TreeNode node = queue.pop();
                tmp.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            res.add(tmp);
        }
        return res;
    }

}
