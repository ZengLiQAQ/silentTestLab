package com.lab.silent.algorithm.solution;

import com.alibaba.fastjson.JSONObject;
import com.lab.silent.algorithm.structure.Queue;

import java.util.HashSet;
import java.util.Set;

/**
 * 给你一个 非严格递增排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。然后返回 nums 中唯一元素的个数。
 *
 * 考虑 nums 的唯一元素的数量为 k ，你需要做以下事情确保你的题解可以被通过：
 *
 * 更改数组 nums ，使 nums 的前 k 个元素包含唯一元素，并按照它们最初在 nums 中出现的顺序排列。nums 的其余元素与 nums 的大小不重要。
 * 返回 k 。
 * 判题标准:
 *
 * 系统会用下面的代码来测试你的题解:
 *
 * int[] nums = [...]; // 输入数组
 * int[] expectedNums = [...]; // 长度正确的期望答案
 *
 * int k = removeDuplicates(nums); // 调用
 *
 * assert k == expectedNums.length;
 * for (int i = 0; i < k; i++) {
 *     assert nums[i] == expectedNums[i];
 * }
 * 如果所有断言都通过，那么您的题解将被 通过。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,2]
 * 输出：2, nums = [1,2,_]
 * 解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
 */
public class 删除有序数组中的重复项_leetcode26 {

    /**
     * 暴力解法: 未利用有序的特性
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        //遇见重复时,i位置后续元素往前移动的位置
        int step = 0;
        for(int i = 0; i < nums.length; i++){
            if(set.contains(nums[i])){
                //i位置后续元素往前移动位置数量
                step++;
            }else{
                //累计唯一的元素值
                ans++;
                set.add(nums[i]);
            }
            //i后的元素往前移动step位
            nums[i-step] = nums[i];
        }
        return ans;
    }


    /**
     * 双指针,利用有序的特点:(有序数组重复的元素一定会相邻)
     *
     * @param nums
     * @return
     */
    public static int removeDuplicates2(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int ans = 0;
        int left = 0;
        int right = 1;
        while(right < nums.length){
            if(nums[left] == nums[right]){
                right++;
            }else{
                //不重复项前移
                nums[left+1] = nums[right];
                left++;
                right++;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2};
        int a = removeDuplicates2(nums);
        System.out.println(a);
        System.out.println(JSONObject.toJSONString(nums));

        int[] arr = new int[]{0,0,1,1,1,2,2,3,3,4};
        int b = removeDuplicates2(arr);

        System.out.println(b);
        System.out.println(JSONObject.toJSONString(arr));

    }
}
