package com.lab.algorithm.solution;/**
 * Created by zengli on 2020/11/26.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName 多数元素
 * @Description 多数元素
 *
给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。

你可以假设数组是非空的，并且给定的数组总是存在多数元素。

示例 1:

输入: [3,2,3]
输出: 3
示例 2:

输入: [2,2,1,1,1,2,2]
输出: 2

 * @Author ZengLi
 * @Date 2020/11/26 16:28
 * @VerSion 1.0
 **/
public class Solution169 {

    public static int majorityElement(int[] nums) {
        //定义map: key: nums元素, value: 该元素出现的次数
        Map<Integer,Integer> numCountMap = new HashMap<Integer,Integer>(nums.length);
        //当前元素中促销次数最多的元素的次数
        int maxCount = 0;
        //最大次数的num值
        int maxCountNum = 0;
        for(int num: nums){
            Integer value = numCountMap.get(num);
            if(value == null){
                value = 0;
            }
            value++;
            numCountMap.put(num,value);
            if(maxCount < value){
                maxCount = value;
                maxCountNum = num;
            }
        }
        return maxCountNum;
    }

    public static void main(String[] args) {
        int[] nums = {6,5,5};
        int result = majorityElement(nums);
        System.out.println(result);
    }
}
