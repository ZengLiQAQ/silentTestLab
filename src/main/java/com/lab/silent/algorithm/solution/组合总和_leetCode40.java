package com.lab.silent.algorithm.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 组合总和_leetCode40 {
    List<List<Integer>> ans =  new ArrayList<>();
    /**
     * 入参排序之后-递归回溯
     * 1 <= candidates.length <= 100
     * 1 <= candidates[i] <= 50
     * 1 <= target <= 30
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //保证入参有序-升序
        Arrays.sort(candidates);
        List<Integer> son = new ArrayList<>();
        dfs(candidates,target,son,0);
        return ans;
    }

    /**
     * @param arr 入参经过排序的数组
     * @param target 目标汇总值-每次递归都可能会减少
     * @param son 当前计算的数组
     * @param start 当前正在递归的数组元素下表
     */
    public void dfs(int[] arr,int target,List<Integer> son,int start){
        //如果目标汇总值在多次递归后<0,则说明未找到,则直接返回
        if(target < 0 ){
            return;
        }
        //最终结算的结果为0,说明我们可以找到多个元素的组合值为target,记录该son集合
        if(target == 0){
            ans.add(new ArrayList<>(son));
            return;
        }
        //这里因为已经排序,则标识后续子递归时,前面已选择的数据无需重复选择了
        for(int i= start; i < arr.length; i++){
            //剪枝
            if(i>start && arr[i] == arr[i-1]){
                continue;
            }
            //添加上当前元素
            son.add(arr[i]);
            //计算下个元素
            dfs(arr,target-arr[i],son,i+1);
            //回溯:移除最后一位,因为我们已经用过了当前节点元素,则后续的计算中我们不需要继续用了
            son.remove(son.size()-1);
        }
    }
}
