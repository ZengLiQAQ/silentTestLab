package com.lab.algorithm.solution;/**
 * Created by zengli on 2020/11/19.
 */

import com.alibaba.fastjson.JSONObject;

import java.util.HashSet;


/**
 * @ClassName 移动零
 * @Description 题目描述:
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 *
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 *
 * @Author ZengLi
 * @Date 2020/11/19 10:14
 *  leetCode解题思路: https://leetcode-cn.com/problems/move-zeroes/solution/dong-hua-yan-shi-283yi-dong-ling-by-wang_ni_ma/
 * @VerSion 1.0
 **/
public class Solution283 {
    public static void moveZeroes(int[] nums) {
        int length;
        if (nums == null || (length = nums.length) == 0) {
            return;
        }
        int j = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] != 0) {
                //它避免了数组开头是非零元素的交换也就是阻止（i==j）时交换。当i > j 时，只需要把 i 的值赋值给j 并把原位置的值置0。同时这里也把交换操作换成了赋值操作，减少了一条操作语句，理论上能更节省时间。
                if (i > j) {
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                j++;
            }
        }
    }

    public static void main(String[] args) {
        //int[] nums = {0, 1, 0, 3, 12, 0, 5};
        int[] nums = {0, 1, 0, 3, 12, 0, 5,0,0,0,0,0,0,5,6,7,8,5,2,5,78,0,0,123};
        System.out.println(JSONObject.toJSONString(nums));
        moveZeroes(nums);
        System.out.println(JSONObject.toJSONString(nums));
    }
}
