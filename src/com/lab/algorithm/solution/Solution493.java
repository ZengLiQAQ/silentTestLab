package com.lab.algorithm.solution;/**
 * Created by zengli on 2020/11/28.
 */

/**
 * @ClassName Solution493
 * @Description 给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。
 *
 * 你需要返回给定数组中的重要翻转对的数量。
 *
 * 示例 1:
 *
 * 输入: [1,3,2,3,1]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [2,4,3,5,1]
 * 输出: 3
 * 注意:
 *
 * 给定数组的长度不会超过50000。
 * 输入数组中的所有数字都在32位整数的表示范围内。
 *
 * @Author ZengLi
 * @Date 2020/11/28 14:02
 * @VerSion 1.0
 **/
public class Solution493 {
    //思路:
    //数组的计算,可以借助map来优化
    //1.遍历nums,依次和后续的元素比较,一直到nums.length -2 即截止
    public int reversePairs(int[] nums) {
        if(nums == null || nums.length == 0)return 0;
        int reuslt = 0;
        for(int i = 0 ; i< nums.length -1; i ++){
            for(int j = i+1; j < nums.length; j++){

                if(nums[i] * 1L  > 2L *nums[j]){
                    reuslt++;
                }
            }
        }
        return reuslt;
    }

    public static void main(String[] args) {
        int[] nums = {2147483647,2147483647,2147483647,2147483647,2147483647,2147483647};
        Solution493 solution = new Solution493();
        int result = solution.reversePairs(nums);
        System.out.println(result);
    }
}
