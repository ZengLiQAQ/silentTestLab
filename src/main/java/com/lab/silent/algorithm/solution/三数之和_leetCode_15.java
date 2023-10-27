package com.lab.silent.algorithm.solution;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author gouqi
 * @version 1.0
 * @description:
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 *
 * 你返回所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 解释：
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 * 注意，输出的顺序和三元组的顺序并不重要。
 * @date 2023/10/27 16:20
 */
public class 三数之和_leetCode_15 {
    /**
     * [-1,0,1,2,-1,-4]
     * [-4,-1,-1,0,1,2]
     *   p  l        r --> nums[l] + nums[r] < 0-(-4) ,即说明当前双指针对应元素的值偏小,又因为数组已经升序排序了,这个时候逐步右移l,
     *   p         l r --> 一直右移到最右侧,说明当前定点值太小,逐步右移定点P,再执行上述的操作过程
     *      p  l     r --> nums[l] + nums[r] = 0-(-1) ,满足条件,再逐步右移定点P,再执行上述的操作过程
     *        p  l   r --> nums[l] + nums[r] > 0-(-1) ,即说明当前双指针对应元素的值偏大,又因为数组已经升序排序了,这个时候逐步左移r
     *        p  l r   --> 当移动到 l + 1 位置时,nums[l] + nums[r] = 0-(-1),满足条件,再逐步右移定点P,再执行上述的操作过程
     *           p l r --> 当p点已经移动到了倒数第三位的时候,只需要计算最后三位的和即可(这里还有一个隐形条件,如果,定点已经到正数了则最右侧的值不管怎么加都是大于0的,这个时候直接跳出循环即可)
     * 输出:
     * [-1,-1,2]
     * [-1,0,1]
     *
     * 核心思路:
     *    1.对数组进行排序,从最左侧定点之后,再通过双指针的方式依次遍历定点+1 与 len -1 对应位置的值
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        if(nums.length<3){
            return null;
        }
        //优先数组排序
        Arrays.sort(nums);
        if(nums[0] > 0){
            return null;
        }

        List<List<Integer>> ans = new ArrayList<>();
        int p = 0;
        //指定定点边界
        while(p < nums.length-1 && nums[p] <= 0){
            int target = 0-nums[p];
            //左指针
            int l = p+1;
            //右指针
            int r = nums.length -1;
            while(l<r){
                int c = nums[l] + nums[r];
                if(c < target){
                    //即说明当前双指针对应元素的值偏小,又因为数组已经升序排序了,这个时候逐步右移l
                    l++;
                }else if(c > target){
                    //即说明当前双指针对应元素的值偏大,又因为数组已经升序排序了,这个时候逐步左移r
                    r--;
                }else{
                    //避免重复:如果l+1位置的值与l位置的一致,则继续右移才行
                    while (l<r && nums[l]==nums[l+1]){ l++;}
                    //避免重复:如果r-1位置的值与r位置的一致,则继续左移才行
                    while (l<r && nums[r]==nums[r-1]){ r++;}
                    //相等:则满足条件,添加元素
                    List<Integer> list =  new ArrayList<>(3);
                    list.add(nums[p]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    ans.add(list);
                    break;
                }
            }
            //右移定点
            p++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        Object o = threeSum(nums);
        System.out.println(JSONObject.toJSONString(o));

        int[] nums2 = {0,0,0};
        Object o2 = threeSum(nums2);
        System.out.println(JSONObject.toJSONString(o2));
    }
}
