package com.lab.silent.algorithm.solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author gouqi
 * @version 1.0
 * @description: 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 *
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出：[[1]]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * nums 中的所有整数 互不相同
 * @date 2023/11/9 10:41
 */
public class 全排列_leetCode_46 {
    public List<List<Integer>> permute(int[] nums) {
        //排列组合结果
        LinkedList<List<Integer>> res = new LinkedList<>();
        //单个排列
        LinkedList<Integer> path = new LinkedList<>();
        dfs(res,nums,path);
        return res;
    }

    public void dfs(List<List<Integer>> res, int[] nums, LinkedList<Integer> path){
        if(path.size() == nums.length){
            //对于每次添加的单个排列，应该都是不同的引用对象
            res.add( new ArrayList<Integer>(path) );
        }
        for(int i=0; i<nums.length; i++){
            //当前层中，已添加的数不再考虑
            if(path.contains(nums[i]))  {continue;}
            //未添加的数则存放
            path.add(nums[i]);
            //进入下一层（递归）
            dfs(res, nums, path);
            //从深层节点向浅层节点回溯
            path.removeLast();
        }
    }
}
