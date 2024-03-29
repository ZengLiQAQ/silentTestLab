package com.lab.silent.algorithm.solution;/**
 * Created by zengli on 2020/11/27.
 */

import java.util.HashSet;

/**
 * @ClassName Solution3
 * @Description 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
 * @Author ZengLi
 * @Date 2020/11/27 16:33
 * @VerSion 1.0
 **/
public class Solution3 {
    /**
     * 关键词拆解: 长度为n,数字都在 0 ~ n-1 范围内, 2 <= n <= 100000
     * 思路: 通过hashSet做是否重复判断
     */

    public int findRepeatNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for(int num: nums){
            if(!set.add(num)){
                return num;
            }
        }
        return 0;
    }

    /**
     * 思路: 范围在 0 ~ n-1 ,则按照一个萝卜一个坑的逻辑,
     * 以num作为指针,如果对应指针里有值了,
     * 则就返回这个值,即说明这个值重复了
     * @param nums
     * @return
     */
    public int findRepeatNumber2(int[] nums) {
        int temp;
        for(int i=0;i<nums.length;i++){
            while (nums[i]!=i){
                if(nums[i]==nums[nums[i]]){
                    return nums[i];
                }
                temp=nums[i];
                nums[i]=nums[temp];
                nums[temp]=temp;
            }
        }
        return -1;
    }
}
