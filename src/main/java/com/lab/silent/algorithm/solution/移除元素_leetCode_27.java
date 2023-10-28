package com.lab.silent.algorithm.solution;

import com.alibaba.fastjson.JSONObject;

/**
 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。

 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。

 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。



 说明:

 为什么返回数值是整数，但输出的答案是数组呢?

 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。

 你可以想象内部操作如下:

 // nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
 int len = removeElement(nums, val);

 // 在函数里修改输入数组对于调用者是可见的。
 // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
 for (int i = 0; i < len; i++) {
 print(nums[i]);
 }


 示例 1：

 输入：nums = [3,2,2,3], val = 3
 输出：2, nums = [2,2]
 解释：函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。你不需要考虑数组中超出新长度后面的元素。例如，函数返回的新长度为 2 ，而 nums = [2,2,3,3] 或 nums = [2,2,0,0]，也会被视作正确答案。
 示例 2：

 输入：nums = [0,1,2,2,3,0,4,2], val = 2
 输出：5, nums = [0,1,4,0,3]
 解释：函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。注意这五个元素可为任意顺序。你不需要考虑数组中超出新长度后面的元素。


 提示：

 0 <= nums.length <= 100
 0 <= nums[i] <= 50
 0 <= val <= 100
 */
public class 移除元素_leetCode_27 {
    /**
     * 核心总结: 理解且灵活应用 索引下标与元素个数的转化, arr - 1 即 索引,索引 +1 就是对应元素个数
     * [0], 1 , 2 , 2 , 3 , 0 , 4 , 2  - i=0 , ans= 1 -- i+1 = ans 不存在重复
     *  0 ,[1], 2 , 2 , 3 , 0 , 4 , 2  - i=1 , ans= 2 -- i+1 = ans 不存在重复
     *  0 , 1 ,[2], 2 , 3 , 0 , 4 , 2  - i=2 , ans= 2 -- i+1 > ans 存在重复
     *  0 , 1 , 2 ,[2], 3 , 0 , 4 , 2  - i=3 , ans= 2 -- i+1 > ans 存在重复
     *  0 , 1 ,(3), 2 ,[2], 0 , 4 , 2  - i=4 , ans= 3 -- i+1 > ans 存在重复 交换 i 位置与 ans-1 位置的值,
     *  0 , 1 , 3 ,(0), 2 ,[2], 4 , 2  - i=5 , ans= 4 -- i+1 > ans 存在重复 交换 i 位置与 ans-1 位置的值,
     *  0 , 1 , 3 , 0 ,(4), 2 ,[2], 2  - i=6 , ans= 5 -- i+1 > ans 存在重复 交换 i 位置与 ans-1 位置的值,
     *  0 , 1 , 3 , 0 , 4 , 2 , 2 ,[2] - i=7 , ans= 5 -- i+1 > ans 存在重复 交换 i 位置与 ans-1 位置的值,
     *
     * @param nums
     * @param val
     * @return
     */

    public  static int removeElement(int[] nums, int val) {
        //记录所有非val的元素数量,
        int ans = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] != val){
                //正常情况下,如果不存在等于val元素下,ans会与i+1(索引+1即为数组个数)相等的
                ans ++;
                //如果存在 i+1 > ans的情况下,说明前面存在某个元素等于val
                if(i+1 > ans){
                    nums[ans-1] = nums[i];
                    nums[i] = val;
                }
            }
        }
        return ans;
    }

    /**
     * 0,1,2,2,3,0,4,2
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {0,1,2,2,3,0,4,2};
        int a = removeElement(arr,2);
        System.out.println(JSONObject.toJSONString(arr));
        System.out.println(a);
    }

}
