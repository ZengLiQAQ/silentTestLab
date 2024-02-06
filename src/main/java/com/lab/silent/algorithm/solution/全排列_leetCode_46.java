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

    public List<List<Integer>> allMatch(int[] nums){
        //申明匹配列
        LinkedList<Integer> path = new LinkedList<>();
        //申明最终返回结果
        List<List<Integer>> res = new ArrayList<>();
        //记录选择过程中是否选择
        boolean[] used = new boolean[nums.length];
        //回溯获取组合结果
        backTrack(nums,used,path,res);
        return res;
    }
    public void backTrack(int[] nums,boolean[] used,LinkedList<Integer> path,List<List<Integer>> res){
        //记录满足条件的解
        if(path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        //遍历所有的组合方式
        for (int i = 0; i < nums.length; i++) {
            //剪枝: 如果组合中包含重复数据则跳过
            if(used[i]){continue;}
            //记录不重复的数字路径
            path.add(nums[i]);
            used[i] = true;
            //进入下一次递归
            backTrack(nums,used,path,res);
            //回溯上次的选择
            path.removeLast();
            used[i] = false;
        }
    }
}
