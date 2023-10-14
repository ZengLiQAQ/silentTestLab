package com.lab.silent.algorithm.solution;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。
 * 请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
 *
 * 示例 1：
 *
 * 输入：nums = [4,3,2,7,8,2,3,1]
 * 输出：[5,6]
 * 示例 2：
 *
 * 输入：nums = [1,1]
 * 输出：[2]
 *
 *
 * 提示：
 *
 * n == nums.length
 * 1 <= n <= 105
 * 1 <= nums[i] <= n
 * 进阶：你能在不使用额外空间且时间复杂度为 O(n) 的情况下解决这个问题吗? 你可以假定返回的数组不算在额外空间内。
 */
public class 找到所有消失的数字_leetcode448 {

    /**
     * 暴力解法
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers2(int[] nums){
        List<Integer> ans = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            if(!set.contains(i)){
                ans.add(i);
            }
        }
        return ans;
    }

    /**
     * 不引入额外空间(不含返回结果),时间复杂度为O(n)
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] nums){
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            //每次使用对应idx上的数字的绝对值减一: 别问为什么要减一,因为[1, n] 范围的数字与对应索引的差值为1
            int x = Math.abs(nums[i]) - 1;
            //如果已经变成负数了说明原数组中有重复数,直接跳过即可
            if(nums[x] >0){
                nums[x] =  -nums[x];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] < 0){
                continue;
            }
            //将对应的索引再次转化数字 + 1
            ans.add(i+1);
        }
        return ans;
    }
}
