package com.lab.silent.algorithm.solution;

/**
 * @author gouqi
 * @version 1.0
 * @description:
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 *
 * 子数组是数组中元素的连续非空序列。
 * 示例 1：
 *
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 * 示例 2：
 *
 * 输入：nums = [1,2,3], k = 3
 * 输出：2
 *
 * @date 2023/10/27 17:36
 */
public class 和为K的子数组_leetCode_560 {

    /**
     * 子数组是数组中元素的连续非空序列 --> 通过构建前缀和的方式一次统计汇总
     *
     * 例: tmpSum: 统计滑动窗口左边界到最右边界值的和
     *  [-2,-1, 0, 1, 1,2,5, 8,10] k = 7
     *  [-2,-3,-3,-2,-1,1,6,14,24] --> 构建前缀和,遍历前缀和元素与k对比
     *
     *    l            r   --> tmpSum
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        return ans;
    }

    /**
     * 暴力解法
     * @param nums
     * @param k
     * @return
     */
    public static int subarraySum2(int[] nums, int k) {
        int ans = 0;
        for(int i=0;i<nums.length;i++){
            int sum = nums[i];
            for(int j = i+1;j<nums.length;j++){
                sum += nums[j];
                if(sum == k){
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int a = subarraySum2(nums,3);
        System.out.println(a);
    }

}
