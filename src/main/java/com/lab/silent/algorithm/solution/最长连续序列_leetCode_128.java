package com.lab.silent.algorithm.solution;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

/**
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 *
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 示例 2：
 *
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 *
 *
 * 提示：
 *
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 */
public class 最长连续序列_leetCode_128 {

    /**
     * 暴力解法,排序之后,依次对比 num[i] + 1 = num[i+1] ? ,如果相等则加一,否则归零
     *
     * @param nums
     * @return
     */
    public static int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int ans = 1;
        int tmpLen = 1;
        Arrays.sort(nums);
        for(int i = 0;i< nums.length-1;i++){
            //前后元素相等,则直接指针右移一位
            if(nums[i] == nums[i+1]){
                continue;
            }
            if(nums[i]+1 == nums[i+1]){
                tmpLen ++;
            }else{
                tmpLen = 1;
            }
            ans = Math.max(tmpLen,ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
//        int[] nums = {1,2,0,1};
        int a = longestConsecutive2(nums);
        System.out.println(a);
    }

    public static int longestConsecutive2(int[] nums) {
        //纪录理论上下一个最长序列的值
        HashMap<Integer,Integer> map = new HashMap<>();
        int maxLen = 0;
        for(int i = 0;i < nums.length; i++){
            int n = nums[i];
            if(map.containsKey(n)){
                maxLen = Math.max(maxLen,map.get(n)) + 1;
                map.put(n,maxLen);
            }else{
                map.put(n,0);
            }
        }
        return maxLen;
    }
}
