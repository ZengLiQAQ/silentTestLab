package com.lab.silent.algorithm.solution;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 字节一面 {
    /**
     * 技能点skill[] 表示每个同学的技能点数,偶数同学,两个同学组一队,
     *  1.每队的技能点数之和相等
     *  2.每队的技能点数乘积之和为多少,如果条件2不满足,则返回-1
     * @param nums
     * @param
     * @return
     */
    public static  int allMatch(int[] nums){
        //申明匹配列
        LinkedList<Integer> path = new LinkedList<>();
        //申明最终返回结果
        List<List<Integer>> res = new ArrayList<>();
        //记录选择过程中是否选择
        boolean[] used = new boolean[nums.length];
        //初始团队技能点
        int tmpSum = nums[0]+nums[1];
        //回溯获取组合结果
        backTrack(nums,used,path,res,tmpSum);
        if(res.size()==0){
            return -1;
        }
        if(res.size() != nums.length/2){
            return -1;
        }
        return res.stream().map(t->{
            System.out.println(JSONObject.toJSONString(t));
            return t.get(0)*t.get(1);}).reduce(Integer::sum).get();
    }
    public static void backTrack(int[] nums,boolean[] used,LinkedList<Integer> path,List<List<Integer>> res,int tmpSum){
        //记录满足条件的解
        if(path.size() == 2 && path.get(0)+path.get(1) == tmpSum){
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
            //重新累计下一次技能点之和
            if(res.size()>0){
                tmpSum = res.get(0).get(0) + res.get(0).get(1);
            }
            //进入下一次递归
            backTrack(nums,used,path,res,tmpSum);
            //回溯上次的选择
            path.removeLast();
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] skill = {3,2,5,1,3,4};
        int tmp = allMatch(skill);
        System.out.println(tmp);
    }
}
