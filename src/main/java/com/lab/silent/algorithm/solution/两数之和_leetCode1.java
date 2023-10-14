package com.lab.silent.algorithm.solution;/**
 * Created by zengli on 2020/11/18.
 */

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName 两数之和
 * @Description 题目描述:
 * 给定一个整数数组 nums和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * <p>
 * 解题思路:
 * @VerSion 1.0
 **/
public class 两数之和_leetCode1 {

    /**
     * 解题思路:
     *
     * 标签：哈希映射
     * 这道题本身如果通过暴力遍历的话也是很容易解决的，时间复杂度在 O(n2)O(n2)
     * 由于哈希查找的时间复杂度为 O(1)O(1)，所以可以利用哈希容器 map 降低时间复杂度
     * 遍历数组 nums，i 为当前下标，每个值都判断map中是否存在 target-nums[i] 的 key 值
     * 如果存在则找到了两个值，如果不存在则将当前的 (nums[i],i) 存入 map 中，继续遍历直到找到为止
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        //申明map,用于收集所有数组元素: key: nums的元素,value : 对应元素的 index
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        //申明结果,用于搜集对应组合的结果
        List<int[]> result = new ArrayList<>(nums.length);
        //申明初始结果的二维数组数量
        int resultCount = 0 ;
        for (int i = 0; i < nums.length; i++) {
            //如果map中包含target - 当前数的值,则将当前的索引添加到result中
            if(map.containsKey(target-nums[i])){
                result.add(new int[]{map.get(target-nums[i]),i});
                resultCount ++;
                //根据返回结果的数量控制是否打开,本题仅需要一个结果,则直接break即可
                break;
            }
            map.put(nums[i],i);
        }
        return resultCount > 0 ? result.get(0):new int[0];
    }


    public static void main(String[] args) {

        int[] nums = {2,5,4,1,3};
        int[] result = twoSum(nums,5);
        System.out.println(JSONObject.toJSONString(nums));
        System.out.println(JSONObject.toJSONString(result));
    }
}
