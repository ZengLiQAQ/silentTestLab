package com.lab.silent.algorithm.solution;

import com.lab.silent.algorithm.structure.Node;

import java.util.ArrayList;
import java.util.List;

public class N叉树的最大深度_leetCode559 {
    /**
     * N叉树的最大深度--递归方式 -- 参考二叉树的最大深度
     * @param root
     * @return
     */
    public int maxDepth(Node root) {
        if(root == null){
            return 0;
        }else {
            int maxDepth = 0;
            for(Node child:root.children){
                maxDepth = Math.max(maxDepth,maxDepth(child));
            }
            return  maxDepth;
        }
    }
}
